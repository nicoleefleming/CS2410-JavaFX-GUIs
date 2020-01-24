package HelloWorld;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javax.swing.JButton;
import javax.swing.JLabel;

public class helloWorld extends Application
{
    public void start(Stage primaryStage)
    {
        //Creation of the pane to put on the scene
        Pane pane = new HBox();

        Group rootGroup = new Group();
        //This is the image I used when I thought Andy wanted the words on a Button.
        //There is code below that has this working when it runs
        Image image = new Image("File:\\Users\\Nicole\\IdeaProjects\\cs2410hw2\\src\\HelloWorld\\hello.png");

        //This is the text that I tried to use, and kind of failed with using...
        Text text1 = new Text("Hello ");
//        text1.setFill(Color.DARKKHAKI);
        text1.setFont(Font.font(java.awt.Font.TRUETYPE_FONT));
        //rootGroup.getChildren().add.(text1;)
        Text text2 = new Text("World!");
        text2.setFill(Color.DARKGOLDENROD);
        text2.setFont(Font.font(java.awt.Font.SERIF));

        //These are the string objects that I ended up using for the labels. Since it was not intuitive to my brain.
        String txtHolder = text1.getText();
        String txtHolder2 = text2.getText();

        //Labels used to run.
        Label label = new Label(txtHolder);
        Label label2 = new Label(txtHolder2);
        label.setTextFill(Color.INDIANRED);
        label2.setTextFill(Color.BLUE);

        //Button setup
//        Button button = new Button();
//        button.setGraphic(new ImageView(image));
//        button.setStyle("-fx-border-color: purple");
//        button.setAlignment(Pos.CENTER);

//        button.setText();
//        button.setTextFill(Color.DARKGOLDENROD);
//        button.setText(txtHolder + txtHolder2);
//        button.setTextFill(Color.BLUEVIOLET);

        //ACTIVATE!!
        pane.getChildren().addAll(label, label2);
       // pane.getChildren().add(button);

        Scene scene = new Scene(pane,200,250);
        primaryStage.setTitle("HelloWorld");//Title
        primaryStage.setScene(scene); //scene on the stage
        primaryStage.show(); //present the show
    }
    public static void main(String args[])
    {
        launch(args);
    }
}
