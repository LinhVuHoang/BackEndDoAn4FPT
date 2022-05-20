package com.example.restapiprojectsem4.Service;

import com.example.restapiprojectsem4.Entity.Product;
import com.example.restapiprojectsem4.specification.ObjectFilter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Page<Product> findAll(ObjectFilter objectFilter);
    Optional<Product> findById(int id);
    Product created(Product product);
    Product edit(int id,Product product);
    List<Product> findByName(String name);
    Product deleted(int id);
}
