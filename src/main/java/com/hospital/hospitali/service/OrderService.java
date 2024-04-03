package com.hospital.hospitali.service;

import com.hospital.hospitali.dto.OrderDto;

import java.util.List;

public interface OrderService {
    void placeOrder(OrderDto orderDto);
    List<OrderDto> getOrderHistory(Long userId);

    OrderDto getOrderDetails(Long orderId);
<<<<<<< HEAD

    List<OrderDto> getAllOrders();
=======
>>>>>>> eacdff1488ba5c9d62e0dfdd10243491474f1416
}