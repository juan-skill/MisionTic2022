package view.viewproveedor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;


public class PanelDatos extends JPanel
{
    private JLabel lId, lNombre, lCiudad, lDireccion;
    private JTextField tfId, tfNombre, tfCiudad, tfDireccion;    
        

    public PanelDatos()
    {
        initComponents();
    }

    public void initComponents()
    {
        // -----------------------------------------------
        // panel datos
        //ProveedorModel(int codigo, String nombre, String ciudad, String direccion)
        lId = new JLabel("Identificacion:");
        tfId = new JTextField(10);
        lNombre = new JLabel("Nombre:");
        tfNombre = new JTextField(10);
        lCiudad = new JLabel("Ciudad: ");
        tfCiudad = new JTextField(10);
        lDireccion = new JLabel("Direccion: ");
        tfDireccion = new JTextField(10);
                
            
        setLayout(new GridLayout(1, 9, 2, 2));
        add(lId);
        add(tfId);
        add(lNombre); 
        add(tfNombre);
        add(lCiudad);
        add(tfCiudad);
        add(lDireccion);
        add(tfDireccion);
    }

    public String getNombre()
    {
        return tfNombre.getText().trim();
    }
    
    public String getId()
    {
        return tfId.getText().trim();
    }

    public String getCiudad()
    {
        return tfCiudad.getText().trim();
    }

    public String getDireccion()
    {
        return tfDireccion.getText().trim();
    }
}