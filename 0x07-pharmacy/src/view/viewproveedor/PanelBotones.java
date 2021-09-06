package view.viewproveedor;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;


public class PanelBotones extends JPanel
{
    private JButton bMostrar;
    private JButton bBorrar;
    private JButton bModificar;

    public PanelBotones()
    {
        initComponents();
    }

    public void initComponents()
    {
        // -----------------------------------------------
        // panel botones
        bMostrar = new JButton("Mostrar Registros");
        bBorrar = new JButton("Borrar");
        bModificar = new JButton("Modificar");        

        setLayout(new GridLayout(1,3,2,2));                
        add(bBorrar); 
        add(bModificar);
        add(bMostrar);
    }

    /**
     * 
     * @return
     */
    public JButton getbBorrar() {
        return bBorrar;
    }

    public JButton getbModificar() {
        return bModificar;
    }

    public JButton getbMostrar() {
        return bMostrar;
    }

    public void asignarEscuchas(ActionListener evento)
    {
        bModificar.addActionListener(evento);
        bMostrar.addActionListener(evento);
        bBorrar.addActionListener(evento);        
    }

}