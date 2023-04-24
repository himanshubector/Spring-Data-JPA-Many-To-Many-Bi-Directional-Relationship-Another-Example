package com.hb.spring.data.jpa.tutorial.repository;

import com.hb.spring.data.jpa.tutorial.entity.Course;
import com.hb.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseRepositoryTest
{
    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void printCourses()
    {
        List<Course> courses = courseRepository.findAll();

        System.out.println("courses = " + courses);
    }



    @Test   // For testing Many to One Relationship
    public void saveCourseWithTeacher()
    {
        Teacher teacher = Teacher.builder()
                .firstName("Sachin")
                .lastName("Tendulkar")
                .build();

        Course course = Course
                .builder()
                .title("React JS")
                .credit(9)
                .teacher(teacher)
                .build();


        courseRepository.save(course);

    }





    // Paging and Sorting in Spring Data JPA
    @Test
    public void findAllPagination()
    {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);

        Pageable secondPageWithTwoRecords = PageRequest.of(1, 5);

        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();

        long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();

        long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println("totalPages ------- " + totalPages);

        System.out.println("totalElements -------- " + totalElements);

        System.out.println("courses -------- " + courses);

    }



    @Test
    public void findAllSorting()
    {
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        5,
                        Sort.by("title")
                );


        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );


        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        6,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))
                );


        List<Course> courses = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();

        System.out.println("courses wrt to Sorting ----------- " + courses);
    }



    @Test  // Test the custom method created in the CourseRepository for Sorting
    public void printFindByTitleContaining()
    {
        Pageable firstPageTenRecords = PageRequest.of(0,10);

        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

}