package controleAcces.coffreFortPackage;

/**
 * Exception definition : matriculeErroneException
 * 
 * @author OpenORB Compiler
 */
public final class matriculeErroneException extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public matriculeErroneException()
    {
        super(matriculeErroneExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public matriculeErroneException(String message)
    {
        super(matriculeErroneExceptionHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public matriculeErroneException(String orb_reason, String message)
    {
        super(matriculeErroneExceptionHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
