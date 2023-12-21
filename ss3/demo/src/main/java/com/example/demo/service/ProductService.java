package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "GTA San Andreas", 59.99, "CJ and the hood", "Rockstar"));
        products.add(new Product(2, "MCZ-S040", 20.0, "Thermal bottle", "Tiger"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product getProduct(int id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void edit(Product product) {
        Product productToEdit = getProduct(product.getId());
        productToEdit.setName(product.getName());
        productToEdit.setPrice(product.getPrice());
        productToEdit.setDescription(product.getDescription());
        productToEdit.setBrand(product.getBrand());
    }

    @Override
    public void remove(int id) {
        Product productToRemove = getProduct(id);
        if (productToRemove != null) {
            products.remove(productToRemove);
        }
    }
}
