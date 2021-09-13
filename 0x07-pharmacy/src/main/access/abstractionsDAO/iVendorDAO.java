package main.access.abstractionsDAO;

import java.util.List;

import main.access.DAOException.DAOException;
import main.model.users.VendorModel;

/**
 * Interface DAO that interitance iDAO<T, K> interface.
 * Assign concrete values to the iDAO<VendorModel, Long>
 * 
 * @param ClienteModel Datatype model
 * @param Long Datatype id
 */
public interface iVendorDAO extends iDAO<VendorModel, Long>
{
    /**
     * Retrieve all of the items filtering by name.
     * @return Vendor model list.
     */    
    public List<VendorModel> getFilteredVendor(String name) throws DAOException;
}
