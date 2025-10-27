package dev.jeandlcr.ecommerce.domain.repositories.inmemory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.jeandlcr.ecommerce.domain.models.CustomerType;
import dev.jeandlcr.ecommerce.domain.interfaces.ICustomerTypeRepository;

public class InMemoryCustomerTypeRepository implements ICustomerTypeRepository {
    private final List<CustomerType> customerTypes = new ArrayList<>();
    private static int IDENTITY = 0;

    public void seed() {
        if (!customerTypes.isEmpty()) return;
        this.add(new CustomerType(this.getNextId(), "CONFIN", "Consumidor Final", true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new CustomerType(this.getNextId(), "MINORI", "Minorista", true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new CustomerType(this.getNextId(), "MAYORI", "Mayorista", true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new CustomerType(this.getNextId(), "INSTIT", "Institucional", true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new CustomerType(this.getNextId(), "CORPORA", "Corporativo", true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
    }

    @Override
    public void add(CustomerType cType) {
        if (cType == null) {
            throw new IllegalArgumentException("El tipo de consumidor no puede ser nulo.");
        }
        if (cType.getId() == 0) {
            cType.setId(getNextId());
        }
        customerTypes.add(cType);
    }

    private int getMaxId() {
    int max_ = 0;
        for (CustomerType cType : customerTypes) {
            if (cType.getId() > max_) {
                max_ = cType.getId();
            }
        }
        return max_;
    }

    private int getNextId() {
        if (IDENTITY == 0 && !customerTypes.isEmpty()) {
            IDENTITY = getMaxId();
        }
        return ++IDENTITY;
    }


    @Override
    public CustomerType getCustomerTypeById(int id) {
        for (CustomerType cType : customerTypes) {
            if (cType.getId() == id) {
                return cType;
            }
        }
        return null;
    }

    @Override
    public CustomerType getCustomerTypeByCode(String code) {
         for (CustomerType cType : customerTypes) {
            if (cType.getCode().equalsIgnoreCase(code)) {
                return cType;
            }
        }
        return null;
    }

    @Override
    public List<CustomerType> getAll() {
        return customerTypes;
    }

    public void updateAllListCreatedBy(int createdBy){
        for (CustomerType cType: customerTypes) {
            cType.setCreatedBy(createdBy);
        }
    }
}
