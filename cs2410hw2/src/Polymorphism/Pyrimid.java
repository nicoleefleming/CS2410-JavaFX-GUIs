package Polymorphism;

public class Pyrimid extends Triangle
{
    //variables
    double side;

    //constructor
    public Pyrimid(String name, double side)
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
        double base;
        double height;
        double htholder;
        double surfaceArea;

        base = (side/2);
        htholder = (base * base)+(base * base);
        height = Math.sqrt(htholder);

        area = (base * height);
        surfaceArea = (area * 4);

        return surfaceArea;
    }
}
