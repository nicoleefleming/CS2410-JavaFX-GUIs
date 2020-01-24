package Polymorphism;
import java.lang.Math;

public class Shape
{
    //variables
    double side;
    String name;

    //consturctor
    public Shape()
    {
        this.side = 0;
        this.name = "unknown";
    }

    public Shape(double side, String name)
    {
        this.side = side;
        this.name = name;
    }

    //getters
    public double getSide()
    {
     return side;
    }
    public String getName()
    {
        return name;
    }

    //setters
    public void setSide(double side)
    {
        this.side = side;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    //getArea
    public double getArea(double side)
    {
        double area;
        area = side * 0;
        return area;
    }
}
