package dev.jeandlcr.ecommerce.domain.repositories.inmemory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.jeandlcr.ecommerce.domain.models.Role;
import dev.jeandlcr.ecommerce.domain.interfaces.IRoleRepository;

public class InMemoryRoleRepository implements IRoleRepository {
    private final List<Role> roles = new ArrayList<>();
    private static int IDENTITY = 0;

    public void seed() {
        if (!roles.isEmpty()) return;
        this.add(new Role(this.getNextId(), "ADMIN", "Administrador", true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
        this.add(new Role(this.getNextId(), "SELLER", "Vendedor", true, LocalDateTime.of(2025, 1, 1, 9, 0, 0), null, null, null));
    }

    @Override
    public void add(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("El rol no puede ser nulo.");
        }
        if (role.getId() == 0) {
            role.setId(getNextId());
        }
        roles.add(role);
    }

    private int getMaxId() {
    int max_ = 0;
        for (Role r : roles) {
            if (r.getId() > max_) {
                max_ = r.getId();
            }
        }
        return max_;
    }

    private int getNextId() {
        if (IDENTITY == 0 && !roles.isEmpty()) {
            IDENTITY = getMaxId();
        }
        return ++IDENTITY;
    }

    @Override
    public Role getRoleById(int id) {
         for (Role r : roles) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    @Override
    public Role getRoleByCode(String code) {
        for (Role r : roles) {
            if (r.getCode().equalsIgnoreCase(code)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public List<Role> getAll() {
        return roles;
    }

    public void updateAllListCreatedBy(int createdBy){
        for (Role r: roles) {
            r.setCreatedBy(createdBy);
        }
    }
}
