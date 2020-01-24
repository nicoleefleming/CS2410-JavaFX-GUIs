import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * In this project all the x rows in the Sudoku grid are referenced as idx.
 * Similarly all the y colums, rows, are referenced as jdy.
 * This is in the thinking of index 'd' in the x direction,
 * and index 'd' in the y direction.
 */
public class SudokuUI extends Application
{
    //ArrayList to store Sudoku game boards
    ArrayList<int[]> sudokuTemplate = new ArrayList<>();
    //final size of the boards
    public static final int SIZE = 9;
    //textfield to store values
    private TextField[][] myCells = new TextField[SIZE][SIZE];
    //solve button
    private Button solveButton = new Button("Solve");
    //clear button
    private Button clearButton = new Button("Clear");
    //next button
    private Button nextButton = new Button("Next");
    //label for status, to display the total solution count
    // and current solution count
    private Label statusLabel = new Label();
    //to store solutions
    private static ArrayList myList = new ArrayList();
    //to store the index of the displayed solution
    private int solutionIndexCurrent = 0;
    //2D array to store integers from text files to put into game board.
    int[][] puzzle = new int[9][9];
    //List of the 2D puzzle arrays
    //public ArrayList<int[]> toSolve = new ArrayList<>();

    //override start method
    @Override
    public void start(Stage primaryStage)
    {
        getPuzzle();
        //2D array of GridPane
        GridPane[][] myPanels = new GridPane[3][3];
        //main GridPane
        GridPane myGridPane = new GridPane();
        //setting the style to black
        myGridPane.setGridLinesVisible(true);
        myGridPane.setStyle("fx-border-color: green");
        //loop to initialize GridPane
        for (int idx = 0; idx <3; idx++)
        {
            for (int jdy = 0; jdy < 3; jdy++)
            {
                //initialize 2D array
                myGridPane.add(myPanels[idx][jdy] = new GridPane(), jdy, idx);
                //setting each GridPane style to black
                myPanels[idx][jdy].setStyle("fx-border-color: green");
            }
        }
        for (int idx = 0; idx< 9; idx++)
        {
            for (int jdy = 0; jdy < 9; jdy++)
            {
                myPanels[idx/3][jdy/3].add(myCells[idx][jdy] = new TextField(),
                        jdy % 3, idx %3);
                myCells[idx][jdy].setPrefColumnCount(1);
            }
        }

        //create a HBox to store buttons
        HBox myHBox = new HBox(5);
        //adding buttons to HBox
        myHBox.getChildren().addAll(solveButton, clearButton, nextButton);
        //allign HBox to center
        myHBox.setAlignment(Pos.CENTER);
        //default visibility of next button to false
        nextButton.setVisible(false);

        //create a BorderPane
        BorderPane myBorderPane = new BorderPane();
        //place myGridPane in teh center of BorderPane
        myBorderPane.setCenter(myGridPane);
        //setting myHBox to the bottom of the BorderPane
        myBorderPane.setBottom(myHBox);
        //placing statusLabel to the top
        myBorderPane.setTop(statusLabel);
        //set the allignment of label to center
        BorderPane.setAlignment(statusLabel, Pos.CENTER);

        //Put myScene into stage, after the creation of it.
        Scene myScene = new Scene(myBorderPane, 240, 280);

        //set stage title
        primaryStage.setTitle("Sudoku");

        //place scene onto stage
        primaryStage.setScene(myScene);

        //display the stage
        primaryStage.show();

        //LISTENERS:
        //click listener for the solveButton
        solveButton.setOnAction(e -> solve());

        //click listener for the clearButton
        clearButton.setOnAction(e ->
        {
            //clear the status
            statusLabel.setText("");
            //hide the next button
            nextButton.setVisible(false);


            //to clear the numbers
            for (int idx = 0; idx <9; idx++)
            {
                for (int jdy = 0; jdy <9; jdy++)
                {
                    //clear the values of each cells
//                    int[][] he = sudokuTemplate[idx][jdy].get(jdy);
//                    String me = he.toString();
                    myCells[idx][jdy].setText("");//me));
                    myCells[idx][jdy].setStyle("-fx-text-fill: black");
                }
            }
        });
        //set click listener for next button
        nextButton.setOnAction(e -> {
            //calculating the current solution index
            solutionIndexCurrent = solutionIndexCurrent++; //% myList.size();
            //update the solution index to the label
            statusLabel.setText(solutionIndexCurrent + 1 +"/" + myList.size() + "- 0's are values that need to change.");

            //get the puzzle at the given random index of the sudoku puzzles.
            int upper = 9;
            int lower = 0;
            int numPuzzle = (int)(Math.random() * (upper - lower)) + lower;
            int[] array = sudokuTemplate.get(numPuzzle);

            //2D array for the 1D array to be put into.
            int[][] solutionGrid = new int[9][9];// myList.get(solutionIndexCurrent);

            int index = 0;
            for (int row = 0; row < 9; row++)
            {
                for (int col = 0; col < 9; col++)
                {
                    //Maybe add in code to make the 0s turn into "", to not have 0s.
                    solutionGrid[row][col] = array[index];
                    index++;
                }
                index = row + 9;
            }


            //setting text to blanks at the start of the Sudoku
            for (int idx = 0; idx < 9; idx++)
            {
                for (int jdy = 0; jdy < 9; jdy++)
                {
                    myCells[idx][jdy].setText(solutionGrid[idx][jdy] + "");
                }
            }
        });
    }

    //method to solve Sudoku
    public void solve() {

        myList.clear();
        solutionIndexCurrent = 0;

        //solve the sudoku with the users input,3
        // highlight blue ones correct,
        // and red ones wrong

        int[][] myGrid = new int[9][9];

        //parse the values from myCells into the Grid
        for (int idx = 0; idx < 9; idx++)
        {
            for (int jdy = 0; jdy < 9; jdy++)
            {
                //if the cell is empty assign the value 0
                if (myCells[idx][jdy].getText().trim().length() == 0)
                {
                    //?
                    myGrid[idx][jdy] = 0;
                    //Maybe??
                    myCells[idx][jdy].setStyle("-fx-text-fill: blue");
                }
                //if not, then convert the value to int and store it in the grid.
                else
                {
                    myGrid[idx][jdy] = Integer.parseInt(myCells[idx][jdy].getText());
                    myCells[idx][jdy].setStyle("-fx-text-fill: black");
                }
            }
        }

        //call isValid method to check whether or not the Sudoku is valid.
        if(!Sudoku.isValid(myGrid))
        {
            statusLabel.setText("Invalid Input, Try Again.");
        }
        //call search method of Sudoku.java to solve Sudoku puzzle
        else if(Sudoku.search(myGrid))
        {
            //serach number of solution
            //int count =  Sudoku.search(myGrid);
            //if solution is 0
//            if (count == 0)
//            {
//                statusLabel.setText("No Solution");
//            }
//            else
//            {
            boolean tf = Sudoku.search(myGrid);
                //Display the first solution
                int[][] solutionGrid = puzzle;

                //display the solved sudoku
                for (int idx = 0; idx < 9; idx++)
                {
                    for (int jdy = 0; jdy < 9; jdy++)
                    {
                        myCells[idx][jdy].setText(myGrid[idx][jdy] + "");
                    }
                }
            }

        //if there are more than 1 solution make the next button visible
        if(sudokuTemplate.size() > 1)
        {
            nextButton.setVisible(true);
            statusLabel.setText("1/" + sudokuTemplate.size() + " solutions");
            if(!Sudoku.isValid(myGrid))
            {
                statusLabel.setText("Invalid Input, Try Again.");
                for (int idx = 0; idx < 9; idx++)
                {
                    for (int jdy = 0; jdy < 9; jdy++){
                        myCells[idx][jdy].setStyle("-fx-text-fill: red");
                    }
                }
            }
            else
            {
                statusLabel.setText("Solution found.");
            }
            //System.out.println("Solution Found!");
        }
        //if no solution is present
        else
        {
            statusLabel.setText("Solution not found.");
        }
    }

    //TODO make method that uses readAPuzzle from Sudoku.java to read in a 2D int array
    public ArrayList<int[]> getPuzzle()
    {
        //TODO import all files into List of arrays.

        File inFile = new File("C:\\Users\\Nicole\\IdeaProjects\\cs2410hw7\\src\\Sudoku.txt");
        File inFile1 = new File("C:\\Users\\Nicole\\IdeaProjects\\cs2410hw7\\src\\Sudoku1.txt");
        File inFile2 = new File("C:\\Users\\Nicole\\IdeaProjects\\cs2410hw7\\src\\Sudoku2.txt");
        File inFile3 = new File("C:\\Users\\Nicole\\IdeaProjects\\cs2410hw7\\src\\Sudoku3.txt");
        File inFile4 = new File("C:\\Users\\Nicole\\IdeaProjects\\cs2410hw7\\src\\Sudoku4.txt");
        File inFile5 = new File("C:\\Users\\Nicole\\IdeaProjects\\cs2410hw7\\src\\Sudoku5.txt");
        File inFile6 = new File("C:\\Users\\Nicole\\IdeaProjects\\cs2410hw7\\src\\Sudoku6.txt");
        File inFile7 = new File("C:\\Users\\Nicole\\IdeaProjects\\cs2410hw7\\src\\Sudoku7.txt");

        //read in the Files into int[][] cycle through each file
        int[] test;
        int[] test1;
        int[] test2;
        int[] test3;
        int[] test4;
        int[] test5;
        int[] test6;
        int[] test7;

        test = input(inFile);
        System.out.println(test.toString());
        test1 = input(inFile1);
        test2 = input(inFile2);
        test3 = input(inFile3);
        test4 = input(inFile4);
        test5 = input(inFile5);
        test6 = input(inFile6);
        test7 = input(inFile7);

        //make 1D arrays into 2D arrays to add to ArrayList
        int[][] puzzle  = new int[9][9];
        int[][] puzzle1 = new int[9][9];
        int[][] puzzle2 = new int[9][9];
        int[][] puzzle3 = new int[9][9];
        int[][] puzzle4 = new int[9][9];
        int[][] puzzle5 = new int[9][9];
        int[][] puzzle6 = new int[9][9];
        int[][] puzzle7 = new int[9][9];

        //TODO convert 1D tests into 2D puzzles
        int k = 0;


//        int index = 0;
//        for (int row = 0; row < 9; row++)
//        {
//            for(int col = 0; col < 9; col++)
//            {
//                puzzle[row][col] = test[index];
//                index++;
//            }
//            index = index * 9;
//        }
//        index = 0;
//        for (int row = 0; row < 9; row++)
//        {
//            for(int col = 0; col < 9; col++)
//            {
//                test1[index] = puzzle1[row][col];
//                index++;
//            }
//              index = row * 9;
//        }
//        index = 0;
//        for (int row = 0; row < 9; row++)
//        {
//            for(int col = 0; col < 9; col++)
//            {
//                test2[index] = puzzle2[row][col];
//                index++;
//            }
//            index = row * 9;
//        }
//        index = 0;
//        for (int row = 0; row < 9; row++)
//        {
//            for(int col = 0; col < 9; col++)
//            {
//                test3[index] = puzzle3[row][col];
//                index++;
//            }
//            index = row * 9;
//        }
//        index = 0;
//        for (int row = 0; row < 9; row++)
//        {
//            for(int col = 0; col < 9; col++)
//            {
//                test4[index] = puzzle4[row][col];
//                index++;
//            }
//        }
//        index = 0;
//        for (int row = 0; row < 9; row++)
//        {
//            for(int col = 0; col < 9; col++)
//            {
//                test5[index] = puzzle5[row][col];
//                index++;
//            }
//        }
//        index = 0;
//        for (int row = 0; row < 9; row++)
//        {
//            for(int col = 0; col < 9; col++)
//            {
//                test6[index] = puzzle6[row][col];
//                index++;
//            }
//        }
//        index = 0;
//        for (int row = 0; row < 9; row++)
//        {
//            for(int col = 0; col < 9; col++)
//            {
//                test7[index] = puzzle7[row][col];
//                index++;
//            }
//        }


        sudokuTemplate.add(test); //, test1, test2, test3, test4, test5, test6, test7);
        sudokuTemplate.add(test1);
        sudokuTemplate.add(test2);
        sudokuTemplate.add(test3);
        sudokuTemplate.add(test4);
        sudokuTemplate.add(test5);
        sudokuTemplate.add(test6);
        sudokuTemplate.add(test7);

        sudokuTemplate.get(0).toString();


        //add each int[][] into the ArrayList.
        //sudoku.addAll();
        return sudokuTemplate;
    }

    public static int[] input(File file)
    {
        String expression = "";
        try
        {
            //created a new File object

            //create a new Scanner
            Scanner read = new Scanner(file);

            //scans file and puts into string to convert.
            expression = read.nextLine();
        }
        catch(FileNotFoundException error)
        {
            //will print ONLY if the file is not found. Will print in RED
            System.err.println("Did not find file");
        }
        //put read in string into string array and split

        String[] toInt = expression.split(" ");
        //System.out.println(toInt);
       // String[] Row = expression.split(" ");
        //System.out.println(Row);


        // Create new array to store integers from conversion of string array
        //int[][] ints = new int[toInt.length][Row.length];
        int[] intss = new int[toInt.length];
        //Debugging to make sure it is correct
        //System.out.println(ints);

        //convert string to array of integers
//        for (int num=0; num < toInt.length; num++) {
//            for (int sum = 0; sum < Row.length; sum++){
//                ints[num][sum] = Integer.parseInt(toInt[num]);
//            }
//
//        }
        for(int numb = 0; numb <toInt.length; numb++)
        {
            intss[numb] = Integer.parseInt(toInt[numb]);
        }
        System.out.println(intss);
        //return array of integers
        return intss;
    }

    //TODO make a method to input the values from the 2D array into the initial Sudoku mapping


    //TODO...


    public static void main(String args)
    {
        launch(args);
    }
}
