
public class receptionist extends administrator
{
    private char answering;
    
    public receptionist()
    {
        super();
        answering = '\u0000';
    }
    
    public receptionist(String theCategory, int theID, String theLastName, String theFirstName, String theDepartment, char theAnswering)
    {
        super(theCategory, theID, theLastName, theFirstName, theDepartment);
        answering = theAnswering;
    }
    
    public char getAnswering()
    {
        return answering;
    }
    
    public void setAnswering(char theAnswering)
    {
        answering = theAnswering;
    }
    
    @Override
    public String toString()
    {
        return (getCategory() + " " + getID() + " " + getLastName() + " " + getFirstName() + " " + getDepartment() + " " + getAnswering());
    }
}