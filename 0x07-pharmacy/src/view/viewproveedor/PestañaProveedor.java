package view.viewproveedor;

import java.awt.BorderLayout;


import javax.swing.JPanel;

/**
 * @author  Juan U
 */
public class PestañaProveedor extends JPanel
{
    private PanelDatos pDatos;
    private PanelBarras pBarras;
    private PanelBotones pBotones;

    /**
     * Constructor
     */
    public PestañaProveedor()
    {
        initComponents();
    }

    /**
     * InitComponents
     */
    public void initComponents()
    {
        //--------------------------------------------------
        pDatos = new PanelDatos();
        pBarras = new PanelBarras();
        pBotones = new PanelBotones();

        BorderLayout blayout = new BorderLayout();

        setLayout(blayout);
        //pDatos.setBackground(Color.BLUE);
        //pBarras.setBackground(Color.GREEN);
        //pBotones.setBackground(Color.RED);
        add(pDatos, BorderLayout.NORTH);
        add(pBarras, BorderLayout.CENTER);
        add(pBotones, BorderLayout.SOUTH);  
        
        
    }

    public PanelDatos getPanelDatos()
    {
        return pDatos;
    }

    public PanelBarras getPanelBarras()
    {
        return pBarras;
    }

    public PanelBotones getPanelBotones()
    {
        return pBotones;
    }
}