package controller;

import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.viewproveedor.PanelDatos;
import view.viewproveedor.PestañaProveedor;
import view.viewproveedor.BarPanel;
import view.viewproveedor.ButtonPanel;

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
    private ButtonPanel vPanelBotones;
    private BarPanel vPanelBarras;

    public ClickEvent (PestañaProveedor pestañaProveedor)
    {
        this.vendorModel = new VendorDAO();
        this.pestañaProveedor = pestañaProveedor;
        this.vPanelDatos = pestañaProveedor.getPanelDatos();
        this.vPanelBotones = pestañaProveedor.getPanelBotones();        
        this.vPanelBarras = pestañaProveedor.getPanelBarras();        
        this.vPanelBotones.asignarEscuchas(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        
        List<VendorModel> listaC = null;
        VendorModel vendor = null;
        String name = "", city = "", address = "";
        Long numberID = null;

        if (evento.getSource() == vPanelBotones.getBtnInsert())
        {
            name = vPanelDatos.getNombre();
            numberID = Long.parseLong(vPanelDatos.getId());
            city = vPanelDatos.getCiudad();
            address = vPanelDatos.getDireccion();
            
            vendor = new VendorModel(numberID, name, city, address);

            vPanelBarras.showAnswer(vendorModel.insertVendor(vendor));
        }        
        if (evento.getSource() == vPanelBotones.getBtnList())
        {
            listaC = vendorModel.getAllVendors();
            /*
            vPanelBarras.mostrarDatos(listaC, "Los proveedores son: " + 
                                              "\nIdentificador" + 
                                              "\tNombre" +
                                              "\tCiudad" + 
                                              "\tDireccion\n");
            */
            vPanelBarras.mostrarDatosTable(listaC);
        }
        if (evento.getSource() == vPanelBotones.getBtnUpdate())
        {
            name = vPanelDatos.getNombre();
            numberID = Long.parseLong(vPanelDatos.getId());
            city = vPanelDatos.getCiudad();
            address = vPanelDatos.getDireccion();
            
            vendor = new VendorModel(numberID, name, city, address);
            vPanelBarras.showAnswer(vendorModel.updateVendor(vendor));
        }
        if (evento.getSource() == vPanelBotones.getBtnDelete())
        {
            numberID = Long.parseLong(vPanelDatos.getId());
            vPanelBarras.showAnswer(vendorModel.deleteVendor(numberID));
        }
    }
}