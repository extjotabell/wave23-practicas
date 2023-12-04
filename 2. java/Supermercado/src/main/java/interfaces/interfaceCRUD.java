package interfaces;

import Exceptions.ElementNotFoundException;

public interface interfaceCRUD<T>{
    T getById(String id) throws ElementNotFoundException;
    boolean delete(String id);
    void add(T element);
    void showAll();
    void showById(String id);



}
