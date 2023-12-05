package org.mercadolibre.TourismAgency.model;

import java.util.List;

public class Repository {
    private List<Locator> locatorList;

    public void addLocator(Locator locator) {
        locatorList.add(locator);
    }

    public void listar(){
        locatorList.forEach(System.out::println);
    }

}
