package Polymorphism;

import java.util.*;

public class TestShapes
{

    public static void main(String args[])
    {
        //array list
        ArrayList<Shape> areaList = new ArrayList();

        int integers[] = {2,3,4,5,6,7,8,9};


        //create objects of shapes randomly
        areaList.add(new Cube("cube1", 3));
        areaList.add(new Cube("cube2", 9));
        areaList.add(new Square("square1", 6));
        areaList.add(new Square("Square2", 4));
        areaList.add(new Triangle("triangle1", 3));
        areaList.add(new Triangle("triangle2", 3));
        areaList.add(new Pyrimid("pyrimid1", 3));
        areaList.add(new Pyrimid("pyrimid2", 3));

        //call the arraylist and print out the answers
        for (int index = 0; index <= areaList.size() - 1; index++)
        {
            double answer;
            answer = areaList.get(index).getArea(integers[index]);

            System.out.println(areaList.get(index).getName() + ": " + answer);
        }

    }
}
