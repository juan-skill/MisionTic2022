package main.access.DAOException;

/**
 * Class representing DAOException to handle exception generated in the DAO's.
 */
public class DAOException extends Exception
{
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------    
   
    /**
     * DAOException class constructor method
     * @param message Message to display cause.
     */
    public DAOException(String message)
    {
        super(message);
    }

    /**
     * DAOException class constructor method.
     * @param message Message to display cause.
     * @param cause Info about the error.
     */
    public DAOException(String message, Throwable cause)
    {
        super(message, cause);
    }

    
    /**
     * DAOException class constructor method.
     * @param cause Info about the error.
     */
    public DAOException(Throwable cause)
    {
        super(cause);
    }

}