package com.example.restapiprojectsem4.Repository;

import com.example.restapiprojectsem4.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("select c from Category c where c.status = 'ACTIVE'")
    List<Category> findAllByStatus();
    @Query("select c from Category c where c.name like %:name%")
    List<Category> findByName(String name);
}
