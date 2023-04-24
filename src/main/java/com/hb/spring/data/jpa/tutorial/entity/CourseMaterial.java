package com.hb.spring.data.jpa.tutorial.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial
{

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;


    private String url;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;

    // 'optional = false' means here that 'course' is a required field and we need to set it to CourseMaterial before saving the CourseMaterial

    // With FetchType.LAZY and @ToString(exclude = "course") at the entity Class level,
    // it will fetch the details of the Parent only i.e. CourseMaterial


    // With FetchType.EAGER, it will fetch the details of the Child along with the Parent i.e.
    // both Course and CourseMaterial details


}
