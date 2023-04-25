package com.hb.spring.data.jpa.tutorial.repository;

import com.hb.spring.data.jpa.tutorial.entity.Guardian;
import com.hb.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
// @DataJpaTest - This annotation will help us to test our Repository layer and once the operation is completed,
// it will flush the data so db will not be impacted. But currently we want to impact our db,
// we want to store our values into the db, so we are commenting out this annotation.
class StudentRepositoryTest
{
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentWithoutGuardian()
    {
        Student student = Student.builder()
                .emailId("Ravi@gmail.com")
                .firstName("Ravi")
                .lastName("Sharma")
                //.guardianName("Nikhil")
                //.guardianEmail("nikhil@gmail.com")
                //.guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }


    @Test
    public void getAllStudents()
    {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }



    @Test
    public void saveStudentWithGuardian()
    {
        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .name("Nikhil")
                .mobile("9999956324")
                .build();

        Student student = Student.builder()
                .firstName("Shivam")
                .emailId("shivam@gmail.com")
                .lastName("Jain")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }


    @Test
    public void getStudentByFirstName()
    {
        List<Student> students =
                studentRepository.findByFirstName("shivam");

        System.out.println("students = " + students);
    }



    @Test
    public void getStudentByFirstNameContaining()
    {
        List<Student> students =
                studentRepository.findByFirstNameContaining("sh");

        System.out.println("matching students = " + students);
    }


    @Test
    public void getStudentBasedOnGuardianName()
    {
        List<Student> students =
                studentRepository.findByGuardianName("Nikhil");

        System.out.println("students based on guardian name = " + students);
    }


    @Test
    public void getStudentBasedOnLastNameNotNull()
    {
        List<Student> students =
                studentRepository.findByLastNameNotNull();

        System.out.println("students based on last name not null = " + students);
    }


    @Test
    public void getStudentBasedOnStudentIdPredefinedMethod()
    {
        Optional<Student> studentOptional = studentRepository.findById(2L);

        Student student = studentOptional
                            .orElseThrow(() -> new RuntimeException("Student not found"));


        System.out.println("student based on student id.. = " + student);
    }


    @Test
    public void getStudentBasedOnStudentIdCustomMethod()
    {
        Optional<Student> studentOptional = Optional.ofNullable(studentRepository.findByStudentId(2L));

        Student student = studentOptional
                .orElseThrow(() -> new RuntimeException("Student not found"));

        System.out.println("student based on student id.. = " + student);
    }


    /*
        Here's an example of how to map an Optional<Student> object to a Student object using Java 8 streams:

        Optional<Student> studentOptional = studentRepository.findById(2L);

            Student student = studentOptional
                .map(studentObj -> new Student(studentObj.getName(), studentObj.getAge()))
                .orElseThrow(() -> new RuntimeException("Student not found"));


                OR


                Using the orElse() method:

Optional<Student> studentOptional = studentRepository.findById(2L);

Student student = studentOptional
                .orElseThrow(() -> new RuntimeException("Student not found"));

In this case, we are using the orElse() method of the Optional class to return the contained Student object if it is present, or a default null value if it is not. Note that we are throwing a RuntimeException if the Optional object is empty, which will be caught by the calling method.


OR


Using a ternary operator:

Optional<Student> studentOptional = studentRepository.findById(2L);

Student student = studentOptional
                .isPresent() ? studentOptional.get() : null;
In this case, we are using a ternary operator to return the contained Student object if it is present, or a default null value if it is not. Note that we are calling the isPresent() and get() methods of the Optional class to check for the presence of the Student object and to obtain its value, respectively.



OR


Using the ifPresent() method:

Optional<Student> studentOptional = studentRepository.findById(2L);

Student student = null;

studentOptional.ifPresent(studentObj -> student = new Student(studentObj.getName(), studentObj.getAge()));
In this case, we are using the ifPresent() method of the Optional class to execute a lambda expression if the Optional object is not empty. The lambda expression creates a new Student object by passing the name and age of the original Student object as parameters, and assigns it to the student variable. Note that we are assigning a default null value to the student variable before the lambda expression is executed.


Refer for the Query Methods in Spring Data JPA :  https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods



     */



    @Test
    public void getStudentByFirstNameAndLastNameMethod()
    {
        List<Student> students =
                studentRepository.findByFirstNameAndLastName("shivam","kumar");

        System.out.println("students with first and last name = " + students);
    }


    @Test
    public void getStudentByEmailIdMethod()
    {
        Student student =
                studentRepository.findByEmailId("shabbir@gmail.com");

        System.out.println("student with email id = " + student);
    }


    @Test
    public void getStudentByEmailAddressUsingJPQL()
    {
        Student student =
                studentRepository.getStudentByEmailAddressMethodUsingJPQL("shivam@gmail.com");

        System.out.println("student using query annotation.... = " + student);
    }



    @Test
    public void getStudentFirstNameByEmailAddressUsingJPQL()
    {
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddressMethodUsingJPQL("shivam@gmail.com");

        System.out.println("firstName...... = " + firstName);
    }


    @Test
    public void getStudentByEmailAddressUsingNativeSQLQuery()
    {
        Student student =
                studentRepository.getStudentByEmailAddressMethodUsingNativeQuery("shivam@gmail.com");

        System.out.println("student using native query .... = " + student);
    }



    @Test
    public void getStudentByEmailAddressUsingNativeQueryNamedParams()
    {
        Student student =
                studentRepository.getStudentByEmailAddressMethodUsingNativeQueryNamedParams("shivam@gmail.com");

        System.out.println("student using query named params = " + student);
    }



    @Test
    public void updateStudentNameByEmailIdUsingTransactionalAndModifyingAnnotation()
    {
        studentRepository.updateStudentNameByEmailId("shabbir dawoodi", "shabbir@gmail.com");
    }


}