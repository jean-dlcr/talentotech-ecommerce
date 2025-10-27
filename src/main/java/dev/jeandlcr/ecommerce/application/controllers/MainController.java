package dev.jeandlcr.ecommerce.application.controllers;

import dev.jeandlcr.ecommerce.core.responses.Response;
import dev.jeandlcr.ecommerce.core.utils.Util;
import dev.jeandlcr.ecommerce.domain.models.Employee;
import dev.jeandlcr.ecommerce.domain.models.User;
import dev.jeandlcr.ecommerce.domain.repositories.inmemory.InMemoryEmployeeRepository;
import dev.jeandlcr.ecommerce.domain.repositories.inmemory.InMemoryRoleRepository;
import dev.jeandlcr.ecommerce.domain.repositories.inmemory.InMemorySellerRepository;
import dev.jeandlcr.ecommerce.domain.repositories.inmemory.InMemoryUserRepository;
import dev.jeandlcr.ecommerce.domain.services.auth.AuthService;

public class MainController {    
    
    private final AdminController adminController = new AdminController();
    private final SellerController sellerController = new SellerController();

    private final InMemoryEmployeeRepository employeeRepository = new InMemoryEmployeeRepository();
    private final InMemorySellerRepository sellerRepository = new InMemorySellerRepository(employeeRepository);

    private final InMemoryRoleRepository roleRepository = new InMemoryRoleRepository();
    private final InMemoryUserRepository userRepository = new InMemoryUserRepository(roleRepository, sellerRepository);
    private final AuthService authService = new AuthService(userRepository);
    private final LoginController loginController = new LoginController(authService);

    private final int MAX_ATTEMPTS = 3;
    private static int attempts = 0;

    public void seedAuthData() {
        this.roleRepository.seed();
        this.employeeRepository.seed();
        Employee SYS_EMP = this.employeeRepository.getEmployeeByDocument("89707883");
        this.sellerRepository.seed();
        this.userRepository.seed(SYS_EMP);
        //Update created by Admin ID
        this.roleRepository.updateAllListCreatedBy(SYS_EMP.getId());
        this.employeeRepository.updateAllListCreatedBy(SYS_EMP.getId());
        this.sellerRepository.updateAllListCreatedBy(SYS_EMP.getId());
    }
    
    public void start() {
        Response<User> response = null;
        do{
            Util.clearConsole();
            attempts++;
            response = loginController.showLogin();
            if (!response.isSuccess() || response.getData() == null) {
                System.out.println("\n"+response.getMessage()+"\n");
                Util.pause();
            }
        }while(!response.isSuccess() && attempts < MAX_ATTEMPTS);
       
        User user = response.getData();

        switch (user.getRole().getCode()) {
            case "ADMIN" -> adminController.showMainView(user);
            case "SELLER" -> sellerController.showMainView(user);
            default -> System.out.println("Rol desconocido: " + user.getRole().getName());
        }
    }
}
