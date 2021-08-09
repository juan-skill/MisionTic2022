public class Producto
{
    protected String name;
    protected Long code;
    protected Float price;
    protected String brand;

    /**
     * Product - constructor of Producto class
     * @param name
     * @param code
     * @param price
     * @param brand
     */
    public Producto(String name, Long code, Float price, String brand)
    {
        this.name = name;
        this.code = code;
        this.price = price;
        this.brand = brand;
    }

}