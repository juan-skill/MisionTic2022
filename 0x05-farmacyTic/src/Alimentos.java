public class Alimentos extends Producto
{
    private String presentation;

    public Alimentos(String presentation, String name, Long code, Float price, String brand)
    {
        super(name, code, price, brand);
        this.presentation = presentation;
        
    }
}