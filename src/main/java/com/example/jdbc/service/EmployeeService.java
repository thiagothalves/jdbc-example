package com.example.jdbc.service;

import com.example.jdbc.core.Employee;

import com.example.jdbc.repository.EmployeeRepositoryDataBaseImpl;
import com.example.jdbc.util.GenericService;
import com.example.jdbc.util.RepositoryDataBase;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService implements GenericService<Employee, Long> {

    private final EmployeeRepositoryDataBaseImpl employeeRepositoryDataBase;

    public EmployeeService(EmployeeRepositoryDataBaseImpl employeeRepositoryDataBase) {
        this.employeeRepositoryDataBase = employeeRepositoryDataBase;
    }

    @Override
    public RepositoryDataBase<Employee, Long> getRepository() {
        return employeeRepositoryDataBase;
    }
}
