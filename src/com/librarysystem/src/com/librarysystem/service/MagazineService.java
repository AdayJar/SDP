package src.com.librarysystem.service;

import src.com.librarysystem.exceptions.MagazineNotFoundException; // Импорт исключения для случая, когда журнал не найден
import src.com.librarysystem.manager.MagazineManager; // Импорт менеджера журналов
import src.com.librarysystem.models.magazine.Magazine; // Импорт модели журнала

public class MagazineService {
    private final MagazineManager magazineManager; // Менеджер для обработки журналов

    // Конструктор для инициализации MagazineManager
    public MagazineService(MagazineManager magazineManager) {
        this.magazineManager = magazineManager;
    }

    // Метод для проверки доступности журнала по ID
    public boolean isMagazineAvailable(int id) throws MagazineNotFoundException {
        Magazine magazine = magazineManager.findMagazineById(id);
        if (magazine == null) {
            throw new MagazineNotFoundException("Magazine with ID " + id + " not found."); // Выбрасываем исключение, если журнал не найден
        }
        return magazine.isAvailable(); // Возвращаем доступность журнала
    }

    // Метод для изменения доступности журнала по ID
    public void changeMagazineAvailability(int id, boolean availability) throws MagazineNotFoundException {
        Magazine magazine = magazineManager.findMagazineById(id);
        if (magazine == null) {
            throw new MagazineNotFoundException("Magazine with ID " + id + " not found."); // Выбрасываем исключение, если журнал не найден
        }
        magazine.changeAvailability(availability); // Изменяем статус доступности журнала
    }
}
