package com.hb.spring.data.jpa.tutorial.repository;

import com.hb.spring.data.jpa.tutorial.entity.Category;
import com.hb.spring.data.jpa.tutorial.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class CategoryRepositoryTest
{
    @Autowired
    private CategoryRepository categoryRepository;



    @Test
    public void saveProductsWithCategories()
    {

        Product product1 = Product.builder()
                .productId("pid1")
                .productName("IPhone 14 Max Pro")
                .build();

        Product product2 = Product.builder()
                .productId("pid2")
                .productName("Samsung S22 Ultra")
                .build();

        Product product3 = Product.builder()
                .productId("pid3")
                .productName("Samsung 12341")
                .build();




        Category category1 = Category.builder()
                .categoryId("cid1")
                .title("Electronics")
                .products(List.of(product1,product2))
                .build();

        Category category2 = Category.builder()
                .categoryId("cid2")
                .title("Mobile Phone")
                .products(List.of(product1,product3))
                .build();



        categoryRepository.save(category1);
        categoryRepository.save(category2);


    }



    @Transactional
    @Test
    public void getCategoryProductsSize()
    {
        Category category = categoryRepository.findById("cid1").get();
        log.info("Category Products size : {}", category.getProducts().size());

    }

}