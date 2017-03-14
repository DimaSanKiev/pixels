package io.dimasan.pixels.service;

import java.util.List;

public interface CrudService<T> {

    List<?> listAll();

    T getById(Long id);

    T saveOrUpdate(T obj);

    void delete(Long id);
}
