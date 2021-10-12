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
        return employeeService.findAllEmployees();
    }

    @GetMapping("{id}")
    public Employee findOneEmployee(@PathVariable("id") Long id) {
        return employeeService.findOneEmployee(id);
    }

    @PostMapping
    public void insertEmployee(@RequestBody Employee employee) {
        employeeService.insertEmployee(employee);
    }

    @DeleteMapping("{id}")
    public void removeEmployee(@PathVariable("id") Long id) {
        employeeService.removeEmployee(id);
    }
}
