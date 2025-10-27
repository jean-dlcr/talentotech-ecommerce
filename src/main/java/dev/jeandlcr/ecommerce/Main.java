package dev.jeandlcr.ecommerce;

import dev.jeandlcr.ecommerce.application.controllers.MainController;

public class Main {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.seedAuthData();
        mainController.start();
    }
}
