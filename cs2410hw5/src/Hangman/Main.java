package Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        BorderPane bdpane = new BorderPane();
        VBox vbox = new VBox();
        HBox hbox = new HBox();

        //logic for pane here.


        primaryStage.setTitle("Hangman");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(bdpane, 500, 450));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }

}
