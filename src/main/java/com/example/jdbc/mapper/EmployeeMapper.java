package com.example.jdbc.mapper;

import com.example.jdbc.core.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmployeeMapper implements RowMapper<Employee> {


    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email"),
                LocalDate.parse(rs.getString("birth_date")));
    }
}
