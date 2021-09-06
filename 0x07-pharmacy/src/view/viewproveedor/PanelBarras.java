package view.viewproveedor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

import model.VendorModel;

import java.util.List;

public class PanelBarras extends JPanel
{
    private JTextArea area;
    private JScrollPane barras;

    public PanelBarras()
    {
        initComponents();
    }

    public void initComponents()
    {
        // -----------------------------------------------
        // panel mitad
        area = new JTextArea(20, 10);
        barras = new JScrollPane(area);

        BorderLayout blayout = new BorderLayout();
        setLayout(blayout);
        add(barras, BorderLayout.CENTER);

        
    }

        /**
     * método que muestra lo de una lista en el area de texto
     * @param lista
     * @param titulo 
     */
    public void mostrarDatos(List<VendorModel> lista, String titulo)
    {
        area.setText(titulo);
        for(Object registro: lista)
        {
            area.append(registro.toString());
        }        
    }
    
    public void mostarArea(String datoAMostar)
    {
        area.setText(datoAMostar);
    }

}