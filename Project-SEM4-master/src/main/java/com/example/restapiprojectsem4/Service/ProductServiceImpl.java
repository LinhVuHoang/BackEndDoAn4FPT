package com.example.restapiprojectsem4.Service;

import com.example.restapiprojectsem4.Entity.Product;
import com.example.restapiprojectsem4.Enums.Status;
import com.example.restapiprojectsem4.Repository.ProductRepository;
import com.example.restapiprojectsem4.specification.ObjectFilter;
import com.example.restapiprojectsem4.specification.ProductSpecification;
import com.example.restapiprojectsem4.specification.SearchCriteria;
import com.example.restapiprojectsem4.util.SQLConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(ObjectFilter objectFilter) {
        Specification<Product> spec = Specification.where(null);

        PageRequest paging = PageRequest.of(objectFilter.getPage() - 1, objectFilter.getPageSize());

        if(objectFilter.getStatus().equals(Status.DELETE.name())) {
            spec = spec.and(new ProductSpecification(new SearchCriteria(ObjectFilter.STATUS, SQLConstant.EQUAL, Status.DELETE.name())));
        }else {
            spec = spec.and(new ProductSpecification(new SearchCriteria(ObjectFilter.STATUS, SQLConstant.EQUAL, Status.ACTIVE.name())));
        }
        if(objectFilter.getDetail() != null && objectFilter.getDetail().length() >0){
            spec = spec.and(new ProductSpecification(new SearchCriteria(ObjectFilter.DETAIL, SQLConstant.LIKE,objectFilter.getDetail())));
        }
        if (objectFilter.getNameProduct() != null && objectFilter.getNameProduct().length() > 0){
            spec = spec.and(new ProductSpecification(new SearchCriteria(ObjectFilter.NAME, SQLConstant.LIKE,objectFilter.getNameProduct())));
            System.out.println(objectFilter.getNameProduct());
        }
        if (objectFilter.getCategoryId() > 0){
            System.out.println(objectFilter.getCategoryId());
            spec = spec.and(new ProductSpecification(new SearchCriteria("categoryId",SQLConstant.EQUAL,objectFilter.getCategoryId())));
        }
        if (objectFilter.getMaxPrice() > 0){
            spec = spec.and(new ProductSpecification(new SearchCriteria(ObjectFilter.PRICE,SQLConstant.GREATER_THAN_OR_EQUAL_TO,objectFilter.getMaxPrice())));
        }
        if (objectFilter.getMinPrice() > 0){
            spec = spec.and(new ProductSpecification(new SearchCriteria(ObjectFilter.PRICE,SQLConstant.LESS_THAN_OR_EQUAL_TO,objectFilter.getMinPrice())));
        }
        return productRepository.findAll(spec,paging);
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Product created(Product product) {
        Product p = productRepository.save(product);
        return p;
    }

    @Override
    public Product edit(int id,Product product) {
        Product exist = productRepository.getById(id);
        if(exist == null){
            return null;
        }
        exist.setName(product.getName());
        exist.setPrice(product.getPrice());
        exist.setThumbnail(product.getThumbnail());
        exist.setQuantity(product.getQuantity());
        exist.setDescription(product.getDescription());
        exist.setDetail(product.getDetail());
        exist.setStatus(product.getStatus());
        exist.setCategoryId(product.getCategoryId());
        return productRepository.save(exist);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name.trim().toUpperCase());
    }

    @Override
    public Product deleted(int id) {
        Product deleted = productRepository.getById(id);
        if(deleted == null){
            return null;
        }
        deleted.setStatus("DELETE");
        return productRepository.save(deleted);
    }
}
