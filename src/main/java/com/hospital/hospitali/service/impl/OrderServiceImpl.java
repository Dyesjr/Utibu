package com.hospital.hospitali.service.impl;

import com.hospital.hospitali.dto.OrderDto;
import com.hospital.hospitali.dto.OrderItemDto;
import com.hospital.hospitali.entity.Order;
import com.hospital.hospitali.entity.OrderItem;
import com.hospital.hospitali.repository.OrderRepository;
import com.hospital.hospitali.repository.ProductRepository;
import com.hospital.hospitali.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public void placeOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setUserId(orderDto.getUserId());
        List<OrderItem> orderItems = orderDto.getItems().stream()
                .map(this::convertToOrderItem)
                .collect(Collectors.toList());
        order.setItems(orderItems);
        orderRepository.save(order);
    }

    @Override
    public List<OrderDto> getOrderHistory(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderDetails(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            return convertToDto(order);
        } else {
            return null;
        }
    }

    private OrderItem convertToOrderItem(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId((Long) productRepository.findById(orderItemDto.getProductId()).orElse(null));
        orderItem.setQuantity(orderItemDto.getQuantity());
        return orderItem;
    }

    private OrderDto convertToDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setUserId(order.getUserId());
        List<OrderItemDto> itemDtos = order.getItems().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        dto.setItems(itemDtos);
        return dto;
    }

    private OrderItemDto convertToDto(OrderItem orderItem) {
        OrderItemDto dto = new OrderItemDto();
//        dto.setProductId(orderItem.getProduct().getId());
        dto.setQuantity(orderItem.getQuantity());
        return dto;
    }
}
