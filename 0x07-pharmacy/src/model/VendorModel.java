package model;

/**
 * Class that represents the user who will supply products 
 * to be distributed in the pharmacy.
 */
public class VendorModel
{
    // -----------------------------------------------------------------
    // Atrributes
    // -----------------------------------------------------------------

    /**
     * Vendor user identification code.
     */
    private Long numberID = null;
    
    /**
     * Vendor user name.
     */    
    private String name = "";
    
    /**
     * Vendor user city.
     */    
    private String city = "";

    /**
     * Vendor user address.
     */
    private String address = "";

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
        this.numberID = numberID;
        this.name = name;
        this.city = city;
        this.address = address;
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Return the identification code of the Vendor user.
     * @return NumberID of the vendor user.
     */
    public Long getNumberID()
    {
        return numberID;
    }

    /**
     * Return the name of the vendor user.
     * @return Name of the vendor user.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the city of the vendor user.
     * @return City of the vendor user.
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Return the address of the vendor user.
     * @return Address of the vendor user.
     */
    public String getAddress()
    {
        return address;
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