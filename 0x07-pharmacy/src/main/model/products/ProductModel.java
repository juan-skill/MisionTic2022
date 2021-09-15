package main.model.products;

/**
 * Class that represents an abstraction of a product
 */
public class ProductModel
{
    // -----------------------------------------------------------------
    // Atrributes
    // -----------------------------------------------------------------

    /**
     * Product identification code.
     */
    protected Long productId = null;

    /**
     * Name of the product.
     */
    protected String name;
    
    /**
     * Price of the product.
     */
    protected Float price;

    /**
     * Type of the product.
     */
    protected String type;

    /**
     * Brand of the product.
     */
    protected String brand;

    /**
     * Vendor Identificatin code.
     */
    protected Long vendorId = null;

    /**
     * Consentration of medicine.
     */    
    private String observation;


    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
    
    /**
     * Client user class constructor method
     * @param productId
     * @param name
     * @param price
     * @param brand
     * @param type
     * @param observation
     * @param vendorId
     */
    public ProductModel(Long productId, String name, Float price, String brand, String type, String observation, Long vendorId)
    {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.type = type;
        this.observation = observation;
        this.vendorId = vendorId;
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------    

   /**
     * Return code of the product.
     * @return ProductId of the user.
     */
    public Long getProductId()
    {
        return productId;
    }

    /**
     * Set the productId of the product.
     * @param productID to set.
     */
    public void setProductId(Long numberID)
    {
        this.productId = numberID;
    }

    /**
     * Return the name of the product.
     * @return Name of the product.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the name attribute
     * @param name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Return the price of the product.
     * @return Price of the product.
     */
    public Float getPrice()
    {
        return price;
    }

    /**
     * Set the price attribute
     * @param price to set
     */
    public void setPrice(Float price)
    {
        this.price = price;
    }

    /**
     * Return the brand of the product.
     * @return Brand of the product.
     */
    public String getBrand()
    {
        return brand;
    }

    /**
     * Set the brand attribute
     * @param brand to set
     */
    public void setBrand(String brand)
    {
        this.brand = brand;
    }

   /**
     * Return identification code of vendor.
     * @return VendorId of the user.
     */
    public Long getVendorId()
    {
        return vendorId;
    }

    /**
     * Set the vendorId of the vendor.
     * @param vendorId to set.
     */
    public void setVendorId(Long vendorId)
    {
        this.productId = vendorId;
    } 

    /**
     * Return the observation of medicine product.
     * @return Contentration of medicine product
     */
    public String getObservation()
    {
        return observation;
    }
    
    /**
     * Sets the observation attribute.
     * @param type attribute of a product.
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Return the type of product.
     * @return Type of  product.
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * Sets the observation attribute.
     * @param observation attribute of a product.
     */
    public void setObservation(String observation)
    {
        this.observation = observation;
    }    

    /**
     * Return a String object representing a client instance
     */
    public String toString()
    {
        return String.format("%d\t%s\t%.2f\t%s\t%s\t%s%d", productId, name, price, brand,
                                                           type, observation,vendorId);
    }
}