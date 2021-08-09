public class Alimentos extends Producto
{
    private String presentation;

    /**
     * Alimentos - Constructor of Alimentos class
     * @param presentation
     * @param name
     * @param code
     * @param price
     * @param brand
     */
    public Alimentos(String presentation, String name, Long code, Float price, String brand)
    {
        super(name, code, price, brand);
        this.presentation = presentation;
    }

    /**
     * toString - return a string that represents a String instance
     */
    @Override
    public String toString()
    {
        return "\tProducto Alimentos - codigo: " + code + 
               "\n\tnombre: " + name +
               "\n\tprecio: " + price +
               "\n\tmarca: " + brand +
               "\n\tpresentacion: " + presentation;
    }
}