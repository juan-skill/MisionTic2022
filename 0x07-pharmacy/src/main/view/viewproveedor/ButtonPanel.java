package main.view.viewproveedor;

import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;


/**
 * Class that represents the buttons panel to operate CRUD
 */
public class ButtonPanel extends JPanel
{
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Constant to locate list image.
     */
    private static final String iconPathbtnlist = "../../images/btnlist.png";

    /**
     * Constant to locate delete image.
     */
    private static final String iconPathbtndelete = "../../images/btndelete.png";

    /**
     * Constant to locate delete image.
     */
    private static final String iconPathbtnupdate = "../../images/btnupdate.png";
    
    /**
     * Constant to locate delete image.
     */
    private static final String iconPathbtninsert = "../../images/btninsert.png";    

    // -----------------------------------------------------------------
    // Atrributes
    // -----------------------------------------------------------------

    /**
     * Button to list the info into the table.
     */
    private JButton btnList;
    
    /**
     * Button to delete a record.
     */    
    private JButton btnDelete;

    /**
     * Update to delete a record.
     */    
    private JButton btnUpdate;

    /**
     * Update to confirm a change of a record.
     */    
    private JButton btnOK;

    /**
     * Update to insert a record.
     */    
    private JButton btnInsert;

    /**
     * textfield to write a search.
     */
    private JTextField tfSearch;
    
    /**
     * Image to list.
     */
    private Image imgBtnList;

    /**
     * Icon to list.
     */    
    private Icon iconBtnList;

    /**
     * Image to updata.
     */    
    private Image imgBtnUpdate;

    /**
     * Icon to  update.
     */    
    private Icon iconBtnUpdate;

    /**
     * Image to delete.
     */    
    private Image imgBtnDelete;

    /**
     * Icon to  delete.
     */    
    private Icon iconBtnDelete;    

    /**
     * Image to insert.
     */    
    private Image imgBtnInsert;

    /**
     * Icon to insert.
     */    
    private Icon iconBtnInsert;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * ButtonPanel class constructor method
     */
    public ButtonPanel()
    {
        initComponents();
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------    

    /**
     * Prepare the layout of the button slots.
     */    
    public void initComponents()
    {
        imgBtnList = new ImageIcon(getClass().getResource(iconPathbtnlist)).getImage();
        iconBtnList = new ImageIcon(imgBtnList.getScaledInstance(30, 30,  Image.SCALE_SMOOTH));        
        btnList = new JButton("LIST", iconBtnList);
        btnList.setVerticalTextPosition(JLabel.BOTTOM);
        btnList.setHorizontalAlignment(JLabel.CENTER);

        imgBtnDelete = new ImageIcon(getClass().getResource(iconPathbtndelete)).getImage();
        iconBtnDelete = new ImageIcon(imgBtnDelete.getScaledInstance(30, 30,  Image.SCALE_SMOOTH));
        btnDelete = new JButton("DELETE", iconBtnDelete);
        btnDelete.setVerticalTextPosition(JLabel.BOTTOM);
        btnDelete.setHorizontalAlignment(JLabel.CENTER);

        imgBtnUpdate = new ImageIcon(getClass().getResource(iconPathbtnupdate)).getImage();
        iconBtnUpdate = new ImageIcon(imgBtnUpdate.getScaledInstance(30, 30,  Image.SCALE_SMOOTH));
        btnUpdate = new JButton("UPDATE", iconBtnUpdate);
        btnUpdate.setVerticalTextPosition(JLabel.BOTTOM);
        btnUpdate.setHorizontalAlignment(JLabel.CENTER);
        
        imgBtnInsert = new ImageIcon(getClass().getResource(iconPathbtninsert)).getImage();
        iconBtnInsert = new ImageIcon(imgBtnInsert.getScaledInstance(30, 30,  Image.SCALE_SMOOTH));        
        btnInsert = new JButton("INSERT", iconBtnInsert);
        btnInsert.setVerticalTextPosition(JLabel.BOTTOM);
        btnInsert.setHorizontalAlignment(JLabel.CENTER);

        btnOK = new JButton("OK");
        btnOK.setEnabled(false);

        tfSearch = new JTextField(10);

        setLayout(new GridLayout(1,3,2,2));                
        add(btnDelete); 
        add(btnUpdate);
        add(btnOK);
        add(btnList);
        add(btnInsert);        
        add(tfSearch);
    }

    /**
     * Return btnDelete button.
     * @return btnDelete.
     */
    public JButton getBtnDelete() {
        return btnDelete;
    }

    /**
     * Return btnUpte button.
     * @return btnUpdate.
     */
    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    /**
     * Return btnList button.
     * @return btnList.
     */
    public JButton getBtnList() {
        return btnList;
    }

    /**
     * Return btnInsert button.
     * @return btnInsert.
     */
    public JButton getBtnInsert() {
        return btnInsert;
    }

    /**
     * Return btnOK button.
     * @return btnOk.
     */
    public JButton getBtnOK() {
        return btnOK;
    }

    
    /**
     * Return tfSearch button.
     * @return tfSearch.
     */
    public JTextField getTfSearch() {
        return tfSearch;
    }

    /**
     * Ask for a question to confirme deleting a record.
     * @param message Message into MessageDialog.
     */
    public int confirmeDelete(String message)
    {
        return JOptionPane.showConfirmDialog(null, message);
    }

    /**
     * Disable buttons.
     * @param value boolean value to change status.
     */
    public void disableButton(Boolean value)
    {
        btnOK.setEnabled(value);
        btnUpdate.setEnabled(value);
        btnDelete.setEnabled(value);
        btnInsert.setEnabled(value);
        btnList.setEnabled(value);
    }

    /**
     * The listener interface for receiving action events each of the buttons.
     * @param evento to assigns it.
     */
    public void assingListenToBtn(ActionListener evento)
    {
        btnUpdate.addActionListener(evento);
        btnList.addActionListener(evento);
        btnDelete.addActionListener(evento);        
        btnInsert.addActionListener(evento);
        btnOK.addActionListener(evento);
    }

    /**
     * The listener interface for receiving action events of the textfield component.
     * @param event  which indicates that a keystroke occurred in the TextFiel.
     */
    public void assingListenToTField(KeyListener event)
    {
        tfSearch.addKeyListener(event);
    }    

}