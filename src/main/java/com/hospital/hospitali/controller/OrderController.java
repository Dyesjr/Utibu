package com.hospital.hospitali.controller;

import com.hospital.hospitali.dto.OrderDto;
import com.hospital.hospitali.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderDto orderDto) {
        orderService.placeOrder(orderDto);
        return ResponseEntity.ok("Order placed successfully");
    }


<<<<<<< HEAD
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
=======
>>>>>>> eacdff1488ba5c9d62e0dfdd10243491474f1416

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderDetails(@PathVariable Long orderId) {
        OrderDto orderDto = orderService.getOrderDetails(orderId);
        if (orderDto != null) {
            return ResponseEntity.ok(orderDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

<<<<<<< HEAD


=======
>>>>>>> eacdff1488ba5c9d62e0dfdd10243491474f1416
    @GetMapping("/history/{userId}")
    public ResponseEntity<List<OrderDto>> getOrderHistory(@PathVariable Long userId) {
        List<OrderDto> orderHistory = orderService.getOrderHistory(userId);
        return ResponseEntity.ok(orderHistory);
    }
}
