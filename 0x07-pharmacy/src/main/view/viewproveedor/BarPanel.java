package main.view.viewproveedor;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;
import java.awt.Font;

import main.model.users.VendorModel;

import java.util.List;

/**
 * Class that represents the panel  who will show proveedores table
 */
public class BarPanel extends JPanel
{
    // -----------------------------------------------------------------
    // Atrributes
    // -----------------------------------------------------------------

    /**
     * ScrollPanel provides a scrollable view of the table.
     */
    private JScrollPane scrollPane;

    /**
     * table arranges data in a tabular form.
     */
    private JTable table;

    /**
     * 
     */
    private VendorTableModel tableMode;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * BarPanel class constructor method
     */
    public BarPanel()
    {
        initComponents();
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------    

    /**
     * Configure the table to display the vendors users.
     */
    public void initComponents()
    {
        table  = new JTable();
        tableMode = new VendorTableModel();
        table.setModel(tableMode);
        
        table.setRowHeight(20);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(40);
        table.getColumnModel().getColumn(2).setPreferredWidth(40);
        table.getColumnModel().getColumn(3).setPreferredWidth(300);

        table.setDefaultEditor(Object.class, null);

        table.getTableHeader().setBackground(new Color(192, 192, 192));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Tahome", Font.BOLD, 15));

        scrollPane = new JScrollPane(table);

        setLayout(null);

        scrollPane.setBounds(20, 20, 1030, 300);
        add(scrollPane);
    }

    /**
     * Load values from a list to a table.
     * @param list to traversing each of the elements as a row inside the table.
     */
    public void mostrarDatosTable(List<VendorModel> list)
    {
        tableMode.updateModel(list);
        tableMode.fireTableStructureChanged(); 
    }

    /**
     * Display information about a database transaction.
     * @param message Message to display.
     */
    public void showAnswer(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Return table data.
     * @return table.
     */
    public JTable getTable()
    {
        return table;
    }

    /**
     * Return table model.
     * @return table model.
     */
    public VendorTableModel getTableModel()
    {
        return tableMode;
    }

    /**
     * The listener interface for receiving action events of the textfield component.
     * @param event  which indicates that a keystroke occurred in the TextFiel.
     */
    public void assignListenerSelection(ListSelectionListener event)
    {
        table.getSelectionModel().addListSelectionListener(event);
    }
}