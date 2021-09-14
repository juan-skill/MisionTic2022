package main.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
//import main.access.VendorDAO;
import main.access.DAOException.DAOException;
import main.access.concretDAO.ManagerDAO;
import main.view.viewproveedor.VendorTab;
import main.controller.VendorController;
import main.utils.ConnectionDB;

/**
 * Class that represents the main window Frame
 */
public class MainWindow extends JFrame
{
    // -----------------------------------------------------------------
    // Atrributes
    // -----------------------------------------------------------------

    /**
     * Main container of the tabs.
     */
    private JTabbedPane tabs;

    /**
     * VendorTab panel.
     */    
    private VendorTab vendorTab;

    /**
     * ContanerPanel of Frame.
     */    
    private Container containerFrame;

    /**
     * Label to display Window title.
     */
    private JLabel jTitle;   

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * MainWindow class constructor method
     */
    public MainWindow() throws DAOException
    {
        initComponents();
        startApplication();
    }
    
    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------    

    /**
     * Sets main Frame.
     */    
    private void initComponents(){
        setTitle("Pharmacy - MVC");
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        containerFrame = getContentPane();

        jTitle = new JLabel("DrogeriaTic", JLabel.CENTER);
        jTitle.setFont(new Font("TimesRoman", Font.BOLD+Font.ITALIC, 25));
        jTitle.setOpaque(true);
        jTitle.setBackground(Color.WHITE);
        jTitle.setForeground(Color.BLUE);
        
        this.vendorTab = new VendorTab();
        tabs = new JTabbedPane();
        tabs.add(vendorTab, "Vendor");
        
        containerFrame.setLayout(new BorderLayout());
        containerFrame.add(jTitle, BorderLayout.NORTH);
        containerFrame.add(tabs, BorderLayout.CENTER);
       
        setSize(1080, 600);
        //pack();
        setResizable(false);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = getSize();
        setLocation((screenSize.width  - frameSize.width)  / 2, 
                    (screenSize.height - frameSize.height) / 2);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Create instances of controller
     */
    private void startApplication() throws DAOException
    {
        //new VendorController(this, new VendorDAO());
        ManagerDAO managerDAO = new ManagerDAO(ConnectionDB.getConnection());
        new VendorController(this, managerDAO);
    }

    /**
     * Return vendor Tab 
     * @return tab panel 1.
     */
    public VendorTab getVendorTab()
    {
        return vendorTab;
    }
}