import java.lang.String;


public class Employee extends Person
{
    //Data objects in Employee
    private double salary;
    private MyDate dateHired;
    private int office;

    //Makes an Employee obj.
    public Employee(String name, String address, String phone, String email, int office, double salary)
    {
        //super calls to create a Person
        super(name, address, phone, email);

        //this is a pointer to the local var in this code,
        // the other var is the passed var
        this.salary = salary;
        this.dateHired = new MyDate();
        this.office = office;
    }

    //Returns office
    public int getOffice()
    {
        return office;
    }

    //Returns salary
    public String getSalary()
    {
        return String.format("%.2f", salary);
    }

    //Returns date hired
    public String getDateHired()
    {
        return dateHired.getMonth() + "/" + dateHired.getDay() + "/" + dateHired.getYear();
    }

    //Sets new office
    public void setOffice(int office)
    {
        this.office = office;
    }

    //Sets new salary
    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    //Sets new date hired
    public void setDateHired()
    {
        dateHired = new MyDate();
    }

    //Return a string version of this class.
    public String toString()
    {
        return super.toString() + "\nOffice: " + getOffice() + "\nSalary: $"
                + getSalary() + "\nDate Hired: " + getDateHired();
    }

}
