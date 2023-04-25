package com.hb.spring.data.jpa.tutorial.repository;

import com.hb.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long>
{
    // Custom method to fetch the Students record based on the first name of the Student
    public List<Student> findByFirstName(String firstName);


    // Custom method to fetch the Students record based on some of  matching characters in the first name of the Student
    public List<Student> findByFirstNameContaining(String name);


    public List<Student> findByLastNameNotNull();


    public List<Student> findByGuardianName(String guardianName);


    public Student findByStudentId(Long id); // either this custom method or predefined findById() can be used



    // findAll()


    // findById(Long id)


    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);


    public Student findByEmailId(String emailId);


    // JPQL - Java Persistence Query Language
    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentByEmailAddressMethodUsingJPQL(String emailId);



    // JPQL - Java Persistence Query Language
    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailAddressMethodUsingJPQL(String emailId);



    // Native SQL Query
    @Query(
            value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    public Student getStudentByEmailAddressMethodUsingNativeQuery(String emailId);



    // Native SQL Query Named Params
    @Query(
            value = "select * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    public Student getStudentByEmailAddressMethodUsingNativeQueryNamedParams(@Param("emailId") String studentEmailId);



    // Using @Transactional and @Modifying Annotation
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    public int updateStudentNameByEmailId(String firstName, String emailId);

}
