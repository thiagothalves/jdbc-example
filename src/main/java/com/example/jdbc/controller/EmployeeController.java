package com.example.jdbc.controller;

import com.example.jdbc.core.Employee;
import com.example.jdbc.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("{id}")
    public Employee findOneEmployee(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public void insertEmployee(@RequestBody Employee employee) {
        employeeService.create(employee);
    }

    @DeleteMapping("{id}")
    public void removeEmployee(@PathVariable("id") Long id) {
        employeeService.remove(id);
    }
}
