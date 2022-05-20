package com.example.restapiprojectsem4.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@Entity
@CrossOrigin
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "thumbnail")
    private String thumbnail;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "description",columnDefinition = "TEXT")
    private String description;
    @Column(name = "detail",columnDefinition = "TEXT")
    private String detail;
    @Column(name = "status")
    private String status;
    @Column(name = "categoryId")
    private int categoryId;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "categoryId",insertable = false,updatable = false)
    private Category category;
}
