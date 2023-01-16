package com.tutorial.springboot_thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.springboot_thymeleaf.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
