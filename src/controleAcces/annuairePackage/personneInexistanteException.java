package controleAcces.annuairePackage;

/**
 * Exception definition : personneInexistanteException
 * 
 * @author OpenORB Compiler
 */
public final class personneInexistanteException extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public personneInexistanteException()
    {
        super(personneInexistanteExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public personneInexistanteException(String message)
    {
        super(personneInexistanteExceptionHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public personneInexistanteException(String orb_reason, String message)
    {
        super(personneInexistanteExceptionHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
