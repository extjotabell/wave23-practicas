package com.mercadolibre.deportistas.reposotory;

import com.mercadolibre.deportistas.entity.Person;

import java.util.List;

public interface IPersonRepository {

    List<Person> findAll();
}
