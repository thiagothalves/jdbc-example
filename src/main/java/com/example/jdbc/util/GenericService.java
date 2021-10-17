package com.example.jdbc.util;


import com.example.jdbc.exception.NotFoundException;


import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
public interface GenericService<T extends AbstractEntity, I> {

    RepositoryDataBase<T, I> getRepository();

    default T findById(I id) {
        Optional<T> result = getRepository().findOne(id);
        return result.
                orElseThrow(() -> new NotFoundException(String.
                        format("%s with id %s not found", getGenericName(), id)));
    }

    default void create(T entity) {
        int result = getRepository().insert(entity);
        if (result != 1) {
            throw new IllegalStateException("try again later");
        }
    }


    default void remove(I id) {
        Optional<T> find = getRepository().findOne(id);
        int result = getRepository().remove(id);
        if (result != 1) {
            throw new IllegalStateException("could not remove " + getGenericName());
        }
    }


    default String getGenericName() {
        return ((Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
    }

    default List<T> findAll() {
        return getRepository().findAll();
    }


}
