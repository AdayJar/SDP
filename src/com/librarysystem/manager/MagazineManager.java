package src.com.librarysystem.manager;

import java.util.ArrayList;
import java.util.List;

import src.com.librarysystem.iterator.ClientIterator;
import src.com.librarysystem.iterator.Iterator;
import src.com.librarysystem.iterator.MagazineIterator;
import src.com.librarysystem.models.clients.Client;
import src.com.librarysystem.models.magazine.Magazine;

public class MagazineManager implements CollectionManager<Magazine> {
    private List<Magazine> magazines = new ArrayList<>(); // Массив журналов

    @Override
    public void add(Magazine magazine) {
        magazines.add(magazine);
        System.out.println("Magazine added: " + magazine.showInfo());
    }

    @Override
    public void remove(int id) {
        magazines.removeIf(magazine -> magazine.getId() == id);
        System.out.println("Magazine with ID " + id + " has been removed.");
    }

    @Override
    public Magazine findById(int id) {
        return magazines.stream().filter(magazine -> magazine.getId() == id).findFirst().orElse(null);
    }

    @Override
    public int getTotal() {
        return magazines.size();
    }
    @Override
    public List<Magazine> getItems(){
        return magazines;
    }

    @Override
    public void showAll() {
        magazines.forEach(magazine -> System.out.println(magazine.showInfo()));
    }

    @Override
    public Iterator<Magazine> iterator() {
    return new MagazineIterator(this);
}

}
