package com.hb.spring.data.jpa.tutorial.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_address")
public class Address
{
    @Id
    private int addressId;
    private String street;
    private String city;
    private String country;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Many to One relationship -> This will make Uni-directional One to Many relationship defined in Employee entity class as Bi-directional
}
