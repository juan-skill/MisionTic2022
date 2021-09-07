package controller;

import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import view.viewproveedor.DataPanel;
import view.viewproveedor.VendorTab;
import view.viewproveedor.BarPanel;
import view.viewproveedor.ButtonPanel;



import access.VendorDAO;
import model.VendorModel;


/**
 * 
 */
public class ClickEvent implements ActionListener, KeyListener
{
    private VendorTab pestañaProveedor;
    private VendorDAO vendorModel;
    private DataPanel vDataPanel;
    private ButtonPanel vPanelBotones;
    private BarPanel vPanelBarras;

    public ClickEvent (VendorTab pestañaProveedor)
    {
        this.vendorModel = new VendorDAO();
        this.pestañaProveedor = pestañaProveedor;
        this.vDataPanel = pestañaProveedor.getDataPanel();
        this.vPanelBotones = pestañaProveedor.getPanelBotones();        
        this.vPanelBarras = pestañaProveedor.getPanelBarras();        
        this.vPanelBotones.assingListenToBtn(this);
        this.vPanelBotones.assingListenToTField(this);
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
                name = vDataPanel.getName();
                numberID = Long.parseLong(vDataPanel.getId());
                city = vDataPanel.getCity();
                address = vDataPanel.getAddress();
                
                vendor = new VendorModel(numberID, name, city, address);
    
                vPanelBarras.showAnswer(vendorModel.insertVendor(vendor));
                vDataPanel.cleanTextFiel();
                listaC = vendorModel.getAllVendors();
                vPanelBarras.mostrarDatosTable(listaC);
            }
            catch (NumberFormatException e)
            {
                vPanelBarras.showAnswer("Asegurese de ingresar los datos");
            }
        }        
        if (evento.getSource() == vPanelBotones.getBtnList())
        {
            listaC = vendorModel.getAllVendors();
            vPanelBarras.mostrarDatosTable(listaC);
        }
        if (evento.getSource() == vPanelBotones.getBtnUpdate())
        {
            int filaEditar = vPanelBarras.getTable().getSelectedRow();
            int numfilas = vPanelBarras.getTable().getSelectedRowCount();
            
            if (filaEditar >= 0 && numfilas == 1)
            {
                vDataPanel.getTFieldID().setText(String.valueOf(vPanelBarras.getTable().getValueAt(filaEditar,0)));

                vDataPanel.getTFieldID().setEditable(false);
                vPanelBotones.disableButton(false);
                vPanelBotones.getBtnOK().setEnabled(true);
            }
            else
            {
                vPanelBarras.showAnswer("Seleccione registro a editar");
            }
        }
        if (evento.getSource() == vPanelBotones.getBtnOK())
        {
            name = vDataPanel.getName();
            numberID = Long.parseLong(vDataPanel.getId());
            city = vDataPanel.getCity();
            address = vDataPanel.getAddress();
            
            vendor = new VendorModel(numberID, name, city, address);
            vPanelBarras.showAnswer(vendorModel.updateVendor(vendor));
            vPanelBarras.cleanRows();

            listaC = vendorModel.getAllVendors();
            vPanelBarras.mostrarDatosTable(listaC);

            vDataPanel.getTFieldID().setEditable(true);
            vPanelBotones.disableButton(true);
            vPanelBotones.getBtnOK().setEnabled(false);

            vDataPanel.cleanTextFiel();
        }
        if (evento.getSource() == vPanelBotones.getBtnDelete())
        {
            try
            {
                numberID = Long.parseLong(vDataPanel.getId());

                int rpta =  vPanelBotones.confirmeDelete("Desea eliminar registro con number ID: " + numberID + "? ");
                if (rpta == 0)
                {
                    vPanelBarras.showAnswer(vendorModel.deleteVendor(numberID));
                }

                vDataPanel.cleanTextFiel();
                listaC = vendorModel.getAllVendors();
                vPanelBarras.mostrarDatosTable(listaC);
            }
            catch (NumberFormatException e) 
            {
                vPanelBarras.showAnswer("Seleccione registro a editar");
            }
        }
    }


    @Override
    public void keyPressed(KeyEvent event)
    {
        if (event.getSource() == vDataPanel.getTFieldID())
        {
            char c = event.getKeyChar();
            
            if (c < '0' || c > '9')
            {
                event.consume();
            }
        }        
        if (event.getSource() == vDataPanel.getTFieldName())
        {
            char c = event.getKeyChar();

            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != (char) KeyEvent.VK_SPACE))
            {
                event.consume();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {}

    @Override
    public void keyReleased(KeyEvent e)
    {
        List<VendorModel> listaC = null;

        if (e.getSource()== vPanelBotones.getTfSearch())
        {
            String name = vPanelBotones.getTfSearch().getText();

            listaC = vendorModel.getFilteredVendor(name);
            vPanelBarras.mostrarDatosTable(listaC);
        }
    }

}