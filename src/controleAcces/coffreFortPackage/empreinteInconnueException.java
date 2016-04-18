package controleAcces.coffreFortPackage;

/**
 * Exception definition : empreinteInconnueException
 * 
 * @author OpenORB Compiler
 */
public final class empreinteInconnueException extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public empreinteInconnueException()
    {
        super(empreinteInconnueExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public empreinteInconnueException(String message)
    {
        super(empreinteInconnueExceptionHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public empreinteInconnueException(String orb_reason, String message)
    {
        super(empreinteInconnueExceptionHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
