package dev.jeandlcr.ecommerce.domain.interfaces;

import java.util.List;

import dev.jeandlcr.ecommerce.domain.models.Role;

public interface IRoleRepository {
    void add(Role role);
    List<Role> getAll();
    Role getRoleById(int id);
    Role getRoleByCode(String code);
}
