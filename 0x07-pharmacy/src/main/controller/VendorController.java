package main.controller;

import java.util.List;

import javax.swing.JOptionPane;
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
import main.access.concretDAO.ManagerDAO;
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

    /**
     * Status to indicate if I should update() or insert()
     */
    private boolean status = false;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * VendorController class constructor method
     */
    public VendorController(MainWindow view, ManagerDAO managerDAO) throws DAOException
    {
        this.model = managerDAO.getVendorDAO();
        this.vendorTab = view.getVendorTab();
        this.vDataPanel = vendorTab.getDataPanel();
        this.vButtonPanel = vendorTab.getPanelBotones();        
        this.vTablePanel = vendorTab.getPanelBarras();

        // assing listener
        this.vButtonPanel.assingListenToBtn(this);
        this.vButtonPanel.assingListenToTField(this);
        this.vTablePanel.assignListenerSelection(this);

        // load table's data
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
        VendorModel vendor = null;
        

        if (event.getSource() == vButtonPanel.getBtnInsert())
        {
            vDataPanel.loadData(null);
            vDataPanel.setEditable(true);
            vButtonPanel.getBtnSave().setEnabled(true);
            vButtonPanel.getBtnOK().setEnabled(true);
            status = false;
        }        
        if (event.getSource() == vButtonPanel.getBtnSave())
        {
            vendor = saveModelData();
            try
            {
                if (status == false)
                    model.insertItem(vendor);
                else
                {
                    model.updateItem(vendor);
                }
                
                vDataPanel.setEditable(false);
                vTablePanel.getTable().clearSelection();
                vDataPanel.loadData(null);
                vButtonPanel.getBtnSave().setEnabled(false);
                vButtonPanel.getBtnOK().setEnabled(false);
                vTablePanel.getTable().requestFocus();
                
                vTablePanel.getTableModel().updateModel(model.getAllItems());
                vTablePanel.getTableModel().fireTableDataChanged();
            }
            catch (DAOException e)
            {
                vTablePanel.showAnswer(e.getMessage());
            }
        }
        if (event.getSource() == vButtonPanel.getBtnUpdate())
        {
            try
            {
                status = true;
                vendor = getVendorSelected();
                vDataPanel.setEditable(true);
                vDataPanel.loadData(vendor);
                vButtonPanel.getBtnOK().setEnabled(true);
                vButtonPanel.getBtnSave().setEnabled(true);
                vDataPanel.getTFieldID().requestFocus();
            } 
            catch (DAOException ex)
            {
                vTablePanel.showAnswer(ex.getMessage());
            }
            catch (NumberFormatException ex)
            {
                vTablePanel.showAnswer("Error campo Identification");
            }
        }
        if (event.getSource() == vButtonPanel.getBtnOK())
        {
            vDataPanel.setEditable(false);
            vTablePanel.getTable().clearSelection();
            vDataPanel.loadData(null);
            vButtonPanel.getBtnSave().setEnabled(false);
            vButtonPanel.getBtnOK().setEnabled(false);
            vTablePanel.getTable().requestFocus();
        }
        if (event.getSource() == vButtonPanel.getBtnDelete())
        {
            if (JOptionPane.showConfirmDialog(null, 
                                              "¿Está seguro que quiere eliminar?",
                                              "Borrar Vendor", 
                                              JOptionPane.YES_NO_OPTION, 
                                              JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
            {
                try 
                {
                    vendor = getVendorSelected();
                    model.deleteItem(vendor.getNumberID());
                    vTablePanel.getTableModel().updateModel(model.getAllItems());
                    vTablePanel.getTableModel().fireTableDataChanged();
                } 
                catch (DAOException ex) 
                {
                    vTablePanel.showAnswer(ex.getMessage());
                }
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

    /**
     * Called whenever the value of the selection changes.
     * @param e ListSelectionEvent to get resource from invoke
     */
    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        boolean isSelection = (vTablePanel.getTable().getSelectedRow() != -1);

        vButtonPanel.getBtnUpdate().setEnabled(isSelection);
        vButtonPanel.getBtnDelete().setEnabled(isSelection);
    }

    /**
     * Load data to the table from database
     */    
    public void loadTableData() throws DAOException
    {
        List<VendorModel> listVendors = model.getAllItems();
        vTablePanel.mostrarDatosTable(listVendors);
    }

    /**
     * Get the data from getSelectedRow
     * @return A VendorModel instance to retrieved from dabase
     * @throws DAOException
     */
    public VendorModel getVendorSelected() throws DAOException
    {
        Long numberID = null;

        numberID = (Long) vTablePanel.getTable().getValueAt(vTablePanel.getTable().getSelectedRow(), 0);

        return model.getItem(numberID);
    }

    /**
     * Retrieve the text of the text field.
     * @return VendorModel instance.
     */
    public VendorModel saveModelData()
    {
        VendorModel vendor = new VendorModel();

        try
        {
            vendor.setNumberID(Long.parseLong(vDataPanel.getTFieldID().getText().trim()));
            vendor.setName(vDataPanel.getTFieldName().getText().trim());
            vendor.setAddress(vDataPanel.getTFieldAddress().getText().trim());
            vendor.setCity(vDataPanel.getTFieldCity().getText().trim());
        }
        catch (NumberFormatException ex)
        {
            vTablePanel.showAnswer(ex.getMessage());
        }

        return vendor;
    }
}