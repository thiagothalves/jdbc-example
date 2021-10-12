package com.example.jdbc.repository;

import com.example.jdbc.core.Employee;
import com.example.jdbc.mapper.EmployeeMapper;
import com.example.jdbc.util.RepositoryDataBase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryDataBaseImpl implements RepositoryDataBase<Employee, Long> {


    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepositoryDataBaseImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> findAll() {
        var sql = """
                SELECT id, name, email, birth_date
                FROM employee
                LIMIT 100;
                 """;
        return jdbcTemplate.query(sql, new EmployeeMapper());
    }

    @Override
    public int insert(Employee entity) {
        var sql = """
                INSERT INTO employee(name, email, birth_date)
                VALUES (?, ?, ?);
                 """;
        return jdbcTemplate.update(
                sql,
                entity.getName(), entity.getEmail(), entity.getBirthDate()
        );
    }

    @Override
    public int remove(Long id) {
        var sql = """
                DELETE FROM employee
                WHERE id = ?
                """;
         return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Employee> findOne(Long id) {
        var sql = """
                SELECT id, name, email, birth_date
                FROM employee
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new EmployeeMapper(), id)
                .stream()
                .findFirst();
    }
}

