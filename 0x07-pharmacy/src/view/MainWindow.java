/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import view.viewproveedor.VendorTab;

import controller.ClickEvent;

/**
 *
 * @author casierrav
 */
public class MainWindow extends JFrame {
    
    private JTabbedPane pestañas;
    private VendorTab pProveedor;

    public MainWindow(){
        initComponents();
    }
    
    private void initComponents(){
        setTitle("Pharmacy - MVC");
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        this.pProveedor = new VendorTab();
        /*PanelT2 panelT2 = new PanelT2();
        PanelT3 panelT3 = new PanelT3();
        */
        pestañas = new JTabbedPane();

        pestañas.add(pProveedor, "Proveedor");
        /*pestañas.add(panelT2, "pestaña2");
        pestañas.add(panelT3, "pestaña3");
        */

        // add to JFrame
        add(pestañas);

        new ClickEvent(pProveedor);

        //ResultsPanel resultsPanel = new ResultsPanel();
        //setContentPane(resultsPanel);
        //add(new ControlsPanel(resultsPanel));
        
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
     * retornar el panel de la pestaña Proveedor
     * @return
     */
    public VendorTab getVendorTab()
    {
        return pProveedor;
    }
}