package com.restaurant.controller;

import com.restaurant.model.Waiter;
import com.restaurant.service.WaiterService;

import java.util.List;
import java.util.Scanner;

public class RestaurantApp {
    private static WaiterService waiterService = new WaiterService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Добавить работника");
            System.out.println("2. Посмотреть всех работников");
            System.out.println("3. Удалить работника");
            System.out.println("4. Обновление информации о сотруднике");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите день работы: ");
                    String day = scanner.nextLine();
                    System.out.print("Зарплата: ");
                    double dailyProfit = scanner.nextDouble();
                    System.out.print("Столик: ");
                    int tableNumber = scanner.nextInt();

                    Waiter waiter = new Waiter(0, name, day, dailyProfit, tableNumber);
                    waiterService.addWaiter(waiter);
                    System.out.println("Сотрудник успешно добавлен.");
                    break;
                case 2:
                    List<Waiter> waiters = waiterService.getAllWaiters();
                    if (waiters != null) {
                        for (Waiter w : waiters) {
                            System.out.println("ID: " + w.getId() + ", Name: " + w.getName() + ", Day: " + w.getDay() + ", Profit: " + w.getDailyProfit() + ", Table: " + w.getTableNumber());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Введите id официанта, которого нужно удалить: ");
                    int idToDelete = scanner.nextInt();
                    waiterService.deleteWaiter(idToDelete);
                    System.out.println("Официант успешно удален.");
                    break;
                case 4:
                    System.out.print("Введите id сотрудника ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("День работы: ");
                    String newDay = scanner.nextLine();
                    System.out.print("Зарплата: ");
                    double newDailyProfit = scanner.nextDouble();
                    System.out.print("Столик: ");
                    int newTableNumber = scanner.nextInt();

                    waiterService.updateWaiter(idToUpdate, "", newDay, newDailyProfit, newTableNumber);
                    System.out.println("Информации о сотруднике обновлена.");
                    break;
                case 5:
                    System.out.println("Выход...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}