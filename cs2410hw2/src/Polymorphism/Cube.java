package Polymorphism;

public class Cube extends Square
{
    //variables
    double side;

    //consturctor
    public Cube(String name, double side)
    {
        super(name, side);
        this.side = getSide(side);
    }
    //getters
    public double getSide(double side)
    {
        return side;
    }
    //setters
    public void setSide(double side)
    {
        this.side = side;
    }
    //getArea
    public double getArea(double side)
    {
        double area;
        area = ((side * side) * side);
        return area;
    }
}
