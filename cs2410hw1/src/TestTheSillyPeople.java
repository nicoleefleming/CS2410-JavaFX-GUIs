
public class TestTheSillyPeople
{
    public static void main(String args[])
    {
        //Create Person, Student, Employee, Faculty, and Staff obj
        Person person = new Person();

        person.setAddress("The Burrow, Room at the top of the stairs, Devon, England");
        person.setName("Ron Weasly");
        person.setPhone("013924445788");
        person.setEmail("ron.ron.weasley@pottermore.net");

        person.getName();
        person.getAddress();
        person.getPhone();
        person.getEmail();

        Student student = new Student("Hermione Granger", "Heathgate, Hampstead",
                "0205546659", "h.crookshanks4evr@pottermore.net", Student.Senior);



        Employee employee = new Employee("Severus Snape", "Room 9 Hogwarts", "1564448889",
                "severus,snape@hogwarts.edu", 99, 80000);

        Faculty faculty = new Faculty("Minerva McGonagall", "Room 356 Hogwarts",
                "1564448356", "m.mcgonagall@hogwarts.edu", 356, 100000,
                "10:30am - 12:30pm", "Professor");

        Staff staff = new Staff("Mr. Finch", "Hogwarts", "5555555555",
                "m.finch@hogwarts.edu,", 10, 60000, "Janitor");


        //Use toString() methods to print each out
        System.out.println(person.toString());
        System.out.println(student.toString());
        System.out.println(employee.toString());
        System.out.println(faculty.toString());
        System.out.println(staff.toString());
    }
}
