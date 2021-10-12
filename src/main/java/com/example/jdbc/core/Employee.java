package com.example.jdbc.core;

import java.time.LocalDate;

public class Employee {
    private final Long id;
    private final String name;
    private final String email;
    private final LocalDate birthDate;

    public Employee(Long id, String name, String email, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
