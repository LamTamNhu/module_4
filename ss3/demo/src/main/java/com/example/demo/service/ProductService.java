package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private static final List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1,"GTA San Andreas",59.99,"CJ and the hood","Rockstar"));
        products.add(new Product(2,"MCZ-S040",20.0,"Thermal bottle","Tiger"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void add() {

    }
}
