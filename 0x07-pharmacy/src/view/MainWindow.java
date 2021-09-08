package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;

import access.VendorDAO;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import view.viewproveedor.VendorTab;
import controller.VendorController;

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

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * MainWindow class constructor method
     */
    public MainWindow()
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
        
        this.vendorTab = new VendorTab();
        tabs = new JTabbedPane();
        tabs.add(vendorTab, "Proveedor");

        
        containerFrame.add(tabs);
        
        //setSize(1024, 720);
        pack();
        
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
    private void startApplication()
    {
        new VendorController(this, new VendorDAO());
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