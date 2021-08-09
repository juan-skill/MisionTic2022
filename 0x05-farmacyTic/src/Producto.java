public class Producto
{
    protected String name;
    protected Long code;
    protected Float price;
    protected String brand;

    public Producto(String name, Long code, Float price, String brand)
    {
        this.name = name;
        this.code = code;
        this.price = price;
        this.brand = brand;
    }

}