package com.example.jdbc.employee;

import com.example.jdbc.core.Employee;
import com.example.jdbc.repository.EmployeeRepositoryDataBaseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class EmployeeRepositoryDataBaseTest {

    @Autowired
    EmployeeRepositoryDataBaseImpl employeeRepositoryDataBase;

    @Autowired
    private JdbcTemplate template;



    @Test
    public void insertEmployee() {
        Employee employee = new Employee(10L, "Thiago", "thiago@gmail.com", LocalDate.now());
        Integer insert = employeeRepositoryDataBase.insert(employee);
        Assertions.assertNotNull(insert);
    }
}
