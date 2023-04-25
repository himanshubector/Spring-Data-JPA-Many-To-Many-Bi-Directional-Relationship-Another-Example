package com.hb.spring.data.jpa.tutorial.repository;

import com.hb.spring.data.jpa.tutorial.entity.Category;
import com.hb.spring.data.jpa.tutorial.entity.Course;
import com.hb.spring.data.jpa.tutorial.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ProductRepositoryTest
{
    @Autowired
    private ProductRepository productRepository;


//    @Test
//    public void saveProductsWithCategories()
//    {
//
//    }
}