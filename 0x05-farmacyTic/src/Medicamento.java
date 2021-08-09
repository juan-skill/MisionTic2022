public class Medicamento extends Producto
{
    private String concentration;

    public Medicamento(String concentration, String name, Long code, Float price, String brand)
    {
        super(name, code, price, brand);
        this.concentration = concentration;
    }
}