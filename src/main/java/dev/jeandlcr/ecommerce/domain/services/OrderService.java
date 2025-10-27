package dev.jeandlcr.ecommerce.domain.services;

import java.util.List;

import dev.jeandlcr.ecommerce.domain.models.Order;
import dev.jeandlcr.ecommerce.domain.repositories.inmemory.InMemoryOrderRepository;

public class OrderService {

    private final InMemoryOrderRepository orderRepository;

    public OrderService(InMemoryOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.getAll();
    }

    public void approveOrder(int orderId) {
        Order order = orderRepository.getOrderById(orderId);
        if (order != null) {
            order.setStatus("Aprobado");
            //orderRepository.update(order);
        }
    }

    // otras acciones: cancel, delete, create
}

