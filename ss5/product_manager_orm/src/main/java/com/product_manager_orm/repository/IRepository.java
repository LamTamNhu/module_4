package com.product_manager_orm.repository;

import com.product_manager_orm.model.Product;

import java.util.List;

public interface IRepository {
    List<Product> getAll();

    void add(Product product);

    Product findById(int id);

    void editProduct(Product product);

    void remove(int id);

    List<Product> searchByName(String searchText);
}
