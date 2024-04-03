package com.hospital.hospitali.repository;

import com.hospital.hospitali.entity.Product;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Product> findAll() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
    }

    public Optional<Object> findById(Long productId) {
        return Optional.ofNullable(productId);
    }


    public void save(Product product) {
        entityManager.persist(product);
    }
}
