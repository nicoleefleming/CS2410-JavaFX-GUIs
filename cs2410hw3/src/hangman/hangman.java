package hangman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Arc;
import javafx.scene.layout.Pane;
import javafx.collections.ObservableList;


public class hangman extends Application
{
    public void start(Stage primaryStage)
    {
        //Create a pane
        Pane paneObj = new Pane();

        //Create three polylines and set properties
        Polyline polyline1 = new Polyline();
        paneObj.getChildren().add(polyline1);
        polyline1.setStroke(Color.BLACK);
        ObservableList<Double> list = polyline1.getPoints();
        double x1 = 40.0;
        double y1 = 190.0;
        double y2 = 20.0;
        double x3 = 125.0;
        list.addAll(x1, y1, x1, y2, x3, y2, x3, y1 * .60);

        //new polyline object
        Polyline polyline2 = new Polyline();
        paneObj.getChildren().add(polyline2);
        polyline2.setStroke(Color.BLACK);
        ObservableList<Double> list2 = polyline2.getPoints();
        list2.addAll((x1 + x3) * .5, y1 * .5, x3, y1 * .25, x3 + (x3 - x1) * .5, y1 * .5);

        //new polyline object
        Polyline polyline3 = new Polyline();
        paneObj.getChildren().add(polyline3);
        polyline3.setStroke(Color.BLACK);
        ObservableList<Double> list3 = polyline3.getPoints();
        list3.addAll((x1 + x3) * .6, y1 * .80, x3, y1 * .60, x3 + (x3 - x1) * .3, y1 * .80);

        //Create a circle and set properties
        Circle circleObj = new Circle(x3, y1*.25, 15);
        circleObj.setFill(Color.WHITE);
        circleObj.setStroke(Color.BLACK);
        paneObj.getChildren().add(circleObj);

        //Create the arc and set properties
        Arc arcObj = new Arc(x1,y1,25,15,0,180);
        arcObj.setFill(Color.WHITE);
        arcObj.setStroke(Color.BLACK);
        paneObj.getChildren().add(arcObj);

        //Created Scene and placed into Stage
        Scene sceneObj = new Scene(paneObj, 200,200);

        //Set the Stage title, and show it to the screen
        primaryStage.setTitle("Hanged Man");
        primaryStage.setScene(sceneObj);
        primaryStage.show();
    }

    public static void main(String args[])
    {
        Application.launch(args);
    }
}
