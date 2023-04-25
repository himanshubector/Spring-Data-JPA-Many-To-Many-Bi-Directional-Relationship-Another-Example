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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course
{
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;


    private String title;

    private Integer credit;


    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;  // This 'course' here refers to the 'course' attribute in the CourseMaterial entity class

                                            // Thus, here we are defining that One to One mapping is already defined by the 'course' attribute in CourseMaterial entity class

                                            // Thus, we are defining here One To One Bi-Directional Mapping



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;




    // Many To Many Relationship

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"
            )
    )
    private List<Student> students;


    public void addStudents(Student student)
    {
        if(students == null) students = new ArrayList<>();
        students.add(student);
    }

}
