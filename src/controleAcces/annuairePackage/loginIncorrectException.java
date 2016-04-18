package controleAcces.annuairePackage;

/**
 * Exception definition : loginIncorrectException
 * 
 * @author OpenORB Compiler
 */
public final class loginIncorrectException extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public loginIncorrectException()
    {
        super(loginIncorrectExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public loginIncorrectException(String message)
    {
        super(loginIncorrectExceptionHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public loginIncorrectException(String orb_reason, String message)
    {
        super(loginIncorrectExceptionHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
