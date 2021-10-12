package com.example.jdbc.util;

import java.util.List;
import java.util.Optional;

public interface RepositoryDataBase <T,I> {
    List<T> findAll();
    int insert(T entity);
    int remove(I id);
    Optional<T> findOne(I id);


}
