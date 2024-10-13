package src.com.librarysystem.iterator;

import src.com.librarysystem.manager.MagazineManager;
import src.com.librarysystem.models.magazine.Magazine;

// Итератор для класса MagazineManager
public class MagazineIterator implements Iterator<Magazine> {
    private MagazineManager magazineManager; // Ссылка на менеджер журналов
    private int currentIndex = 0; // Текущий индекс для итерации

    // Конструктор принимает MagazineManager
    public MagazineIterator(MagazineManager magazineManager) {
        this.magazineManager = magazineManager;
    }

    // Проверяет, есть ли следующий журнал
    @Override
    public boolean hasNext() {
        return currentIndex < magazineManager.getTotalMagazines();
    }

    // Возвращает следующий журнал
    @Override
    public Magazine next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more magazines available.");
        }
        Magazine magazine = magazineManager.getAllMagazines().get(currentIndex); // Получаем журнал по индексу
        currentIndex++;
        return magazine;
    }
}
