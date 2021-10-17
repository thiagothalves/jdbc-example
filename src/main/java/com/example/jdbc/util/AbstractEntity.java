package com.example.jdbc.util;

import org.springframework.data.annotation.Id;

public abstract class AbstractEntity {

    protected Long id;

    public Long getId() {
        return id;
    }


}