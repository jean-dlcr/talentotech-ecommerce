package dev.jeandlcr.ecommerce.application.controllers;

import java.io.Console;
import java.util.Scanner;

import dev.jeandlcr.ecommerce.core.responses.Response;
import dev.jeandlcr.ecommerce.domain.models.User;
import dev.jeandlcr.ecommerce.domain.services.auth.AuthService;

public class LoginController {
    private final String brandAscii = "  _          _                     _____                                                \r\n" + //
                " | |    __ _(_)_   _____          | ____|___ ___  _ __ ___  _ __ ___   ___ _ __ ___ ___ \r\n" + //
                " | |   / _` | \\ \\ / / _ \\  _____  |  _| / __/ _ \\| '_ ` _ \\| '_ ` _ \\ / _ \\ '__/ __/ _ \\\r\n" + //
                " | |__| (_| | |\\ V /  __/ |_____| | |__| (_| (_) | | | | | | | | | | |  __/ | | (_|  __/\r\n" + //
                " |_____\\__,_|_| \\_/ \\___|         |_____\\___\\___/|_| |_| |_|_| |_| |_|\\___|_|  \\___\\___|\r\n" + //
                "                                                                                        ";
    private final AuthService authService;
    private final Scanner scanner = new Scanner(System.in);
    private final Console console = System.console();

    public LoginController(AuthService authService){
        this.authService = authService;
    }    
                
    public Response<User> showLogin() {
        System.out.println(brandAscii);
        System.out.println("=== LOGIN ===\n");
        System.out.print("Usuario: ");
        String email = scanner.nextLine();

        String password;
        if (console != null) {
            char[] passwordChars = console.readPassword("Contraseña: ");
            password = new String(passwordChars);
        } else {
            System.out.print("Contraseña: ");
            password = scanner.nextLine();
        }
        return authService.login(email, password);
    }     
}
