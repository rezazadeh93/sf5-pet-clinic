package com.springframework.sf5petclinic.services.map;

import com.springframework.sf5petclinic.model.BaseEntity;

import java.util.*;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    T findByID(ID id) {
        return map.get(id);
    }

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextID());
            }

            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }

        return object;
    }

    void deleteByID(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(e -> e.getValue().equals(object));
    }

    private Long getNextID() {
        Long nextID = null;

        try {
            nextID = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextID = 1L;
        }

        return nextID;
    }
}
