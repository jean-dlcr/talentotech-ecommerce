package dev.jeandlcr.ecommerce.application.controllers;

import dev.jeandlcr.ecommerce.core.utils.Util;
import dev.jeandlcr.ecommerce.domain.models.User;

public class AdminController {
    public void showMainView(User refUser){
        Util.clearConsole();
        System.out.println("Menú de admin");
    }
    
}
