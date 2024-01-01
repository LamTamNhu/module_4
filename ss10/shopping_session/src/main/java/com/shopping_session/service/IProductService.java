package com.shopping_session.service;



import com.shopping_session.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);
}
