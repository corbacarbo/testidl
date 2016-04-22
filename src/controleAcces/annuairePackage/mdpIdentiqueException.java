package controleAcces.annuairePackage;

/**
 * Exception definition : mdpIdentiqueException
 * 
 * @author OpenORB Compiler
 */
public final class mdpIdentiqueException extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public mdpIdentiqueException()
    {
        super(mdpIdentiqueExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public mdpIdentiqueException(String message)
    {
        super(mdpIdentiqueExceptionHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public mdpIdentiqueException(String orb_reason, String message)
    {
        super(mdpIdentiqueExceptionHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
