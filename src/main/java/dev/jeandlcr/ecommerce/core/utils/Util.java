package dev.jeandlcr.ecommerce.core.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Util {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static boolean validOption(int option, int min, int max) {
        return option >= min && option <= max;
    }

    public static void pause() {
        pause(null);
    }

    public static void pause(Scanner scanner) {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        System.out.println("Presiona Enter para continuar...");
        scanner.nextLine();
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static LocalDateTime getRandomDate(String startDateStr, String endDateStr) {
        LocalDate startDate = LocalDate.parse(startDateStr, DATE_FORMATTER);
        LocalDate endDate = LocalDate.parse(endDateStr, DATE_FORMATTER);

        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();

        long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay + 1);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        int randomHour = ThreadLocalRandom.current().nextInt(0, 24);
        int randomMinute = ThreadLocalRandom.current().nextInt(0, 60);
        int randomSecond = ThreadLocalRandom.current().nextInt(0, 60);

        return LocalDateTime.of(randomDate, LocalTime.of(randomHour, randomMinute, randomSecond));
    }
}
