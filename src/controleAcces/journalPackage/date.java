package controleAcces.journalPackage;

/**
 * Struct definition : date
 * 
 * @author OpenORB Compiler
*/
public final class date implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member timestamp
     */
    public int timestamp;

    /**
     * Default constructor
     */
    public date()
    { }

    /**
     * Constructor with fields initialization
     * @param timestamp timestamp struct member
     */
    public date(int timestamp)
    {
        this.timestamp = timestamp;
    }

}
