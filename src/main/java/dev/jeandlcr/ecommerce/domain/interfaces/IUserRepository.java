package dev.jeandlcr.ecommerce.domain.interfaces;

import java.util.List;

import dev.jeandlcr.ecommerce.domain.models.User;

public interface IUserRepository {
    void add(User user);
    User getUserById(int userId);
    List<User> getAll();
    User getUserByEmail(String email);
    
}
