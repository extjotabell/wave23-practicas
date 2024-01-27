package org.example.interfaces;

import org.example.model.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class CRUD<T extends Model> {

    private List<T> models;
    public T getById(String id){
        return models.stream().filter(model -> model.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    public void add(T element){
        if(!models.contains(element) ||getById(element.getId())==null){
            models.add(element);
        }
    }

    public boolean delete(String id){
        T element = getById(id);
        if(element != null){
            return models.remove(element);
        }
        return false;
    }

    public void showAll(){
        models.forEach(System.out::println);
    }

    public CRUD(){
        models=new ArrayList<>();
    }

    protected  List<T> getModels() {
        return models;
    }
}
