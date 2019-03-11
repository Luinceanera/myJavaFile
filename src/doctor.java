
public class doctor extends hospitalEmployee
{
    private String specialty;
    
    public doctor()
    {
        super();
        specialty = "";
    }

    public doctor(String theCategory, int theID, String theLastName, String theFirstName, String theSpecialty)
    {
        super(theCategory, theID, theLastName, theFirstName);
        specialty = theSpecialty;
    }

    public String getSpecialty()
    {
        return specialty;
    }

    public void setSpecialty(String theSpecialty)
    {
        specialty = theSpecialty;
    }

    @Override
    public String toString()
    {
        return (getCategory() + " " + getID() + " " + getLastName() + " " + getFirstName() + " " + getSpecialty());
    }

}