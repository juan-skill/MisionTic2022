package main.controller;

import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import main.view.viewproveedor.DataPanel;
import main.view.viewproveedor.VendorTab;
import main.view.viewproveedor.BarPanel;
import main.view.viewproveedor.ButtonPanel;
import main.view.MainWindow;
import main.access.DAOException.DAOException;
import main.access.concretDAO.VendorDAO;
import main.model.users.VendorModel;


/**
 * Class that represents the Vendor controller (Vendor Tab)
 */
public class VendorController implements ActionListener, KeyListener, ListSelectionListener
{
    // -----------------------------------------------------------------
    // Atrributes
    // -----------------------------------------------------------------

    /**
     * Model DAO tha represents the access to database for Vendor Table.
     */    
    private VendorDAO model;

    /**
     * Panel that represents main panel for vendor tab.
     */
    private VendorTab vendorTab;

    /**
     * Panel that represents panel of datos written by vendor user.
     */
    private DataPanel vDataPanel;

    /**
     * Panel that represents panel of button to execute actions.
     */
    private ButtonPanel vButtonPanel;

    /**
     * Panel that represents panel to display info vendor user.
     */    
    private BarPanel vTablePanel;    


    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * VendorController class constructor method
     */
    public VendorController(MainWindow view, VendorDAO model)
    {
        this.model = model;
        this.vendorTab = view.getVendorTab();
        this.vDataPanel = vendorTab.getDataPanel();
        this.vButtonPanel = vendorTab.getPanelBotones();        
        this.vTablePanel = vendorTab.getPanelBarras();
       
        this.vButtonPanel.assingListenToBtn(this);
        this.vButtonPanel.assingListenToTField(this);
        this.vTablePanel.assignListenerSelection(this);

        loadTableData();
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------    

    /**
     * The actionPerformed() method is invoked automatically whenever 
     * you click on the registered component.
     */
    @Override
    public void actionPerformed(ActionEvent event)
    {        
        List<VendorModel> listaC = null;
        VendorModel vendor = null;
        String name = "", city = "", address = "";
        Long numberID = null;

        if (event.getSource() == vButtonPanel.getBtnInsert())
        {
            try
            {
                numberID = Long.parseLong(vDataPanel.getId());
                
                if (vDataPanel.getName().compareTo("") != 0)
                    name = vDataPanel.getName();
                else
                {
                    name = null;
                    vTablePanel.showAnswer("El campo nombre es obligatorio");
                }

                if (vDataPanel.getCity().compareTo("") != 0)
                    city = vDataPanel.getCity();
                else 
                    city = null;

                if (vDataPanel.getAddress().compareTo("") != 0)
                    address = vDataPanel.getAddress();
                else 
                    address = null;
                
                vendor = new VendorModel(numberID, name, city, address);
    
                model.insertItem(vendor);
                vTablePanel.showAnswer("Inserción exitosa!.");               
                vDataPanel.cleanTextFiel();
                listaC = model.getAllItems();
                vTablePanel.mostrarDatosTable(listaC);
            }
            catch (NumberFormatException e)
            {
                vTablePanel.showAnswer("Asegurese de ingresar los datos");
            }
            catch (DAOException e)
            {
                vTablePanel.showAnswer("Problemas con la inserción " + e.getMessage());
            }
        }        
        if (event.getSource() == vButtonPanel.getBtnSave())
        {
            /*
            try {
                listaC = model.getAllItems();
                vTablePanel.mostrarDatosTable(listaC);                
            } catch (DAOException e) {
                vTablePanel.showAnswer("Problemas al listar");
            }*/
            //loadTableData();

        }
        if (event.getSource() == vButtonPanel.getBtnUpdate())
        {
            int filaEditar = vTablePanel.getTable().getSelectedRow();
            int numfilas = vTablePanel.getTable().getSelectedRowCount();
            
            if (filaEditar >= 0 && numfilas == 1)
            {
                vDataPanel.getTFieldID().setText(String.valueOf(vTablePanel.getTable().getValueAt(filaEditar,0)));

                vDataPanel.getTFieldID().setEditable(false);
                vButtonPanel.disableButton(false);
                vButtonPanel.getBtnOK().setEnabled(true);
            }
            else
            {
                vTablePanel.showAnswer("Seleccione registro a editar");
            }
        }
        if (event.getSource() == vButtonPanel.getBtnOK())
        {
            numberID = Long.parseLong(vDataPanel.getId());            
            
            if (vDataPanel.getName().compareTo("") != 0)
                name = vDataPanel.getName();
            else
            {
                name = null;
                vTablePanel.showAnswer("El nombre es un campo obligatorio");
            }

            if (vDataPanel.getCity().compareTo("") != 0)
                city = vDataPanel.getCity();
            else 
                city = null;

            if (vDataPanel.getAddress().compareTo("") != 0)
                address = vDataPanel.getAddress();
            else 
                address = null;

            vendor = new VendorModel(numberID, name, city, address);

            try
            {                
                model.updateItem(vendor);
                vTablePanel.showAnswer("Exitoso OK");
                vTablePanel.cleanRows();
    
                listaC = model.getAllItems();
                vTablePanel.mostrarDatosTable(listaC);
        
                vDataPanel.getTFieldID().setEditable(true);
                vButtonPanel.disableButton(true);
                vButtonPanel.getBtnOK().setEnabled(false);                    
                vDataPanel.cleanTextFiel();
            } 
            catch (DAOException e)
            {
                vTablePanel.showAnswer("Problemas al listar" + e.getMessage());
            }          
        }
        if (event.getSource() == vButtonPanel.getBtnDelete())
        {
            try
            {
                numberID = Long.parseLong(vDataPanel.getId());

                int answer =  vButtonPanel.confirmeDelete("Desea eliminar registro con number ID: " + numberID + "? ");
                if (answer == 0)
                {
                    model.deleteItem(numberID);
                    vTablePanel.showAnswer("Registro eliminado exitosamente");
                }

                vDataPanel.cleanTextFiel();
                listaC = model.getAllItems();
                vTablePanel.mostrarDatosTable(listaC);
            }
            catch (NumberFormatException e) 
            {
                vTablePanel.showAnswer("Seleccione registro a editar");
            }
            catch (DAOException e)
            {
                vTablePanel.showAnswer("Problemas al eliminar " + e.getMessage());
            }
        }
    }


    /**
     * Method is invoked whenever a key is pressed. 
     * The most recently typed ASCII key is stored into the ‘key’ variable
     */
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

    /**
     * function is invoked whenever a key is called every time when a key is pressed.
     * Searching by vendor name using a TextField while a use type a character.
     */
    @Override
    public void keyReleased(KeyEvent e)
    {
        List<VendorModel> listaC = null;

        if (e.getSource()== vButtonPanel.getTfSearch())
        {
            String name = vButtonPanel.getTfSearch().getText();

            try {
                listaC = model.getFilteredVendor(name);    
            } catch (DAOException ex) {
                vTablePanel.showAnswer("Problemas en la busqueda " + ex.getMessage());
            }
            
            vTablePanel.mostrarDatosTable(listaC);
        }
    }

    public void loadTableData()
    {
        List<VendorModel> listaC = null;

        try {
            listaC = model.getAllItems();
            vTablePanel.mostrarDatosTable(listaC);                
        } catch (DAOException e) {
            vTablePanel.showAnswer("Problemas al listar");
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        boolean isSelection = (vTablePanel.getTable().getSelectedRow() != -1);

        vButtonPanel.getBtnUpdate().setEnabled(isSelection);
        vButtonPanel.getBtnDelete().setEnabled(isSelection);
        
    }
}