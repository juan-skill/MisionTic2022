package main.view.viewproveedor;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import main.model.users.VendorModel;

/**
 * 
 */
public class VendorTableModel extends AbstractTableModel
{
    private List<VendorModel> data = new ArrayList<>();

    public VendorTableModel() {}

    public void updateModel(List<VendorModel> list)
    {
        this.data = list;
    }

    @Override
    public String getColumnName(int column)
    {
        switch (column)
        {
            case 0: return "Code";
            case 1: return "Name";
            case 2: return "City";
            case 3: return "Address";
            default: return "[no]";
        }
    }

    @Override
    public int getRowCount() 
    {        
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        VendorModel vendor = data.get(rowIndex);

        switch (columnIndex)
        {
            case 0: return vendor.getNumberID();
            case 1: return vendor.getName();
            case 2: return vendor.getCity();
            case 3: return vendor.getAddress();
            default: return "";
        }
    }

}