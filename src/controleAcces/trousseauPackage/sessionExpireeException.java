package controleAcces.trousseauPackage;

/**
 * Exception definition : sessionExpireeException
 * 
 * @author OpenORB Compiler
 */
public final class sessionExpireeException extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public sessionExpireeException()
    {
        super(sessionExpireeExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public sessionExpireeException(String message)
    {
        super(sessionExpireeExceptionHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public sessionExpireeException(String orb_reason, String message)
    {
        super(sessionExpireeExceptionHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
