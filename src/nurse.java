
public class nurse extends hospitalEmployee
{
    private int patients;
    
    public nurse()
    {
        super();
        patients = 0;
    }
    
    public nurse(String theCategory, int theID, String theLastName, String theFirstName, int thePatients)
    {
        super(theCategory, theID, theLastName, theFirstName);
        patients = thePatients;
    }
    
    public int getPatients()
    {
        return patients;
    }
    
    public void setPatients(int thePatients)
    {
        patients = thePatients;
    }
    
    @Override
    public String toString()
    {
        return (getCategory() + " " + getID() + " " + getLastName() + " " + getFirstName() + " " + getPatients());
    }
}