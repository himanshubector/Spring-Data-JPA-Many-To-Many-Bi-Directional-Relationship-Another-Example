package com.hb.spring.data.jpa.tutorial.repository;

import com.hb.spring.data.jpa.tutorial.entity.Category;
import com.hb.spring.data.jpa.tutorial.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, String>
{


}
