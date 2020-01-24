package textInCircle;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class textInCircle extends Application{

    public void start(Stage firstStage) {

        double rds = 100;

        double circleAngle = 0;

        double rotateby = 90;

        Pane pne = new Pane();



        Font fnt = Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 30);

        Point2D circleCenter = new Point2D(200, 200);

        String[] str = "Welcome to Java".split("");

        for (int i = 0; i < str.length; i++, circleAngle += 22, rotateby += 22)

        {

            double xcooredinate = circleCenter.getX() + rds * Math.cos(Math.toRadians(circleAngle));

            double ycooordinate = circleCenter.getY() + rds * Math.sin(Math.toRadians(circleAngle));

            Text result = new Text(xcooredinate, ycooordinate,str[i]);

            result.setRotate(rotateby);

            result.setFont(fnt);

            pne.getChildren().add(result);

        }

        Scene pic = new Scene(pne, 400, 400);

        firstStage.setTitle("Text in a Circle");

        firstStage.setScene(pic);

        firstStage.show();

    }

    public static void main(String[] args) {

        Application.launch(args);

    }

}