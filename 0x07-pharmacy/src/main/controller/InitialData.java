package main.controller;

import main.access.VendorDAO;
import java.util.List;
import main.model.users.VendorModel;

/**
 *
 * @author juan
 */
public class InitialData {
    private List<VendorModel> proveedores = null;
    
    /**
     * Zero-parameters constructor
     */
    public InitialData(){
        VendorDAO proveedorDAO = new VendorDAO();
        this.proveedores = proveedorDAO.getAllVendors();
    }

    /**
     * @return the proveedores
     */
    public List<VendorModel> getMuseums() {
        return proveedores;
    }
}