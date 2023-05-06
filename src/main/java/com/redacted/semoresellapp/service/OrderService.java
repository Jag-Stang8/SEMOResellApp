package com.redacted.semoresellapp.service;

import com.redacted.semoresellapp.model.Listing;
import com.redacted.semoresellapp.model.Order;
import com.redacted.semoresellapp.repository.ListingRepository;
import com.redacted.semoresellapp.repository.OrderRepository;
import exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ListingRepository listingRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent())
            return optionalOrder.get();
        else
            throw new OrderNotFoundException("No Order with id: " + id + " found");
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Order order = getOrderById(id);
        order.setQuantity(updatedOrder.getQuantity());
        order.setPrice(updatedOrder.getPrice());
        order.setStatus(updatedOrder.getStatus());

        Listing listing = order.getListing();
        listing.setTitle(updatedOrder.getListing().getTitle());
        listing.setDesc(updatedOrder.getListing().getDesc());
        listing.setImage(updatedOrder.getListing().getImage());
        listing.setPrice(updatedOrder.getListing().getPrice());

        listingRepository.save(listing);

        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
