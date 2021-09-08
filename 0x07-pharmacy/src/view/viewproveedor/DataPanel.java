package view.viewproveedor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;


/**
 * Class that represents the buttons panel to type user info
 */
public class DataPanel extends JPanel
{
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Constant to list all of the vendor users of the vendor table (query sql)
     */
    private static final String iconPath = "../../images/vendor.png";    

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
    
    /**
     * Vendor Image.
     */    
    private JLabel vendorImage;
        
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
        int xLbl = 30, yLbl = 25, width = 150, height = 25, horizontalAlignment = 30, verticalAlignment = 10;
        
        lId = new JLabel("Identificacion:");
        lId.setBounds(xLbl, yLbl + (height * 0) + (verticalAlignment * 0), width, height);
        lId.setHorizontalAlignment(JLabel.CENTER);
        lId.setOpaque(true);
        //lId.setBackground(Color.YELLOW);

        tfId = new JTextField(10);
        tfId.setBounds(xLbl + width + horizontalAlignment, yLbl + (height * 0) + (verticalAlignment * 0), width, height);
        tfId.setOpaque(false);
        tfId.setBackground(Color.WHITE);
        tfId.setHorizontalAlignment(JLabel.CENTER);;
        tfId.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));       
        
        lbName = new JLabel("Nombre:         ");
        lbName.setBounds(xLbl, yLbl + (height * 1) + (verticalAlignment * 1), width, height);
        lbName.setHorizontalAlignment(JLabel.CENTER);
        lbName.setOpaque(true);
        //lbName.setBackground(Color.YELLOW);
        
        tfName = new JTextField(10);
        tfName.setBounds(xLbl + width + horizontalAlignment, yLbl + (height * 1) + (verticalAlignment * 1), width, height);
        tfName.setOpaque(false);
        tfName.setBackground(Color.WHITE);
        tfName.setHorizontalAlignment(JLabel.CENTER);;
        tfName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        lbCity = new JLabel("Ciudad:          ");
        lbCity.setBounds(xLbl, yLbl + (height * 2) + (verticalAlignment * 2), width, height);
        lbCity.setHorizontalAlignment(JLabel.CENTER);
        lbCity.setOpaque(true);
        //lbCity.setBackground(Color.YELLOW);
        
        tfCity = new JTextField(10);
        tfCity.setBounds(xLbl + width + horizontalAlignment, yLbl + (height * 2) + (verticalAlignment * 2), width, height);
        tfCity.setOpaque(false);
        tfCity.setBackground(Color.WHITE);
        tfCity.setHorizontalAlignment(JLabel.CENTER);;
        tfCity.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        lbAddress = new JLabel("Direccion:      ");
        lbAddress.setBounds(xLbl, yLbl + (height * 3) + (verticalAlignment * 3), width, height);
        lbAddress.setHorizontalAlignment(JLabel.CENTER);
        lbAddress.setOpaque(true);
        //lbAddress.setBackground(Color.YELLOW);

        tfAddress = new JTextField(10);
        tfAddress.setBounds(xLbl + width + horizontalAlignment, yLbl + (height * 3) + (verticalAlignment * 3), width, height);
        tfAddress.setOpaque(false);
        tfAddress.setBackground(Color.WHITE);
        tfAddress.setHorizontalAlignment(JLabel.CENTER);;
        tfAddress.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));        
        
        
        

        Image img = new ImageIcon(getClass().getResource(iconPath)).getImage();
        Image newimg = img.getScaledInstance(170, 170,  Image.SCALE_SMOOTH);
        Icon icon = new ImageIcon(newimg);                
        vendorImage = new JLabel(icon);
        vendorImage.setOpaque(true);

        JPanel pane = new JPanel();
        //pane.setLayout(new GridLayout(4, 2));
        pane.setLayout(null);
        
        //setLayout(new GridLayout(1, 9, 2, 2));
        pane.add(lId);
        pane.add(tfId);
        pane.add(lbName);        
        pane.add(tfName);
        pane.add(lbCity);        
        pane.add(tfCity);        
        pane.add(lbAddress);
        pane.add(tfAddress);
        

        pane.setBackground(Color.WHITE);
        pane.setOpaque(false);
        pane.setBorder(BorderFactory.createTitledBorder("Data"));

        setLayout(new GridLayout(1, 2));
        add(pane);
        add(vendorImage);

        
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