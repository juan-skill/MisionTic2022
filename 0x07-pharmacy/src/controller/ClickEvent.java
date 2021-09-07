package controller;

import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.viewproveedor.PanelDatos;
import view.viewproveedor.PestañaProveedor;
import view.viewproveedor.BarPanel;
import view.viewproveedor.ButtonPanel;

import java.text.ParseException;

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
            try
            {
                name = vPanelDatos.getNombre();
                numberID = Long.parseLong(vPanelDatos.getId());
                city = vPanelDatos.getCiudad();
                address = vPanelDatos.getDireccion();
                
                vendor = new VendorModel(numberID, name, city, address);
    
                vPanelBarras.showAnswer(vendorModel.insertVendor(vendor));
                vPanelDatos.cleanTextFiel();
            }
            catch (NumberFormatException e)
            {
                vPanelBarras.showAnswer("Asegurese de ingresar los datos");
            }

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
            /*
            name = vPanelDatos.getNombre();
            numberID = Long.parseLong(vPanelDatos.getId());
            city = vPanelDatos.getCiudad();
            address = vPanelDatos.getDireccion();
            
            vendor = new VendorModel(numberID, name, city, address);
            */
            int filaEditar = vPanelBarras.getTable().getSelectedRow();
            int numfilas = vPanelBarras.getTable().getSelectedRowCount();
            
            if (filaEditar >= 0 && numfilas == 1)
            {
                vPanelDatos.getTFieldID().setText(String.valueOf(vPanelBarras.getTable().getValueAt(filaEditar,0)));

                vPanelDatos.getTFieldID().setEditable(false);
                vPanelBotones.getBtnOK().setEnabled(true);
                vPanelBotones.getBtnUpdate().setEnabled(false);
                vPanelBotones.getBtnDelete().setEnabled(false);
                vPanelBotones.getBtnInsert().setEnabled(false);
                vPanelBotones.getBtnList().setEnabled(false);
            }
            else
            {
                vPanelBarras.showAnswer("Seleccione registro a editar");
            }
            
            //vPanelBarras.showAnswer(vendorModel.updateVendor(vendor));
        }
        if (evento.getSource() == vPanelBotones.getBtnOK())
        {
            name = vPanelDatos.getNombre();
            numberID = Long.parseLong(vPanelDatos.getId());
            city = vPanelDatos.getCiudad();
            address = vPanelDatos.getDireccion();
            
            vendor = new VendorModel(numberID, name, city, address);
            vPanelBarras.showAnswer(vendorModel.updateVendor(vendor));
            vPanelBarras.cleanRows();

            listaC = vendorModel.getAllVendors();
            vPanelBarras.mostrarDatosTable(listaC);

            vPanelDatos.getTFieldID().setEditable(true);
            vPanelBotones.getBtnOK().setEnabled(false);
            vPanelBotones.getBtnUpdate().setEnabled(true);
            vPanelBotones.getBtnDelete().setEnabled(true);
            vPanelBotones.getBtnInsert().setEnabled(true);
            vPanelBotones.getBtnList().setEnabled(true);

            vPanelDatos.cleanTextFiel();
        }
        if (evento.getSource() == vPanelBotones.getBtnDelete())
        {
            try
            {
                numberID = Long.parseLong(vPanelDatos.getId());
                vPanelBarras.showAnswer(vendorModel.deleteVendor(numberID));
                vPanelDatos.cleanTextFiel();
            }
            catch (NumberFormatException e) 
            {
                vPanelBarras.showAnswer("Seleccione registro a editar");
                //e.printStackTrace();
            }
            
            
        }
    }
}