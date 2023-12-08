package org.mercadolibre.dao;

import org.mercadolibre.entity.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of CRUD operations for managing Item objects.
 */
public class ItemCRUD implements CRUD<Item> {
    private final List<Item> items;

    /**
     * Constructs a new ItemCRUD instance with an empty list of items.
     */
    public ItemCRUD() {
        this.items = new ArrayList<>();
    }

    /**
     * Creates a new item in the data store.
     *
     * @param newItem The item to be created.
     * @return The created item.
     */
    public Item create(Item newItem) {
        this.items.add(newItem);
        return newItem;
    }

    /**
     * Retrieves an item from the data store based on its unique identifier.
     *
     * @param id The unique identifier of the item to be retrieved.
     * @return The retrieved item, or null if not found.
     */
    @Override
    public Item read(String id) {
        Optional<Item> itemFound = items.stream()
                .filter(it -> it.getCode().equals(id))
                .findFirst();

        return itemFound.orElse(null);
    }

    /**
     * Updates an existing item in the data store.
     *
     * @param updatedItem The updated item.
     * @return The updated item if successful, or null if the item to be updated is not found.
     */
    @Override
    public Item update(Item updatedItem) {
        Item current = read(updatedItem.getCode());
        if (current != null)
            current = updatedItem;
        return current;
    }

    /**
     * Deletes an item from the data store based on its unique identifier.
     *
     * @param id The unique identifier of the item to be deleted.
     */
    @Override
    public void delete(String id) {
        items.removeIf(it -> it.getCode().equals(id));
    }

    /**
     * Retrieves a list of all items in the data store.
     *
     * @return A list containing all items in the data store.
     */
    @Override
    public List<Item> getAll() {
        return items;
    }
}

