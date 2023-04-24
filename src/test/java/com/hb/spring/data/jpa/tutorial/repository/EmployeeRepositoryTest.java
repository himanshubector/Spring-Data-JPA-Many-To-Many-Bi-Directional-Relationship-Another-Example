package com.hb.spring.data.jpa.tutorial.repository;

import com.hb.spring.data.jpa.tutorial.entity.Address;
import com.hb.spring.data.jpa.tutorial.entity.Course;
import com.hb.spring.data.jpa.tutorial.entity.Employee;
import com.hb.spring.data.jpa.tutorial.entity.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.attribute.standard.OrientationRequested;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class EmployeeRepositoryTest
{
    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    public void saveEmployeeWithAddress()
    {

        Employee employee = Employee.builder()
                .employeeName("Ravi Tiwari")
                .about("I am software engineer")
                .employeeId(15)
                .build();


        Address address1 = Address.builder()
                .addressId(131)
                .street("235/235")
                .city("Ludhiana")
                .country("IND")
                .employee(employee)
                .build();


        Address address2 = Address.builder()
                .addressId(133)
                .street("442/445")
                .city("Gurgaon")
                .country("IND")
                .employee(employee)
                .build();


       // employee.setAddressList(List.of(address1,address2));


        //  OR

        List<Address> addresses = new ArrayList<>();

        addresses.add(address1);
        addresses.add(address2);

        employee.setAddressList(addresses);


        Employee emp = employeeRepository.save(employee);

        log.info("Employee created with Address : {} , {}", emp.getEmployeeName(), emp.getAbout());


    }
}