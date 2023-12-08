package org.mercadolibre.dao;

import java.util.List;

/**
 * This interface represents the basic CRUD operations (Create, Read, Update, Delete)
 * for a generic type T.
 *
 * @param <T> The type of object for which CRUD operations are defined.
 */
public interface CRUD<T> {
    /**
     * Creates a new object in the data store.
     *
     * @param obj The object to be created.
     * @return The created object.
     */
    T create(T obj);

    /**
     * Retrieves an object from the data store based on its unique identifier.
     *
     * @param id The unique identifier of the object to be retrieved.
     * @return The retrieved object, or null if not found.
     */
    T read(String id);

    /**
     * Updates an existing object in the data store.
     *
     * @param obj The object to be updated.
     * @return The updated object.
     */
    T update(T obj);

    /**
     * Deletes an object from the data store based on its unique identifier.
     *
     * @param id The unique identifier of the object to be deleted.
     */
    void delete(String id);

    /**
     * Retrieves a list of all objects in the data store.
     *
     * @return A list containing all objects in the data store.
     */
    List<T> getAll();
}
