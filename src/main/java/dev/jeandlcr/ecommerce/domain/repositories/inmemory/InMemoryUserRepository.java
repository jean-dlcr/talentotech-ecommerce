package dev.jeandlcr.ecommerce.domain.repositories.inmemory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.jeandlcr.ecommerce.domain.interfaces.IUserRepository;
import dev.jeandlcr.ecommerce.domain.models.Employee;
import dev.jeandlcr.ecommerce.domain.models.Seller;
import dev.jeandlcr.ecommerce.domain.models.User;

public class InMemoryUserRepository implements IUserRepository {
    private final List<User> users = new ArrayList<>();
    private final InMemoryRoleRepository roleRepository;
    private final InMemorySellerRepository sellerRepository;
    private static int IDENTITY = 0;

    public InMemoryUserRepository(InMemoryRoleRepository roleRepository, InMemorySellerRepository sellerRepository) {
        this.roleRepository = roleRepository;
        this.sellerRepository = sellerRepository;
    }

    public void seed(Employee sysEmployee){
        this.add(new User(this.getNextId(), sysEmployee, "admin", roleRepository.getRoleByCode("ADMIN"), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), sysEmployee.getId(), null, null));
        for(Seller seller : sellerRepository.getAll()){
            users.add(new User(this.getNextId(), seller.getEmployeeData(), seller.getEmployeeData().getDocument(), roleRepository.getRoleByCode("SELLER"), true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), sysEmployee.getId(), null, null));
        }
    }

    @Override
    public void add(User user){
        if (user == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }
        if (user.getId() == 0) {
            user.setId(getNextId());
        }
        users.add(user);
    }

    private int getMaxId() {
    int max_ = 0;
        for (User u : users) {
            if (u.getId() > max_) {
                max_ = u.getId();
            }
        }
        return max_;
    }

    private int getNextId() {
        if (IDENTITY == 0 && !users.isEmpty()) {
            IDENTITY = getMaxId();
        }
        return ++IDENTITY;
    }

    @Override
    public User getUserByEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return users;
    }
}
