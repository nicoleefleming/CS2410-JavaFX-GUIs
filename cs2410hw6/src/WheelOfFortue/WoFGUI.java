package WheelOfFortue;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.text.DefaultEditorKit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;
import java.lang.System;
import java.util.Scanner;

public class WoFGUI extends Application {
    String list = "Reset Board";
    Account account;
    Player player;
    Host host;
    Board board;
    private SimpleIntegerProperty lettersToGuess = new SimpleIntegerProperty();
    private SimpleBooleanProperty playable = new SimpleBooleanProperty();
    private ObservableList<Node> letters;

    /**
     * K - characters [A..Z] and '-'
     * V - javafx.scene.Text representation of K
     */
    private HashMap<Character, Text> alphabet = new HashMap<Character, Text>();
    private String sentence = "";

    private static class Letter extends StackPane {
        private Rectangle bg = new Rectangle(40, 60);
        private Text text;

        public Letter(char letter) {
            bg.setFill(letter == ' ' ? Color.DARKSEAGREEN : Color.WHITE);
            bg.setStroke(Color.BLUE);

            text = new Text(String.valueOf(letter).toUpperCase());
            text.setFont(Font.getDefault());
            text.setVisible(false);

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg, text);
        }

        public void show() {
            RotateTransition rt = new RotateTransition(Duration.seconds(1), bg);
            rt.setAxis(Rotate.Y_AXIS);
            rt.setToAngle(180);
            rt.setOnFinished(event -> text.setVisible(true));
            rt.play();
        }

        public boolean isEqualTo(char other) {
            return text.getText().equals(String.valueOf(other).toUpperCase());
        }
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Pane pane = new Pane();

//        Arc arc = new Arc(325, 325, 150, 150, 90, 90);
//        arc.setFill(Color.THISTLE);
//        arc.setStroke(Color.BLACK);
//        arc.setType(ArcType.ROUND);
//        arc.setStrokeWidth(2);

        Arc arc1 = new Arc( 325, 325, 150, 150, 0, 60);
        arc1.setType(ArcType.ROUND);
        arc1.setStroke(Color.BLACK);
        arc1.setFill(Color.INDIANRED);
        arc1.setStrokeWidth(2);

        Arc arc2 = new Arc( 325, 325, 150, 150, 60, 60);
        arc2.setType(ArcType.ROUND);
        arc2.setStroke(Color.BLACK);
        arc2.setFill(Color.HOTPINK);
        arc2.setStrokeWidth(2);

        Arc arc3 = new Arc( 325, 325, 150, 150, 120, 60);
        arc3.setType(ArcType.ROUND);
        arc3.setStroke(Color.BLACK);
        arc3.setFill(Color.ORANGE);
        arc3.setStrokeWidth(2);

        Arc arc4 = new Arc( 325, 325, 150, 150, 180, 60);
        arc4.setType(ArcType.ROUND);
        arc4.setStroke(Color.BLACK);
        arc4.setFill(Color.BLUEVIOLET);
        arc4.setStrokeWidth(2);

        Arc arc5 = new Arc( 325, 325, 150, 150, 240, 60);
        arc5.setType(ArcType.ROUND);
        arc5.setStroke(Color.BLACK);
        arc5.setFill(Color.YELLOW);
        arc5.setStrokeWidth(2);

        Arc arc6 = new Arc( 325, 325, 150, 150, 300, 60);
        arc6.setType(ArcType.ROUND);
        arc6.setStroke(Color.BLACK);
        arc6.setFill(Color.GREENYELLOW);
        arc6.setStrokeWidth(2);

        //pane.getChildren().add(arc1);


        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20,50,10,20));

        Button btTop = new Button("Spin");
        btTop.setLayoutX(150);

//            btTop.setOnMouseClicked(e -> {
//                pane.setRotate(360 + (360/Math.random()));
//                //text.setFont("Comic Sans", 20);
//            });

        //TODO Add combo box to reset the board
        ComboBox comboBox = new ComboBox();

        comboBox.getItems().add("Reset Board");

        comboBox.setEditable(true);

        HBox hbox2 = new HBox(comboBox);
        comboBox.setOnAction(e -> reset());

        Text centerText = new Text("Wheel of Fortune");
        //borderPane.setAlignment(centerText, Pos.BOTTOM_LEFT);
        Text title = new Text("Please enter guesses");
        TextField Guesses = new TextField();
        //borderPane.setAlignment(Guesses, Pos.BOTTOM_LEFT);

        HBox hbox = new HBox();
        HBox hbox1 = new HBox();
        hbox.getChildren().add(centerText);
        hbox1.getChildren().addAll(title, Guesses, btTop);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox, hbox1,hbox2);

        pane.getChildren().addAll(vbox);


        //TODO Attempt to get rotate Transition working
        //Instantiating RotateTransition class
        RotateTransition rotate = new RotateTransition();

        //Setting Axis of rotation
        rotate.setAxis(Rotate.Z_AXIS);

        // setting the angle of rotation
        rotate.setByAngle(360);

        //setting cycle count of the rotation
        rotate.setCycleCount(500);

        //Setting duration of the transition
        rotate.setDuration(Duration.millis(1000));

        //the transition will be auto reversed by setting this to true
        rotate.setAutoReverse(false);

        Group group = new Group();
        group.getChildren().addAll(arc1, arc2, arc3, arc4, arc5, arc6);

        //setting Rectangle as the node onto which the
        // transition will be applied
        rotate.setNode(group);

        rotate.play();
        //TODO End attempt of Rotate Transition


        Guesses.setOnKeyTyped(e-> {
//            String[] sent;
//            sent[0] = sentence;
//            char[] arr = {};
//            char[] n = {};
//            for (int start = 0; start < sent.length-1; start++)
//            {
//                arr = sent[start].toCharArray();
//            }
//            if (sentence.getChars(0, sentence.length() - 1, arr, 0).is) {
//                return;
//            }
//
//            char pressed = sentence.getChars(0,sentence.length()-1,arr, 0 ).toUpperCase().charAt(0);
//            if ((pressed < 'A' || pressed > 'Z') && pressed != '-')
//                return;
//
//            if (playable.get()) {
//                Text t = alphabet.get(pressed);
//                if (t.isStrikethrough())
//                    return;
//
//                // mark the letter 'used'
//                t.setFill(Color.BLUE);
//                t.setStrikethrough(true);
//
//                boolean found = false;
//
//                for (Node n : letters) {
//                    Letter letter = (Letter) n;
//                    if (letter.isEqualTo(pressed)) {
//                        found = true;
//                        account.credit(0 + 500);
//                        account.debit(0);
//                        lettersToGuess.set(lettersToGuess.get() - 1);
//                        letter.show();
//                    }
//                }
//            }

            player.buyVowel();
            player.guessConsonant();

        });



        //TODO THIS IS THE CODE THAT MAKES SPIN BUTTON WORK
        pane.getChildren().addAll(arc1, arc2, arc3, arc4, arc5, arc6); //wheel);




        btTop.setOnMouseClicked(e -> {
            pane.setRotate(360 + (360/Math.random()));
            //text.setFont("Comic Sans", 20);
        });







        double angle = 375;
        double duration = 3;
        //borderPane.setCenter(wheel);
        //System.out.println(borderPane.getCenter());

//        //set on button clicked.
//        RotateTransition rt = new RotateTransition();
//        rt.setNode(wheel);
//        rt.setByAngle(angle);
//        rt.setDuration(Duration.seconds(duration));
//        rt.setCycleCount(1);
//        rt.setAutoReverse(false);
//        rt.setInterpolator(Interpolator.EASE_OUT);
//        rt.play();

//        rt.setOnFinished(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent ae) {
//                wheelBoundingBox();
//            }
//        });


//        public void wheelBoundingBox () {
//            double MX = wheel.getBoundsInParent().getMaxX();
//            double MY = wheel.getBoundsInParent().getMaxY();
//            double mX = wheel.getBoundsInParent().getMinX();
//            double mY = wheel.getBoundsInParent().getMinY();
//
//            double width = MX - mX;
//            double height = MY - mY;
//
//            Rectangle bb = new Rectangle(mX, mY, Color.TRANSPARENT);
//            bb.setWidth(width);
//            bb.setHeight(height);
//            bb.setStroke(Color.DARKGRAY);
//            bb.setStrokeWidth(1);

            //backgroundAnchorPane.getChildren().add(borderPane);
            //backgroundAnchorPane.getChildren().add(wheel);
            //anchorPane.getChildren().add(wheel);
            //pane.getChildren().addAll(borderPane);//,anchorPane);
            pane.setShape(new Rectangle(400,400));
           // pane.setMaxSize(325,325);
           // borderPane.getChildren().add(pane);
         //   borderPane.setCenter(pane);
            //borderPane.setTop(vbox);

            //borderPane.setCenter(pane);

        StackPane stack = new StackPane();
            stack.getChildren().addAll(borderPane, pane);
            root.getChildren().addAll(stack);

            Scene scene = new Scene(root);



            primaryStage.setResizable(true);
            primaryStage.setWidth(700);
            primaryStage.setHeight(700);
            primaryStage.setTitle("Wheel of Fortune");
            primaryStage.setScene(scene);
            primaryStage.show();
            //startGame();
        }

        public static void main (String args[])
        {
            launch(args);
        }

        public void reset()
        {
           //getChildren().forEach(node -> node.setVisible(false));
            Stage pStage = new Stage();
            start(pStage);
        }

        public static String[] input(File file){
        String expression = "";
        try
        {
            //create a new Scanner
            Scanner read = new Scanner(file);

            //scans file and puts into string to convert.
            expression = read.nextLine();
        }
        catch(FileNotFoundException error)
        {
            //will print ONLY if the file is not found. Will print in RED
            System.out.println(new File("phrases.txt").getAbsolutePath());
            System.err.println("Did not find file");
        }
        //put read in string into string array and split
        String[] words = expression.split("\n");

        //return array of integers
        return words;
        }
    }

//    Alert winAlert = new Alert(Alert.AlertType.INFORMATION);
//                        winAlert.setTitle("Game Over!");
//                                winAlert.setHeaderText(null);
//                                winAlert.setContentText(
//                                "Player " + playerWin + " wins!");
//                                winAlert.showAndWait();
