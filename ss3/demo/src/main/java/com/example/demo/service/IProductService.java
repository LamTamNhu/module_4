package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    void add(Product product);

    Product getProduct(int id);

    void edit(Product product);
}
