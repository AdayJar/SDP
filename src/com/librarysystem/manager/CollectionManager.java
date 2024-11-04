package src.com.librarysystem.manager;

import java.util.List;

import src.com.librarysystem.iterator.Iterator;

public interface CollectionManager<T> {
    void add(T item); 
    void remove(int id); 
    T findById(int id);
    int getTotal(); 
    List<T> getItems(); 
    void showAll(); 
    Iterator<T> iterator();
}

