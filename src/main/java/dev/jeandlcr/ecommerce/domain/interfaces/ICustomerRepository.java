package dev.jeandlcr.ecommerce.domain.interfaces;

import java.util.List;

import dev.jeandlcr.ecommerce.domain.models.Customer;

public interface ICustomerRepository {
    void add(Customer customer);
    List<Customer> getAll();
    Customer getCustomerById(int id);
    Customer getCustomerByDocument(String document);
}
