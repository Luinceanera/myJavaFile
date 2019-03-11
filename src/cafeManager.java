
public class cafeManager extends hospitalEmployee
{
    private String cafeType;
    
    public cafeManager()
    {
        super();
        cafeType = "";
    }
    
    public cafeManager(String theCategory, int theID, String theLastName, String theFirstName, String theCafeType)
    {
        super(theCategory, theID, theLastName, theFirstName);
        cafeType = theCafeType;
    }
    
    public String getCafeType()
    {
        return cafeType;
    }
    
    public void setCafeType(String theCafeType)
    {
        cafeType = theCafeType;
    }
    
    @Override
    public String toString()
    {
        return (getCategory() + " " + getID() + " " + getLastName() + " " + getFirstName() + " " + getCafeType());
    }
}