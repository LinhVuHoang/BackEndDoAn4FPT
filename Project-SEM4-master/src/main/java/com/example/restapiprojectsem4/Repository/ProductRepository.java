package com.example.restapiprojectsem4.Repository;

import com.example.restapiprojectsem4.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
    @Query("select p from Product p where p.status = 'ACTIVE'")
    List<Product> findAllByStatus();
    @Query("select p from Product p where upper(p.name) like %:name%")
    List<Product> findByName(String name);
}
