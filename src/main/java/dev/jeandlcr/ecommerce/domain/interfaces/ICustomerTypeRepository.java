package dev.jeandlcr.ecommerce.domain.interfaces;


import java.util.List;

import dev.jeandlcr.ecommerce.domain.models.CustomerType;

public interface ICustomerTypeRepository {
    void add(CustomerType cType);
    List<CustomerType> getAll();
    CustomerType getCustomerTypeById(int id);
    CustomerType getCustomerTypeByCode(String code);
}