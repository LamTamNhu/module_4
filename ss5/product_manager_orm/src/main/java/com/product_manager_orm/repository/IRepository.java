package com.product_manager_orm.repository;

import com.product_manager_orm.model.Product;

import java.util.List;

public interface IRepository {
    List<Product> getAll();
}
