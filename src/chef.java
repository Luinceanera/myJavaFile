
public class chef extends cafeManager
{
    private int foodsPrepared;
    
    public chef()
    {
        super();
        foodsPrepared = 0;
    }
    
    public chef(String theCategory, int theID, String theLastName, String theFirstName, String theCafeType, int theFoodsPrepared)
    {
        super(theCategory, theID, theLastName, theFirstName, theCafeType);
        foodsPrepared = theFoodsPrepared;
    }
    
    public int getFoodsPrepared()
    {
        return foodsPrepared;
    }
    
    public void setFoodsPrepared(int theFoodsPrepared)
    {
        foodsPrepared = theFoodsPrepared;
    }
    
    @Override
    public String toString()
    {
        return (getCategory() + " " + getID() + " " + getLastName() + " " + getFirstName() + " " + getCafeType() + " " + getFoodsPrepared());
    }
}