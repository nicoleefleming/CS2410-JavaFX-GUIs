package Polymorphism;

import java.lang.Math;


public class Triangle extends Shape
{
    //variables
    double side;

    //constructor
    public Triangle(String name, double side)
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
        double base;
        double height;
        double htholder;

        base = (side/2);
        htholder = (base * base)+(base * base);
        height = Math.sqrt(htholder);

        area = (base * height);

        return area;
    }
}
