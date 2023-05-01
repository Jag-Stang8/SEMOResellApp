package com.redacted.semoresellapp.service;

import com.redacted.semoresellapp.model.Customer;
import com.redacted.semoresellapp.model.Order;
import com.redacted.semoresellapp.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrdersByCustomer(Customer customer) {
        return orderRepository.findByCustomer(customer);
    }

    public Order getOrderById(Long id) {
        return (Order) orderRepository.findById(id).orElse(null);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    // Add other methods as needed
}
