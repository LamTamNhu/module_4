package com.product_manager_orm.service;

import com.product_manager_orm.model.Product;
import com.product_manager_orm.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IRepository repository;
    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public void add(Product product) {
        repository.add(product);
    }

    @Override
    public Product getProduct(int id) {
        return repository.findById(id);
    }

    @Override
    public void edit(Product product) {
        repository.editProduct(product);
    }

    @Override
    public void remove(int id) {
       repository.remove(id);
    }

    @Override
    public List<Product> search(String searchText) {
        return repository.searchByName(searchText);
    }
}
