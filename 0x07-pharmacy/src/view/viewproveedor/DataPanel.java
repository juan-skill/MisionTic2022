package view.viewproveedor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;

/**
 * Class that represents the buttons panel to type user info
 */
public class DataPanel extends JPanel
{
    // -----------------------------------------------------------------
    // Atrributes
    // -----------------------------------------------------------------

    /**
     * Label to indicate number ID.
     */
    private JLabel lId;

    /**
     * Label to indicate name.
     */
    private JLabel lbName;

    /**
     * Label to indicate ciudad.
     */
    private JLabel lbCity;

    /**
     * Label to indicate direccion.
     */    
    private JLabel lbAddress;

    /**
     * TextField to write number ID.
     */    
    private JTextField tfId;

    /**
     * TextField to write  name.
     */    
    private JTextField tfName;

    /**
     * TextField to write ciudad.
     */    
    private JTextField tfCity;

    /**
     * TextField to write address.
     */        
    private JTextField tfAddress;    
        
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * DataPanel class constructor method
     */
    public DataPanel()
    {
        initComponents();
    }
    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------    

    /**
     * Prepare the layout to dispose TextField.
     */
    public void initComponents()
    {
        lId = new JLabel("Identificacion:");
        tfId = new JTextField(10);
        lbName = new JLabel("Nombre:");
        tfName = new JTextField(10);
        lbCity = new JLabel("Ciudad: ");
        tfCity = new JTextField(10);
        lbAddress = new JLabel("Direccion: ");
        tfAddress = new JTextField(10);                
            
        setLayout(new GridLayout(1, 9, 2, 2));
        add(lId);
        add(tfId);
        add(lbName); 
        add(tfName);
        add(lbCity);
        add(tfCity);
        add(lbAddress);
        add(tfAddress);
    }

    /**
     * returns the content of the text field tfName.
     * @return a string.
     */    
    public String getName()
    {
        return tfName.getText().trim();
    }

    /**
     * Return the content of the text field tfId.
     * @return a string.
     */
    public String getId()
    {
        return tfId.getText().trim();
    }

    /**
     * Return the content of the text field tfCity.
     * @return a string.
     */    
    public String getCity()
    {
        return tfCity.getText().trim();
    }

    /**
     * Return the content of the text field tfAddress.
     * @return a string.
     */    
    public String getAddress()
    {
        return tfAddress.getText().trim();
    }

    /**
     * Return ID's TextField
     * @return tfID
     */
    public JTextField getTFieldID()
    {
        return tfId;
    }

    /**
     * Return Name's TextField
     * @return tfID
     */
    public JTextField getTFieldName()
    {
        return tfName;
    }

    /**
     * method that deletes (clears) the textfield that are written on it
     */
    public void cleanTextFiel()
    {
        tfId.setText("");
        tfId.setEditable(true);
        tfName.setText("");
        tfCity.setText("");
        tfAddress.setText("");
    }
}