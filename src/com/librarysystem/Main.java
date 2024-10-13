package src.com.librarysystem;

import src.com.librarysystem.manager.MagazineManager;
import src.com.librarysystem.models.magazine.MonthlyMagazine;
import src.com.librarysystem.models.magazine.WeeklyMagazine;
import src.com.librarysystem.observer.ClientObserver;

public class Main {
    public static void main(String[] args) {
        // Создание менеджера журналов
        MagazineManager magazineManager = MagazineManager.getInstance();

        // Создание журналов
        MonthlyMagazine monthlyMagazine = new MonthlyMagazine(1, "Monthly Tech", "John Doe", false, 5);
        WeeklyMagazine weeklyMagazine = new WeeklyMagazine(2, "Weekly News", "Jane Smith", true, "Week 42");

        // Подписка клиентов на журналы
        ClientObserver client1 = new ClientObserver("Client A");
        ClientObserver client2 = new ClientObserver("Client B");

        // Подписываем клиентов на ежемесячный журнал
        monthlyMagazine.subscribe(client1);
        monthlyMagazine.subscribe(client2);

        // Подписываем клиентов на еженедельный журнал
        weeklyMagazine.subscribe(client1);

        // Изменение доступности журналов
        System.out.println("Изменение доступности ежемесячного журнала:");
        monthlyMagazine.changeAvailability(true); // Уведомление всех подписчиков

        System.out.println("\nИзменение доступности еженедельного журнала:");
        weeklyMagazine.changeAvailability(false); // Уведомление всех подписчиков

        // Добавление журналов в менеджер
        magazineManager.addMagazine(monthlyMagazine);
        magazineManager.addMagazine(weeklyMagazine);

        // Показываем информацию о журналах
        System.out.println("\nИнформация о журналах:");
        System.out.println(monthlyMagazine.showInfo());
        System.out.println(weeklyMagazine.showInfo());
    }
}
