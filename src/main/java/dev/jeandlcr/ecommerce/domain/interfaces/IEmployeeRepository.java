package dev.jeandlcr.ecommerce.domain.interfaces;

import java.util.List;

import dev.jeandlcr.ecommerce.domain.models.Employee;

public interface IEmployeeRepository {
    void add(Employee employee);
    List<Employee> getAll();
    Employee getEmployeeById(int id);
    Employee getEmployeeByDocument(String document);
}
