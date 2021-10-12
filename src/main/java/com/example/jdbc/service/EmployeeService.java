package com.example.jdbc.service;

import com.example.jdbc.core.Employee;
import com.example.jdbc.exception.NotFoundException;
import com.example.jdbc.repository.EmployeeRepositoryDataBaseImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepositoryDataBaseImpl employeeRepositoryDataBase;

    public EmployeeService(EmployeeRepositoryDataBaseImpl employeeRepositoryDataBase) {
        this.employeeRepositoryDataBase = employeeRepositoryDataBase;
    }

    public List<Employee> findAllEmployees() {
        return employeeRepositoryDataBase.findAll();
    }

    public void insertEmployee(Employee employee) {
        int result = employeeRepositoryDataBase.insert(employee);
        if (result != 1) {
            throw new IllegalStateException("try again later");
        }
    }

    public void removeEmployee(Long id) {
        Optional<Employee> employee = employeeRepositoryDataBase.findOne(id);
        employee.ifPresentOrElse(movie -> {
            int result = employeeRepositoryDataBase.remove(id);
            if (result != 1) {
                throw new IllegalStateException("could not remove employee");
            }
        }, () -> {
            throw new NotFoundException(String.format("employee with id %s not found", id));
        });
    }

    public Employee findOneEmployee(Long id) {
        return employeeRepositoryDataBase.findOne(id)
                .orElseThrow(() -> new NotFoundException(String.format("employee with id %s not found", id)));
    }

}
