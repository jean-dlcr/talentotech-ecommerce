package dev.jeandlcr.ecommerce.application.controllers;

import java.util.List;
import java.util.Scanner;

import dev.jeandlcr.ecommerce.core.utils.Util;
import dev.jeandlcr.ecommerce.domain.models.Category;
import dev.jeandlcr.ecommerce.domain.repositories.inmemory.InMemoryCategoryRepository;

public class CategoryController {

    private final InMemoryCategoryRepository categoryRepository = new InMemoryCategoryRepository();
    private final List<Category>categories = categoryRepository.getAll();
    private final Scanner scanner = new Scanner(System.in);

    public Category choseCategory(){
        Category c = null;
        String cad = "";
        for(int i=1; i<=categories.size();i++){
            c = categories.get(i-1);
            cad += String.format("%d. %s - %s", i, c.getCode(), c.getName()) + "\n";
        }
        int op=-1;
        do{
            System.out.println(cad);
            System.out.print("\nOpción: ");

            String input = scanner.nextLine().trim();
            try {
                op = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\nDebe ingresar un número válido");
                Util.pause(scanner);
                continue;
            }
            if (!Util.validOption(op, 1, categories.size())) {
                System.out.println("\nOpción inválida");
                Util.pause(scanner);
                continue;
            }

        }while(!Util.validOption(op, 1, categories.size()));

        return categories.get(op-1);
    }
    
}
