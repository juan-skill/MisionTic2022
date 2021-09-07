package view.viewproveedor;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;


/**
 * Class that represents the buttons panel to operate CRUD
 */
public class ButtonPanel extends JPanel
{
    // -----------------------------------------------------------------
    // Atrributes
    // -----------------------------------------------------------------

    /**
     * Button to list the info into the table.
     */
    private JButton btnList;
    
    /**
     * Button to delete a record.
     */    
    private JButton btnDelete;

    /**
     * Update to delete a record.
     */    
    private JButton btnUpdate;

    /**
     * Update to confirm a change of a record.
     */    
    private JButton btnOK;

    /**
     * Update to insert a record.
     */    
    private JButton btnInsert;

    /**
     * textfield to write a search.
     */    
    private JTextField tfSearch;    

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * ButtonPanel class constructor method
     */
    public ButtonPanel()
    {
        initComponents();
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------    

    /**
     * Prepare the layout of the button slots.
     */    
    public void initComponents()
    {
        btnList = new JButton("LIST");
        btnDelete = new JButton("DELETE");
        btnUpdate = new JButton("UPDATE");        
        btnInsert = new JButton("INSERT");
        btnOK = new JButton("OK");
        btnOK.setEnabled(false);

        tfSearch = new JTextField(10);

        setLayout(new GridLayout(1,3,2,2));                
        add(btnDelete); 
        add(btnUpdate);
        add(btnOK);
        add(btnList);
        add(btnInsert);        
        add(tfSearch);
    }

    /**
     * Return btnDelete button.
     * @return btnDelete.
     */
    public JButton getBtnDelete() {
        return btnDelete;
    }

    /**
     * Return btnUpte button.
     * @return btnUpdate.
     */
    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    /**
     * Return btnList button.
     * @return btnList.
     */
    public JButton getBtnList() {
        return btnList;
    }

    /**
     * Return btnInsert button.
     * @return btnInsert.
     */
    public JButton getBtnInsert() {
        return btnInsert;
    }

    /**
     * Return btnOK button.
     * @return btnOk.
     */
    public JButton getBtnOK() {
        return btnOK;
    }

    
    /**
     * Return tfSearch button.
     * @return tfSearch.
     */
    public JTextField getTfSearch() {
        return tfSearch;
    }

    /**
     * The listener interface for receiving action events each of the buttons.
     * @param evento to assigns it.
     */
    public void asignarEscuchas(ActionListener evento)
    {
        btnUpdate.addActionListener(evento);
        btnList.addActionListener(evento);
        btnDelete.addActionListener(evento);        
        btnInsert.addActionListener(evento);
        btnOK.addActionListener(evento);
    }

    /**
     * The listener interface for receiving action events of the textfield component.
     * @param event  which indicates that a keystroke occurred in the TextFiel.
     */
    public void assingListenToTField(KeyListener event)
    {
        tfSearch.addKeyListener(event);
    }    

}