package com.tutorial.springboot_thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tutorial.springboot_thymeleaf.entity.Employee;
import com.tutorial.springboot_thymeleaf.repository.EmployeeRepository;

@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public ModelAndView showEmployees () {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("employees", employeeRepository.findAll());
        return modelAndView;
    }


    @GetMapping("/addEmployeeForm")
    public ModelAndView addEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("pages/add-employee-form");
        Employee newEmployee = new Employee();
        modelAndView.addObject("newEmployee", newEmployee);
        return modelAndView;
    }

    @PostMapping("/")
    public String saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @GetMapping("deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/editEmployeeForm")
    public ModelAndView editEmployeeForm(@RequestParam Long employeeId) {
        ModelAndView modelAndView = new ModelAndView("pages/add-employee-form");
        Employee employee = employeeRepository.findById(employeeId).get();
        modelAndView.addObject("newEmployee", employee);
        return modelAndView;
    }
}
