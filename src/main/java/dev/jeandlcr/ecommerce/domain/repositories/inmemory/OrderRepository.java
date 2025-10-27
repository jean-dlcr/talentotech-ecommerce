package dev.jeandlcr.ecommerce.domain.repositories.inmemory;

import java.util.ArrayList;
import java.util.List;

import dev.jeandlcr.ecommerce.core.utils.Util;
import dev.jeandlcr.ecommerce.domain.models.Employee;
import dev.jeandlcr.ecommerce.domain.models.Order;
import dev.jeandlcr.ecommerce.domain.models.Seller;
import dev.jeandlcr.ecommerce.domain.repositories.inmemory.OrderRepository;;

public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();
    private final InMemoryCustomerRepository customerRepository;
    private static int IDENTITY = 0;

    public OrderRepository(InMemoryCustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void seed() {
         //this.orderRepository = orderRepository;
        // public Order(int id, Customer customer, User seller, float total, String status,
        //          LocalDateTime createdAt, int createdBy, String observations, String shippingAddress)
        //orders.add(new Order(1001, customerRepository.getCustomerByDocument("123444"), 5, 120.0, "Pendiente", Util.getRandomDate("2025-01-01", "2025-03-31")));
        //orders.add(new Order(1002, customerRepository.getCustomerByDocument("123444"), 6, 85.0, "Enviado", Util.getRandomDate("2025-01-01", "2025-03-31")));
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
