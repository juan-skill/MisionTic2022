package controller;

import access.VendorDAO;
import java.util.List;
import model.VendorModel;

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