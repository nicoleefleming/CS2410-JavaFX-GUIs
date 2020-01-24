public class Student extends Person
{
    private int status;
    public final static int Freshman = 1;
    public final static int Sophmore = 2;
    public final static int Junior = 3;
    public final static int Senior = 4;

    //Construct a Student obj
    public Student(String name, String address, String phone,
                   String email, int status)
    {
        //The parent obj's
        super(name, address, phone, email);

        //Student's obj
        this.status = status;
    }

    //Set new status
    public void setStatus(int status)
    {
        this.status = status;
    }

    //Return status
    public String getStatus()
    {
        switch(status)
        {
            case 1: return "Freshman!";
            case 2: return "Sophmore.";
            case 3: return "Junior";
            case 4: return "Senior?";
            default: return "Unknown";
        }
    }

    //Class to string
    public String toString()
    {
        return super.toString() + "\nStatus: " + getStatus();
    }
}
