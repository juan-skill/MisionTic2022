package main.model.users;

/**
 * Class that represents the user who will supply products 
 * to be distributed in the pharmacy.
 */
public class ClientModel extends ModelUser
{
    // -----------------------------------------------------------------
    // Atrributes
    // -----------------------------------------------------------------
 
    /**
     * Client user phoneNumber.
     */    
    private String phoneNumber = "";

    /**
     * Client user neighborhood.
     */    
    private String neighborhood = "";    

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------    

    /**
     * Client user class constructor method
     * @param numberID
     * @param name
     * @param address
     * @param phoneNumber
     * @param neighborhood
     */
    public ClientModel(Long numberID, String name, String address, String phoneNumber, String neighborhood)
    {
        super(numberID, name, address);
        this.phoneNumber = phoneNumber;
        this.neighborhood = neighborhood;
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    
    /**
     * Return the phone number of the client user.
     * @return Phone number of the client user.
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    /**
     * Set the phone number of the client user.
     * @param Phone number to be updated.
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Return the neighborhood of the client user.
     * @return Neighborhood of the client user.
     */
    public String getNeighborhood()
    {
        return neighborhood;
    }

    /**
     * Return a String object representing a client instance
     */
    public String toString()
    {
        return numberID + "\t" + 
               name + "\t" +
               address + "\t" +
               phoneNumber + "\t" +
               neighborhood + "\n";
    }
}