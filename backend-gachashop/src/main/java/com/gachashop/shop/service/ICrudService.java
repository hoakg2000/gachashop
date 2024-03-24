package com.gachashop.shop.service;

import java.util.List;

public interface ICrudService<T, R> {
    T getById(long id);

    List<T> getAll();

    T create(R object);

    T update(long id, R object);

    void delete(long id);
}
