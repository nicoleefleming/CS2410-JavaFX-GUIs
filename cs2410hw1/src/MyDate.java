import java.util.GregorianCalendar;

public class MyDate
{
   //Data objects
    private int year;
    private int month;
    private int day;

    //Create MyDate obj for the current date
    public MyDate()
    {
        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(GregorianCalendar.YEAR);
        month = calendar.get(GregorianCalendar.MONTH);
        day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }

    //Create MyDate obj with a specified elapsed time,
    //since midnight Jan 1, 1970, in ms
    public MyDate(long elapsedTime)
    {
        setDate(elapsedTime);
    }

    //Creates MyDate obj with specific day, month, year
    public MyDate(int yyyy, int mm, int dd)
    {
        year = yyyy;
        month = mm;
        day = dd;
    }

    //Return day
    public String getDay()
    {
        String dd = String.valueOf(day);

        //return if day < 10, a 0_, a zero preceeding the day
        return (day < 10 ? "0" + dd : dd);
    }

    //Return month
    public String getMonth()
    {
        String mm = String.valueOf(month + 1);

        //return if month less than 10, 0_, so a zero precedes the month
        return (month <10 ? "0" +mm : mm);
    }

    //Return year
    public int getYear()
    {
        return year;
    }

    //Sets new date for obj using elapsed time
    public void setDate(long elapsedTime)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);
        year = calendar.get(GregorianCalendar.YEAR);
        month = calendar.get(GregorianCalendar.MONTH);
        day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }

}
