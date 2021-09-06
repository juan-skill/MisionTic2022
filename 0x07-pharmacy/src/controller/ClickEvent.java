package controller;

import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.viewproveedor.PanelDatos;
import view.viewproveedor.PestañaProveedor;
import view.viewproveedor.PanelBarras;
import view.viewproveedor.PanelBotones;

import access.VendorDAO;
import model.VendorModel;


/**
 * 
 */
public class ClickEvent implements ActionListener
{
    private PestañaProveedor pestañaProveedor;
    private VendorDAO vendorModel;
    private PanelDatos vPanelDatos;
    private PanelBotones vPanelBotones;
    private PanelBarras vPanelBarras;

    public ClickEvent (PestañaProveedor pestañaProveedor)
    {
        this.vendorModel = new VendorDAO();
        this.pestañaProveedor = pestañaProveedor;
        
        this.vPanelBotones = pestañaProveedor.getPanelBotones();
        this.vPanelDatos = pestañaProveedor.getPanelDatos();
        this.vPanelBarras = pestañaProveedor.getPanelBarras();
        this.vPanelDatos.asignarEscuchas(this);
        this.vPanelBotones.asignarEscuchas(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        
        List<VendorModel> listaC = null;
        VendorModel vendor = null;
        String name = "", city = "", address = "";
        Long numberID = null;

        if (evento.getSource() == vPanelDatos.getbIngresar())
        {
            name = vPanelDatos.getNombre();
            numberID = Long.parseLong(vPanelDatos.getId());
            city = vPanelDatos.getCiudad();
            address = vPanelDatos.getDireccion();
            
            vendor = new VendorModel(numberID, name, city, address);

            vPanelBarras.mostarArea(vendorModel.insertVendor(vendor));
        }        
        if (evento.getSource() == vPanelBotones.getbMostrar())
        {
            listaC = vendorModel.getAllVendors();
            vPanelBarras.mostrarDatos(listaC, "Los proveedores son: " + 
                                              "\nIdentificador" + 
                                              "\tNombre" +
                                              "\tCiudad" + 
                                              "\tDireccion\n");
        }
        if (evento.getSource() == vPanelBotones.getbModificar())
        {
            name = vPanelDatos.getNombre();
            numberID = Long.parseLong(vPanelDatos.getId());
            city = vPanelDatos.getCiudad();
            address = vPanelDatos.getDireccion();
            
            vendor = new VendorModel(numberID, name, city, address);
            vPanelBarras.mostarArea(vendorModel.updateVendor(vendor));
        }
        if (evento.getSource() == vPanelBotones.getbBorrar())
        {
            numberID = Long.parseLong(vPanelDatos.getId());
            vPanelBarras.mostarArea(vendorModel.deleteVendor(numberID));
        }
    }
}