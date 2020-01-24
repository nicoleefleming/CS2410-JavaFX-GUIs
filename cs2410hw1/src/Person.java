public class Person
{
    //Data in a Person obj
    private String name;
    private String address;
    private String phone;
    private String email;

    //Default Person obj
    public Person()
    {
        name = "unknown";
        address = "Somewhere in Creation";
        phone = "Blocked";
        email = "Do Not Reply";
    }

    //Person obj with specific data
    public Person(String name, String address, String phone, String email)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    //Return name
    public String getName()
    {
        return name;
    }

    //Return address
    public String getAddress()
    {
        return address;
    }

    //Return phone
    public String getPhone()
    {
        return phone;
    }

    //Return email
    public String getEmail()
    {
        return email;
    }

    //Set name
    public void setName(String name)
    {
        this.name = name;
    }

    //Set address
    public void setAddress(String address)
    {
        this.address = address;
    }

    //Set phone
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    //Set email
    public void setEmail(String email)
    {
        this.email = email;
    }

    //String description of the class
    public String toString()
    {
        return "\nName: " + name + "\nAddress: " + address
                + "\nPhone number: " + phone + "\nEmail Address: "
                + email;
    }


}
