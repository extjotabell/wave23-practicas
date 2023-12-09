package repositories;

import models.CRUD;
import models.Product;

import java.util.List;

public class ProductRepository  extends CRUD<Product> {
    public ProductRepository(List<Product> entities) {
        super(entities);
    }
}
