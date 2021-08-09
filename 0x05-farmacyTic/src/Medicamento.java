public class Medicamento extends Producto
{
    private String concentration;

    /**
     * Medicamento - constructor of Medicamento class
     * @param concentration
     * @param name
     * @param code
     * @param price
     * @param brand
     */
    public Medicamento(String concentration, String name, Long code, Float price, String brand)
    {
        super(name, code, price, brand);
        this.concentration = concentration;
    }

    /**
     * toString - return a string that represents a String instance
     */
    @Override
    public String toString()
    {
        return "\tProducto Medicamento - codigo: " + code + 
               "\n\tnombre: " + name +
               "\n\tprecio: " + price +
               "\n\tmarca: " + brand +
               "\n\tconcentracion: " + concentration;
    }
}
