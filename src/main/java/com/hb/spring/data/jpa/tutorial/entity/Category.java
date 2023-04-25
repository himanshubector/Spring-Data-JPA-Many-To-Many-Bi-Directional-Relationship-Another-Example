package com.hb.spring.data.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_category")
public class Category
{
    @Id
    private String categoryId;
    private String title;


    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    // The extra table created in many to many relationship here will only get populated when we are going to set the Products into the Category table in the CategoryRepositoryTest class since Category is the main table here which is defining the many to many relationship with the help of 'products' attribute

    // 'cascade' here denotes that if we save the Category, products will also get saved along with the Category.

    // Here, 'mappedBy' attribute denotes that extra table should not be created to represent the 'products' attribute in the Category table.
    // Rather, in order to represent the 'categories' attribute in the Product table which signifies many to many relationship, only one extra table should be created


    // This 'mappedBy' tells that only one way should be used to handle this many to many relationship which is happening through 'categories' attribute in the Product entity

}
