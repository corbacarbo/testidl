package controleAcces.autorisateurPackage;

/**
 * Exception definition : conflitAutorisationException
 * 
 * @author OpenORB Compiler
 */
public final class conflitAutorisationException extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public conflitAutorisationException()
    {
        super(conflitAutorisationExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public conflitAutorisationException(String message)
    {
        super(conflitAutorisationExceptionHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public conflitAutorisationException(String orb_reason, String message)
    {
        super(conflitAutorisationExceptionHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
