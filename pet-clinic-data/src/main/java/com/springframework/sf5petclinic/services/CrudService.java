package com.springframework.sf5petclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {
    T findByID(ID id);

    Set<T> findAll();

    T Save(T object);

    void deleteById(ID id);

    void delete(T object);
}
