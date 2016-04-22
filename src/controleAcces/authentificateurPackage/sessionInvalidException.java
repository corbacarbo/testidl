package controleAcces.authentificateurPackage;

/**
 * Exception definition : sessionInvalidException
 * 
 * @author OpenORB Compiler
 */
public final class sessionInvalidException extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public sessionInvalidException()
    {
        super(sessionInvalidExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public sessionInvalidException(String message)
    {
        super(sessionInvalidExceptionHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public sessionInvalidException(String orb_reason, String message)
    {
        super(sessionInvalidExceptionHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
