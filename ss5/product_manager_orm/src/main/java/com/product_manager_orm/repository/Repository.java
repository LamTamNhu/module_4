package com.product_manager_orm.repository;

import com.product_manager_orm.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Repository
@Transactional
public class Repository implements IRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getAll() {
        String query = "select p from Product p";
        TypedQuery<Product> typedQuery = entityManager.createQuery(query, Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void add(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        Product result = entityManager.find(Product.class, id);
        System.out.println(result.getName());
        return result;
    }

    @Override
    public void editProduct(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void remove(int id) {
        Product productToRemove = findById(id);
        if (productToRemove != null) {
            entityManager.remove(productToRemove);
        }
    }

    @Override
    public List<Product> searchByName(String nameSearch) {
        String query = "select p from Product p where p.name like :nameSearch";
        TypedQuery<Product> typedQuery = entityManager.createQuery(query, Product.class);
        typedQuery.setParameter("nameSearch", "%" + nameSearch + "%");
        try {
            return typedQuery.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
