package com.hb.spring.data.jpa.tutorial;

import com.hb.spring.data.jpa.tutorial.entity.Employee;
import com.hb.spring.data.jpa.tutorial.entity.Laptop;
import com.hb.spring.data.jpa.tutorial.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringDataJpaTutorialApplication
{
//	@Autowired
//	private EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaTutorialApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception
//	{
//
//		Employee employee = new Employee();
//		employee.setEmployeeName("Harneet Bector");
//		employee.setAbout("I am a software developer");
//		employee.setEmployeeId(14);
//
//
//		Laptop laptop = new Laptop();
//		laptop.setModelNumber("14314");
//		laptop.setBrand("Dell");
//		laptop.setLaptopId(1231);
//
//		laptop.setEmployee(employee);
//
//		employee.setLaptop(laptop);
//
//
//		Employee save = employeeRepository.save(employee);
//		log.info("Saved employee : {}", save.getEmployeeName());
//
//
//
//
//
//		Employee employee = employeeRepository.findById(14).get();
//		log.info("Name is {}", employee.getEmployeeName());
//
//
//		Laptop laptop = employee.getLaptop();
//		log.info("Laptop {}, {}", laptop.getBrand(), laptop.getModelNumber());
//
//
//	}


}
