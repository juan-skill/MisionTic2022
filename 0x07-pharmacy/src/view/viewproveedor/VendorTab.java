package view.viewproveedor;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * Class that represents the tab contenten pane number 1 (Vendor Tab)
 */
public class VendorTab extends JPanel
{
    // -----------------------------------------------------------------
    // Atrributes
    // -----------------------------------------------------------------

    /**
     * Panel that represents panel of datos written by user.
     */
    private DataPanel dataPanel;
    
    /**
     * Panel that represents panel to display info of the database.
     */
    private BarPanel scrollPaneP;

    /**
     * Panel that represents panel to click a button according an action.
     */    
    private ButtonPanel buttonPanel;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * DataPanel class constructor method
     */
    public VendorTab()
    {
        initComponents();
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------    
    
    /**
     * Set layout main panels
     */
    public void initComponents()
    {
        dataPanel = new DataPanel();
        scrollPaneP = new BarPanel();
        buttonPanel = new ButtonPanel();

        BorderLayout blayout = new BorderLayout();

        setLayout(blayout);
        //pDatos.setBackground(Color.BLUE);
        //scrollPaneP.setBackground(Color.GREEN);
        //buttonPanel.setBackground(Color.RED);
        add(dataPanel, BorderLayout.NORTH);
        add(scrollPaneP, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Return panel to write data of the vendor user.
     * @return dataPanel panel of DataPanel.
     */
    public DataPanel getDataPanel()
    {
        return dataPanel;
    }

    /**
     * Return panel to show table
     * @return scrollpaneP of BarPanel
     */
    public BarPanel getPanelBarras()
    {
        return scrollPaneP;
    }

    /**
     * Return panel to put buttons
     * @return buttonPanel of ButtonPanel
     */
    public ButtonPanel getPanelBotones()
    {
        return buttonPanel;
    }
}