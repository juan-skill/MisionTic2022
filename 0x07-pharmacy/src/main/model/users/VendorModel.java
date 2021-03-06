package main.model.users;

/**
 * Class that represents the user who will supply products 
 * to be distributed in the pharmacy.
 */
public class VendorModel extends ModelUser
{
    // -----------------------------------------------------------------
    // Atrributes
    // -----------------------------------------------------------------
 
    /**
     * Vendor user city.
     */    
    private String city = "";

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------    

    /**
     * Vendor user class constructor method
     * @param numberID
     * @param name
     * @param city
     * @param address
     */
    public VendorModel(Long numberID, String name, String city, String address)
    {
        super(numberID, name, address);
        this.city = city;
    }

    public VendorModel()
    {
        super(null, "", "");
        this.city = "";
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Return the city of the vendor user.
     * @return City of the vendor user.
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Set the city of the vendor user.
     * @param city to be updated.
     */
    public void setCity(String city)
    {
        this.city = city;
    }    

    /**
     * Return a String object representing a vendor instance
     */
    public String toString()
    {
        return numberID + "\t" + 
               name + "\t" +
               city + "\t" +
               address + "\n";
    }
}