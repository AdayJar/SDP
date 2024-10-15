package src.com.librarysystem.observer;

import src.com.librarysystem.models.magazine.Magazine;

public class ClientObserver implements Observer {
    private String name;

    public ClientObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Magazine magazine) {
        System.out.println(name + " был уведомлён, что журнал " + magazine.getTitle() + " теперь " + (magazine.isAvailable() ? "доступен" : "недоступен") + ".");
    }
}
