package com.product_manager_orm.service;

import com.product_manager_orm.model.Product;
import com.product_manager_orm.repository.IRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IRepository repository;
    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

//    @Override
//    public void add(Product product) {
//        products.add(product);
//    }
//
//    @Override
//    public Product getProduct(int id) {
//        for (Product p : products) {
//            if (p.getId().equals(id)) {
//                return p;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void edit(Product product) {
//        Product productToEdit = getProduct(product.getId());
//        productToEdit.setName(product.getName());
//        productToEdit.setPrice(product.getPrice());
//        productToEdit.setDescription(product.getDescription());
//        productToEdit.setBrand(product.getBrand());
//    }
//
//    @Override
//    public void remove(int id) {
//        Product productToRemove = getProduct(id);
//        if (productToRemove != null) {
//            products.remove(productToRemove);
//        }
//    }
//
//    @Override
//    public List<Product> search(String searchText) {
//        List<Product> result = new ArrayList<>();
//        for (Product p : products) {
//            if (StringUtils.containsIgnoreCase(p.getName(),searchText)) {
//                result.add(p);
//            } else if (StringUtils.containsIgnoreCase(p.getDescription(),searchText)) {
//                result.add(p);
//            }
//        }
//        return result;
//    }
}
