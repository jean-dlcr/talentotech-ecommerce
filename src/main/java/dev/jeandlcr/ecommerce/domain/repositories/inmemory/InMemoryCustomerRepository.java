package dev.jeandlcr.ecommerce.domain.repositories.inmemory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.jeandlcr.ecommerce.domain.models.Customer;
import dev.jeandlcr.ecommerce.domain.interfaces.ICustomerRepository;


public class InMemoryCustomerRepository implements ICustomerRepository {
    private final List<Customer> customers = new ArrayList<>();
    private final InMemoryCustomerTypeRepository customerTypeRepository;
    private static int IDENTITY = 0;

    public InMemoryCustomerRepository(InMemoryCustomerTypeRepository customerTypeRepository) {
        this.customerTypeRepository = customerTypeRepository;
    }

    public void seed() {
        if (!customers.isEmpty()) return;
        this.add(new Customer(this.getNextId(), "78326491", customerTypeRepository.getCustomerTypeByCode("CONFIN"), "María", "González", "Ramírez", null, "mgonzález.ra@gmail.com", "null", null, true, LocalDateTime.of(2025, 2, 1, 9, 0, 0), null, null, null));
        this.add(new Customer(this.getNextId(), "61293847", customerTypeRepository.getCustomerTypeByCode("CONFIN"), "Carlos", "Fernández", "López", null, "cfernández.ló@gmail.com", "51934827165", null, true, LocalDateTime.of(2025, 2, 1, 9, 0, 0), null, null, null));
        this.add(new Customer(this.getNextId(), "84910236", customerTypeRepository.getCustomerTypeByCode("CONFIN"), "Ana", "Martínez", "Torres", null, "amartínez.to@gmail.com", "null", null, true, LocalDateTime.of(2025, 2, 1, 9, 0, 0), null, null, null));
        this.add(new Customer(this.getNextId(), "70128493", customerTypeRepository.getCustomerTypeByCode("CONFIN"), "Luis", "Rodríguez", "Castillo", null, "lrodríguez.ca@gmail.com", "null", null, true, LocalDateTime.of(2025, 2, 1, 9, 0, 0), null, null, null));
        this.add(new Customer(this.getNextId(), "68947320", customerTypeRepository.getCustomerTypeByCode("CONFIN"), "Sofía", "Pérez", "Morales", null, "spérez.mo@gmail.com", "51901283746", null, true, LocalDateTime.of(2025, 2, 1, 9, 0, 0), null, null, null));
        this.add(new Customer(this.getNextId(), "73829164", customerTypeRepository.getCustomerTypeByCode("CONFIN"), "Javier", "Gómez", "Vargas", null, "jgómez.va@gmail.com", "51923847561", null, true, LocalDateTime.of(2025, 2, 1, 9, 0, 0), null, null, null));
        this.add(new Customer(this.getNextId(), "80237419", customerTypeRepository.getCustomerTypeByCode("CONFIN"), "Camila", "Díaz", "Rojas", null, "cdíaz.ro@gmail.com", "51945612378", null, true, LocalDateTime.of(2025, 2, 1, 9, 0, 0), null, null, null));
        this.add(new Customer(this.getNextId(), "67482910", customerTypeRepository.getCustomerTypeByCode("CONFIN"), "Andrés", "Sánchez", "Cruz", null, "asánchez.cr@gmail.com", "51967283415", null, true, LocalDateTime.of(2025, 2, 1, 9, 0, 0), null, null, null));
        this.add(new Customer(this.getNextId(), "79201384", customerTypeRepository.getCustomerTypeByCode("CONFIN"), "Valentina", "Ruiz", "Navarro", null, "vruiz.na@gmail.com", "51989102347", null, true, LocalDateTime.of(2025, 2, 1, 9, 0, 0), null, null, null));
        this.add(new Customer(this.getNextId(), "86129473", customerTypeRepository.getCustomerTypeByCode("CONFIN"), "Miguel", "Ortega", "Salazar", null, "mortega.sa@gmail.com", "null", null, true, LocalDateTime.of(2025, 2, 1, 9, 0, 0), null, null, null));
    }

    @Override
    public void add(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }
        if (customer.getId() == 0) {
            customer.setId(getNextId());
        }
        customers.add(customer);
    }

    private int getMaxId() {
    int max_ = 0;
        for (Customer c : customers) {
            if (c.getId() > max_) {
                max_ = c.getId();
            }
        }
        return max_;
    }

    private int getNextId() {
        if (IDENTITY == 0 && !customers.isEmpty()) {
            IDENTITY = getMaxId();
        }
        return ++IDENTITY;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        for (Customer s : customers) {
            if (s.getId() == customerId) {
                return s;
            }
        }
        return null;
    }

    @Override
    public Customer getCustomerByDocument(String document) {
        for (Customer c : customers) {
            if (c.getDocument().equalsIgnoreCase(document)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    public void updateAllListCreatedBy(int createdBy){
        for (Customer c: customers) {
            c.setCreatedBy(createdBy);
        }
    }
}
