public class Medicamento extends Producto
{
    private String concentration;

    public Medicamento(String concentration, String name, Long code, Float price, String brand)
    {
        super(name, code, price, brand);
        this.concentration = concentration;
    }

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
