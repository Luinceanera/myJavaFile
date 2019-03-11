
public class janitor extends administrator
{
    private char sweeping;
    
    public janitor()
    {
        super();
        sweeping = '\u0000';
    }
    
    public janitor(String theCategory, int theID, String theLastName, String theFirstName, String theDepartment, char theSweeping)
    {
        super(theCategory, theID, theLastName, theFirstName, theDepartment);
        sweeping = theSweeping;
    }
    
    public char getSweeping()
    {
        return sweeping;
    }
    
    public void setSweeping(char theSweeping)
    {
        sweeping = theSweeping;
    }
    
    @Override
    public String toString()
    {
        return (getCategory() + " " + getID() + " " + getLastName() + " " + getFirstName() + " " + getDepartment() + " " + getSweeping());
    }
}