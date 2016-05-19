package controleAcces.coffreFortPackage;

/**
 * Exception definition : matriculeInconnuException
 * 
 * @author OpenORB Compiler
 */
public final class matriculeInconnuException extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public matriculeInconnuException()
    {
        super(matriculeInconnuExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public matriculeInconnuException(String message)
    {
        super(matriculeInconnuExceptionHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public matriculeInconnuException(String orb_reason, String message)
    {
        super(matriculeInconnuExceptionHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
