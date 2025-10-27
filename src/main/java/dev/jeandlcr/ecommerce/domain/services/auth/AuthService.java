package dev.jeandlcr.ecommerce.domain.services.auth;

import dev.jeandlcr.ecommerce.core.responses.Response;
import dev.jeandlcr.ecommerce.domain.models.User;
import dev.jeandlcr.ecommerce.domain.repositories.inmemory.InMemoryUserRepository;

public class AuthService {
    private final InMemoryUserRepository userRepository;

    public AuthService(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Response<User> login(String email, String password) {
        User user = userRepository.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return Response.success(String.format("Bienvenido, %s.", user.getFirstName()), user);
        }else{
            return Response.error("Credenciales inválidas");
        }
    }
}
