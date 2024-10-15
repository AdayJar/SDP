package src.com.librarysystem.models.magazine;

import src.com.librarysystem.observer.Observer;
import java.util.ArrayList;
import java.util.List;

public class WeeklyMagazine implements Magazine {
    private int id;
    private String title;
    private String editor;
    private boolean available;
    private String weekOfPublication;
    private List<Observer> observers = new ArrayList<>(); // Список для хранения наблюдателей

    public WeeklyMagazine(int id, String title, String editor, boolean available, String weekOfPublication) {
        this.id = id;
        this.title = title;
        this.editor = editor;
        this.available = available;
        this.weekOfPublication = weekOfPublication;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getEditor() {
        return editor;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public String showInfo() {
        return "ID: " + id + ", Title: " + title + ", Editor: " + editor + ", Available: " + available + ", Issue Number: " + weekOfPublication;
    }

    @Override
    public void changeAvailability(boolean availability) {
        this.available = availability;
        notifyObservers(); // Уведомляем наблюдателей, когда меняется доступность
    }

    // Подписка на наблюдателя
    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    // Отписка от наблюдателя
    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    // Уведомление всех наблюдателей
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
