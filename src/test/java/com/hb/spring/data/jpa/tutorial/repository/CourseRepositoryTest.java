package com.hb.spring.data.jpa.tutorial.repository;

import com.hb.spring.data.jpa.tutorial.entity.Course;
import com.hb.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}