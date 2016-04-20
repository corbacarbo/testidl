package controleAcces.autorisateurPackage;

/**
 * Exception definition : autorisationRefuseeException
 * 
 * @author OpenORB Compiler
 */
public final class autorisationRefuseeException extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Exception member heure
     */
    public String heure;

    /**
     * Default constructor
     */
    public autorisationRefuseeException()
    {
        super(autorisationRefuseeExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     * @param heure heure exception member
     */
    public autorisationRefuseeException(String message, String heure)
    {
        super(autorisationRefuseeExceptionHelper.id());
        this.message = message;
        this.heure = heure;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     * @param heure heure exception member
     */
    public autorisationRefuseeException(String orb_reason, String message, String heure)
    {
        super(autorisationRefuseeExceptionHelper.id() +" " +  orb_reason);
        this.message = message;
        this.heure = heure;
    }

}