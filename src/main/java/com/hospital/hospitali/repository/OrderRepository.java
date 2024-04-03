package com.hospital.hospitali.repository;

import com.hospital.hospitali.entity.Order;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    @Autowired
    private EntityManager entityManager;
    public List<Order> findByUserId(Long userId) {
        return entityManager.createQuery("SELECT o FROM Order o WHERE o.userId = :userId", Order.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public Order save(Order order) {
        entityManager.persist(order);
        return order;
    }



    public Optional<Order> findById(Long orderId) {
        Order order = entityManager.find(Order.class, orderId);
        return Optional.ofNullable(order);
    }
<<<<<<< HEAD

    public List<Order> findAll() {
        return entityManager.createQuery("SELECT o FROM Order o", Order.class)
                .getResultList();
    }
=======
>>>>>>> eacdff1488ba5c9d62e0dfdd10243491474f1416
}
