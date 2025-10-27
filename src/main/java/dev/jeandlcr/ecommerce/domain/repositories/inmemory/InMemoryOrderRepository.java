package dev.jeandlcr.ecommerce.domain.repositories.inmemory;

import java.util.ArrayList;
import java.util.List;

import dev.jeandlcr.ecommerce.domain.models.Order;
import dev.jeandlcr.ecommerce.domain.repositories.inmemory.InMemoryOrderRepository;;

public class InMemoryOrderRepository {

    private final List<Order> orders = new ArrayList<>();
    private final InMemoryCustomerRepository customerRepository;
    private static int IDENTITY = 0;

    public InMemoryOrderRepository(InMemoryCustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void seed() {
    }

    public List<Order> getAll() {
        return orders;
    }

    public Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public void add(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("La orden no puede ser objeto nulo.");
        }
        if (order.getId() == 0) {
            order.setId(getNextId());
        }
        orders.add(order);
    }

    private int getMaxId() {
    int max_ = 0;
        for (Order o : orders) {
            if (o.getId() > max_) {
                max_ = o.getId();
            }
        }
        return max_;
    }

    private int getNextId() {
        if (IDENTITY == 0 && !orders.isEmpty()) {
            IDENTITY = getMaxId();
        }
        return ++IDENTITY;
    }
}