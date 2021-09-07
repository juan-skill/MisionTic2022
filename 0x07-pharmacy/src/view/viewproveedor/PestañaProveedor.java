package view.viewproveedor;

import java.awt.BorderLayout;
import javax.swing.JPanel;


/**
 * @author  Juan U
 */
public class PestañaProveedor extends JPanel
{
    private DataPanel pDatos;
    private BarPanel pBarras;
    private ButtonPanel pBotones;

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
        pDatos = new DataPanel();
        pBarras = new BarPanel();
        pBotones = new ButtonPanel();

        BorderLayout blayout = new BorderLayout();

        setLayout(blayout);
        //pDatos.setBackground(Color.BLUE);
        //pBarras.setBackground(Color.GREEN);
        //pBotones.setBackground(Color.RED);
        add(pDatos, BorderLayout.NORTH);
        add(pBarras, BorderLayout.CENTER);
        add(pBotones, BorderLayout.SOUTH);  
        
        
    }

    public DataPanel getDataPanel()
    {
        return pDatos;
    }

    public BarPanel getPanelBarras()
    {
        return pBarras;
    }

    public ButtonPanel getPanelBotones()
    {
        return pBotones;
    }
}