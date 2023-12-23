package com.product_manager_orm.repository;

import com.product_manager_orm.model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository implements IRepository {
    private static EntityManager entityManager;
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAll() {
        String query = "select p from Product p";
        TypedQuery<Product> typedQuery =
                entityManager.createQuery(query, Product.class);
        return typedQuery.getResultList();
    }
}
