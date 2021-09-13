package main.model.users;

/**
 * Class that represents an users abstraction of the application
 */
public abstract class ModelUser
{
    // -----------------------------------------------------------------
    // Atrributes
    // -----------------------------------------------------------------

    /**
     * User identification code.
     */
    protected Long numberID = null;
    
    /**
     * User name.
     */    
    protected String name = "";
    
    /**
     * User address.
     */
    protected String address = "";

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------    

    /**
     * Vendor userModel class constructor method
     * @param numberID
     * @param name
     * @param address
     */
    public ModelUser(Long numberID, String name, String address)
    {
        this.numberID = numberID;
        this.name = name;
        this.address = address;
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Return the identification code of the user.
     * @return NumberID of the user.
     */
    public Long getNumberID()
    {
        return numberID;
    }

    /**
     * Set the numberID attribute
     * @param numberID to set
     */
    public void setNumberID(Long numberID)
    {
        this.numberID = numberID;
    }

    /**
     * Return the name of the user.
     * @return Name of the user.
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
     * Return the address of the user.
     * @return Address of the user.
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Set the address attribute
     * @param address to set
     */
    public void setAddress(String address)
    {
        this.address = address;
    }    

    /**
     * Return a String object representing a user instance
     */
    public String toString()
    {
        return numberID + "\t" + 
               name + "\t" +
               address + "\n";
    }
}