public class Alimentos extends Producto
{
    private String presentation;

    public Alimentos(String presentation, String name, Long code, Float price, String brand)
    {
        super(name, code, price, brand);
        this.presentation = presentation;
    }

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