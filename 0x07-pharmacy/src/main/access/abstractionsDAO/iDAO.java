package main.access.abstractionsDAO;

import java.util.List;

import main.access.DAOException.DAOException;

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
    public List<T> getAllItems() throws DAOException;

    /**
     * Retrieve a object.
     * @param id attribute to find the vendor.
     * @return An instance of T model.
     */
    public T getItem(K id) throws DAOException;

    /**
     * Insert a item in the T table database.
     * @param vendor attribute to insert the item to database.
     * @return Message.
     */
    public void insertItem(T item) throws DAOException;

    /**
     * Update a client in the T table database.
     * @param item attribute to update the item to database
     * @return Message.
     */
    public void updateItem(T item) throws DAOException;

    /**
     * Delete a item in the T table database by id attribute.
     * @param id attribute to find the item.
     * @return Message.
     */
    public void deleteItem(K id) throws DAOException;
}
