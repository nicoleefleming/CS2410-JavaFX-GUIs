public class Staff extends Employee
{
    //Staff Data obj
    private String title;

    //Make a new Staff obj
    public Staff(String name, String address, String phone,
                 String email, int office, double salary, String title)
    {
        //Parent items
        super(name, address, phone, email, office, salary);

        //Staff items
        this.title = title;
    }

    //Return title
    public String getTitle()
    {
        return title;
    }

    //Set title
    public void setTitle(String title)
    {
        this.title = title;
    }

    //Class to string
    public String toString()
    {
        return super.toString() + "\nTitle: " + title;
    }
}
