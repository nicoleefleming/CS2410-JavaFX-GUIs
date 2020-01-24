public class Faculty extends Employee {
    //office hours, rank
    public String officeHours;
    public String rank;

    //Make a Faculty member with specified everything
    public Faculty(String name, String address, String phone,
                   String email, int office, double salary,
                   String officeHours, String rank)
    {
        //pass in all the information for parents to parents
        super(name, address, phone, email, office, salary);

        //assign used things here
        this.officeHours = officeHours;
        this.rank = rank;
    }

    //Return Office Hours
    public String getOfficeHours()
    {
        return officeHours;
    }

    //Return Rank
    public String getRank()
    {
        return rank;
    }

    //Set office hours
    public void setOfficeHours(String officeHours)
    {
        this.officeHours = officeHours;
    }

    //Set rank
    public void setRank(String rank)
    {
        this.rank = rank;
    }

    //String of class
    public String toString()
    {
        return super.toString() + "\nOffice Hours: " + officeHours + "\nRank: " + rank;
    }
}

