package main.access.abstractionsDAO;

import java.util.List;

/**
 * Interface DAO that implementing methods prototype of CRUD operations.
 * 
 * @param T Datatype model
 * @param k Datatype id
 */
public interface iDAO<T, K>
{
    /**
     * Retrieve all of the items in the T table database.
     * @return List of the T models.
     */    
    public List<T> getAllItems();

    /**
     * Retrieve a object.
     * @param id attribute to find the vendor.
     * @return An instance of T model.
     */
    public T getItem(K id);

    /**
     * Insert a item in the T table database.
     * @param vendor attribute to insert the item to database.
     * @return Message.
     */
    public String insertItem(T item);

    /**
     * Update a client in the T table database.
     * @param item attribute to update the item to database
     * @return Message.
     */
    public String updateItem(T item);

    /**
     * Delete a item in the T table database by id attribute.
     * @param id attribute to find the item.
     * @return Message.
     */
    public String deleteItem(K id);
}
