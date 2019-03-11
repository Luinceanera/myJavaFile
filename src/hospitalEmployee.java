
public class hospitalEmployee extends basic
{
    private int ID;
    private String lastName;
    private String firstName;
    
    public hospitalEmployee()
    {
        super();
        ID = -1;
        lastName = "";
        firstName = "";
    }
    
    public hospitalEmployee(String theCategory, int theID, String theLastName, String theFirstName)
    {
        super(theCategory);
        ID = theID;
        lastName = theLastName;
        firstName = theFirstName;
    }
    
    public int getID()
    {
        return ID;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setID(int theID)
    {
        ID = theID;
    }
    
    public void setLastName(String theLastName)
    {
        lastName = theLastName;
    }
    
    public void setFirstName(String theFirstName)
    {
        firstName = theFirstName;
    }
    
    @Override
    public String toString()
    {
        return (getCategory() + " " + getID() + " " + getLastName() + " " + getFirstName());
    }
    
}