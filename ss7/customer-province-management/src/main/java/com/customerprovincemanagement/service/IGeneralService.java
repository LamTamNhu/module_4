package com.customerprovincemanagement.service;

import java.util.List;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    void save(T t);

    T findById(Long id);

    void remove(Long id);
}
