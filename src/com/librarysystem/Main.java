package src.com.librarysystem;

import src.com.librarysystem.service.AuthService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Выберите действие:");
            System.out.println("1. Регистрация пользователя");
            System.out.println("2. Вход пользователя");
            System.out.println("0. Выход");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    authService.registerUser();
                    break;
                case 2:
                    authService.loginUser();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор! Пожалуйста, выберите снова.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
