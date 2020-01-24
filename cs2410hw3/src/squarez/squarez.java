package squarez;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Arc;
import javafx.scene.layout.Pane;
import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import java.util.Scanner;


/** This program takes command line input and determines whether or not two rectangles overlap. */

public class squarez extends Application
{
    public void start(Stage primaryStage)
    {
        //Create new objects for display, and input, and set padding
        Scanner input = new Scanner(System.in);
        Pane pane = new Pane();
        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(10, 5, 5, 10));

        //Prompt user for dimensions of first rectangle
        System.out.println("Please enter the coordinates, width and height of the first rectangle.");

        //string object containing the coordinates and dimensions for rectangle 1
        String[] strec1 = (input.nextLine()).split("[ ]");
        Rectangle rec1 = getRectangle(strec1);

        //Prompt user for dimensions of second rectangle
        System.out.println("Please enter the coordinates, width and height of the second rectangle.");

        //string object containing coordinates and dimensions for rectangle 2
        String[] strec2 = (input.nextLine()).split("[ ]");
        Rectangle rec2 = getRectangle(strec2);

        //Create output string
        String output = "";

        //Conditions of what to print
        if((contains(rec1,rec2)) || (contains(rec2, rec1)))
        {
            output += "One rectangle is in the other";
        }
        else if(overlaps(rec1, rec2))
        {
            output += "The rectangles overlap.";
        }
        else
        {
            output += "The rectangles do not touch";
        }

        //add the rectangles to the pane
        pane.getChildren().addAll(rec1, rec2);

        // Place nodes in vbox
        vbox.getChildren().addAll(pane, new Text(20, 0, output));

        // Create a scene and place it in the stage
        Scene scene = new Scene(vbox);
        primaryStage.setTitle("Squarez"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /** Returns a rectangle with specified center coordinates, width, height. */
    private Rectangle getRectangle(String[] str){

        Rectangle rec = new Rectangle(Double.parseDouble(str[0]),

                Double.parseDouble(str[1]), Double.parseDouble(str[2]),

                Double.parseDouble(str[3]));

        //Set fill color
        rec.setFill(Color.WHITE);

        //Set outline color
        rec.setStroke(Color.DARKSLATEBLUE);

        return rec;
    }

    /** Returns true if one rectangle is inside the other */
    public boolean contains(Rectangle rectangle1, Rectangle rectangle2)
    {
        //This whole barfing of information determines if one rec is in the other.
        return  rectangle2.getY() + rectangle2.getHeight() <= rectangle1.getY() + rectangle1.getHeight() &&

                        rectangle2.getX() + rectangle2.getWidth() <= rectangle1.getX() + rectangle1.getWidth() &&

                        rectangle2.getX() > rectangle1.getX() && rectangle2.getY() > rectangle1.getY();

    }

    /** Returns true if the specified rectangles overlap */
    public boolean overlaps(Rectangle rectangle1, Rectangle rectangle2) {

        return getDistance(rectangle1.getX(), rectangle2.getX() + rectangle2.getWidth()) <

                rectangle1.getWidth() + rectangle2.getWidth() &&

                getDistance(rectangle1.getY(), rectangle2.getY() + rectangle2.getHeight()) <

                        rectangle1.getHeight() + rectangle2.getHeight();

    }

    /** Return distance */
    private double getDistance(double p1, double p2) {

        return Math.sqrt(Math.pow(p2 - p1, 2));

    }

    public static void main(String args[])
    {
        Application.launch(args);
    }
}
