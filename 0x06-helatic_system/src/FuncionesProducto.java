import java.util.ArrayList;


public class FuncionesProducto
{
    /**
     * FuncionesProducto - constructor function
     */
    public FuncionesProducto()
    {}

    /**
     * obtenerProductos - generates a list of names without duplicates
     * 
     * @param list to check the duplicates numbers
     * @return
     */
    public ArrayList<String> obtenerProductos(ArrayList<String> list)
    {
        ArrayList<String> notduplicates = new ArrayList<String>();
        
        for (String element : list)
        {
            if (!notduplicates.contains(element.toLowerCase()))
            {
                notduplicates.add(element);
            }
        }
        
        return notduplicates;
    }

    /**
     * obtenerPosicionesProductosFaltantes - generates a list with the products' indexes missing
     * 
     * @param IPos - que contiene las posiciones de los productos que faltan
     * @param tipos - contiene los nombres de los productos faltantes
     * @param cat -  el nombre de un producto
     * @return
     */
    public ArrayList<Integer> obtenerPosicionesProductosFaltantes(ArrayList<Integer> IPos, ArrayList<String> tipos, String cat)
    {
        ArrayList<Integer> missingItems = new ArrayList<>();

        for (Integer element_index : IPos)
        {
            if (tipos.get(element_index).equalsIgnoreCase(cat))
            {
                missingItems.add(element_index);
            }    
        }

        return missingItems;
    }

    /**
     * obtenerFaltantes - returns a list with the products that HelaTic is interested
     * 
     * @param lOtro - productos que vende otra heladería llamada lOtro
     * @param lHelaTic - productos que vende HelaTic actualmente llamada lHelaTic
     * @return - lista de productos que les interesa de la otra heladería, 
     *           es decir aquellos productos que vende la otra heladería y no vende HelaTic.
     */
    public ArrayList<String> obtenerFaltantes(ArrayList<String> lOtro, ArrayList<String> lHelaTic)
    {
        ArrayList<String> lOtroMissing = new ArrayList<>();

        for (String element : lOtro)
        {
            if (!lHelaTic.contains(element))
            {
                lOtroMissing.add(element);
            }    
        }

        return lOtroMissing;
    }

    /**
     * obtenerProductosIntercambiables - finds the missing products entered in both list, return an exchange number each other
     * 
     * @param lOtro - list to compare
     * @param lHelaTic -list to compare
     * @return - the minimum number of comparations
     */
    public Integer obtenerProductosIntercambiables(ArrayList<String> lOtro, ArrayList<String> lHelaTic)
    {
        ArrayList<String> other = new ArrayList<>();

        for (String element : lOtro)
        {
            if (lHelaTic.contains(element))
            {
                System.out.println(element);
                other.add(element);
            }
        }

        for (String element : lHelaTic)
        {
            if (!other.contains(element))
            {
                System.out.println(element);
                other.add(element);
            }
        }

        if (other.size() % 2 == 0)
        {
            return other.size() / 2;    
        }

        return (other.size() - 1) / 2;
    }

}