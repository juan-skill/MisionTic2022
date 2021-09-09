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
import view.MainWindow;
import access.VendorDAO;
import model.users.VendorModel;


/**
 * Class that represents the Vendor controller (Vendor Tab)
 */
public class VendorController implements ActionListener, KeyListener
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
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------    

    /**
     * The actionPerformed() method is invoked automatically whenever 
     * you click on the registered component.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        
        List<VendorModel> listaC = null;
        VendorModel vendor = null;
        String name = "", city = "", address = "";
        Long numberID = null;

        if (event.getSource() == vButtonPanel.getBtnInsert())
        {
            try
            {
                name = vDataPanel.getName();
                numberID = Long.parseLong(vDataPanel.getId());
                city = vDataPanel.getCity();
                address = vDataPanel.getAddress();
                
                vendor = new VendorModel(numberID, name, city, address);
    
                vTablePanel.showAnswer(model.insertVendor(vendor));
                vDataPanel.cleanTextFiel();
                listaC = model.getAllVendors();
                vTablePanel.mostrarDatosTable(listaC);
            }
            catch (NumberFormatException e)
            {
                vTablePanel.showAnswer("Asegurese de ingresar los datos");
            }
        }        
        if (event.getSource() == vButtonPanel.getBtnList())
        {
            listaC = model.getAllVendors();
            vTablePanel.mostrarDatosTable(listaC);
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
            name = vDataPanel.getName();
            numberID = Long.parseLong(vDataPanel.getId());
            city = vDataPanel.getCity();
            address = vDataPanel.getAddress();

            if (name.compareTo("") != 0)
            {
                vendor = new VendorModel(numberID, name, city, address);
                vTablePanel.showAnswer(model.updateVendor(vendor));
                vTablePanel.cleanRows();
    
                listaC = model.getAllVendors();
                vTablePanel.mostrarDatosTable(listaC);
    
                vDataPanel.getTFieldID().setEditable(true);
                vButtonPanel.disableButton(true);
                vButtonPanel.getBtnOK().setEnabled(false);
    
                vDataPanel.cleanTextFiel();
            }
            else
            {
                vTablePanel.showAnswer("El nombre es un campo obligatorio");
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
                    vTablePanel.showAnswer(model.deleteVendor(numberID));
                }

                vDataPanel.cleanTextFiel();
                listaC = model.getAllVendors();
                vTablePanel.mostrarDatosTable(listaC);
            }
            catch (NumberFormatException e) 
            {
                vTablePanel.showAnswer("Seleccione registro a editar");
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

            listaC = model.getFilteredVendor(name);
            vTablePanel.mostrarDatosTable(listaC);
        }
    }

}