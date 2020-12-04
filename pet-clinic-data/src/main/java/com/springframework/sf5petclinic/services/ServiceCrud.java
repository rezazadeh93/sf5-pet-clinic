package com.springframework.sf5petclinic.services;

import java.util.Set;

public interface ServiceCrud<T, ID> {
    T findByID(ID id);

    Set<T> findAll();

    T save(T object);

    void deleteByID(ID id);

    void delete(T object);
}
