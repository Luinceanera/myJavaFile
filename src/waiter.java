
public class waiter extends cafeManager
{
    private int customers;
    
    public waiter()
    {
        super();
        customers = 0;
    }
    
    public waiter(String theCategory, int theID, String theLastName, String theFirstName, String theCafeType, int theCustomers)
    {
        super(theCategory, theID, theLastName, theFirstName, theCafeType);
        customers = theCustomers;
    }
    
    public int getCustomers()
    {
        return customers;
    }
    
    public void setCustomers(int theCustomers)
    {
        customers = theCustomers;
    }
    
    @Override
    public String toString()
    {
        return (getCategory() + " " + getID() + " " + getLastName() + " " + getFirstName() + " " + getCafeType() + " " + getCustomers());
    }
}