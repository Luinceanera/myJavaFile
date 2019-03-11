
public class administrator extends hospitalEmployee
{
    private String department;
    
    public administrator()
    {
        super();
        department = "";
    }
    
    public administrator(String theCategory, int theID, String theLastName, String theFirstName, String theDepartment)
    {
        super(theCategory, theID, theLastName, theFirstName);
        department = theDepartment;
    }
    
    public String getDepartment()
    {
        return department;
    }
    
    public void setDepartment(String theDepartment)
    {
        department = theDepartment;
    }
    
    @Override
    public String toString()
    {
        return (getCategory() + " " + getID() + " " + getLastName() + " " + getFirstName() + " " + getDepartment());
    }
    
}