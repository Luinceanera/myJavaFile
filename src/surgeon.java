
public class surgeon extends doctor
{
    private char operating;
    
    public surgeon()
    {
        super();
        operating = '\u0000';
    }
    
    public surgeon(String theCategory, int theID, String theLastName, String theFirstName, String theSpecialty, char theOperating)
    {
        super(theCategory, theID, theLastName, theFirstName, theSpecialty);
        operating = theOperating;
    }
    
    public char getOperating()
    {
        return operating;
    }
    
    public void setOperating(char theOperating)
    {
        operating = theOperating;
    }
    
    @Override
    public String toString()
    {
        return (getCategory() + " " + getID() + " " + getLastName() + " " + getFirstName() + " " + getSpecialty() + " " + getOperating());
    }
}