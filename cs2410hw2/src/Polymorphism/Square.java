package Polymorphism;

public class Square extends Shape
{
    //variables
    double side;

    //consturctor
    public Square(String name, double side)
    {
        super(side, name);
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
        area = side * side;
        return area;
    }
}
