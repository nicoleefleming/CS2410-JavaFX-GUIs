package WheelOfFortue;

import javafx.application.Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WheelOfFortune{

    private List<Player> players;

    private Host host;

    private Wheel wheel;

    String[] toGuess;

    public WheelOfFortune(List<Player> players, Host host, Wheel wheel) {
        this.players = players;
        this.host = host;
        this.wheel = wheel;
    }

    public static void main(String[] args) {

        String words = "Welcome to the Wheel of Fortune";
        Board board = new Board(words);
        Host host = new Host(board);

        Player player1 = new Player("player1", new Account(700), host);
        Player player2 = new Player("player2",new Account(), host);
        Player player3 = new Player("player3",new Account(500), host);
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        Host host1 = new Host(board);
        Wheel wheel = new Wheel();
        WheelOfFortune wheelOfFortune = new WheelOfFortune(players, host1, wheel);
        //WheelOfFortune.start();

    }

    public void start() {
        int round = 0;
        File file = new File("C:\\Users\\Nicole\\IdeaProjects\\cs2410hw6\\src\\phrases.txt");
        toGuess = input(file);
        int re = 700;

        while (!isGameOver()) {
            round++;
            Board board = new Board(toGuess[1]);
            //TODO Figure out this error stuff. It still won't work...
            //Player player = new Player("playerN", re , board);
            for (Player player : players)
            {

                boolean isTurnOver = false;
                while (!isTurnOver) {
                    Player.Choice choice = player.makeChoice();
                    if (choice == Player.Choice.SPIN_WHEEL) {
                        //TODO make player non-static, but that will work in the for loop
//                        SpinOutCome spinOutCome = Player.spinWheel(wheel, round);
//                        isTurnOver = processSpinOutCome(spinOutCome);
                    } else if (choice == Player.Choice.BUY_VOWEL) {
                        //TODO Vowel logic
                        char character = 'e';
                        player.buyVowel();

                        //TODO Vowel buy from user logic
                        isTurnOver = processVowelBuy(character);//1Buy(character);
                    }

                }
            }
        }
    }

    public static String[] input(File file)
    {
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

    private static boolean processVowelBuy(Character character) {
        return false;
    }

    private boolean processSpinOutCome(SpinOutCome spinOutCome) {
        SpinOutComeProcessor spinOutComeProcessor = getSpinOutcomeProcessor(spinOutCome);
        return spinOutComeProcessor.process();
    }

    private SpinOutComeProcessor getSpinOutcomeProcessor(SpinOutCome spinOutCome) {

//        if (spinOutCome instanceof WheelOfFortue.DollarAmoutSpinOutcome)
//            return new WheelOfFortue.DollarAmoutSpinOutcomeProcessor(host, (WheelOfFortue.DollarAmoutSpinOutcome)spinOutCome);
//        else
            return null;

    }

    private static boolean isGameOver() {
        return false;
    }





//    // Scene Size
//    private static final int HEIGHT = 800;
//    private static final int WIDHT = 1200;
//
//    private static final int CENTER_X = WIDHT / 2;
//    private static final int CENTER_Y = HEIGHT / 2;
//    private static final double ORBIT = 350;
//    private static final int FONT_SIZE = 10;
//
//    private static String[] phrases = {""};
//    private static Text winnerName;
//    private static Text arrowText;
//
//    private List<Point> points;
//
//    @Override
//    public void start(Stage primaryStage){
//       Pane root = new Pane();
//
//       //Load all the phrases
//        phrases = input(new File("C:\\Users\\Nicole\\IdeaProjects\\cs2410hw6\\src\\phrases"));
//
//        shufflePhrases(phrases);
//
//        int[] Money = {100, 200, 300, 400, 500, 600, 100, 200, 300, 400, 500, 600};
//
//        //calculate all the points where numbers should be positioned
//        points = calculatePoints(Money.length,CENTER_X, CENTER_Y, ORBIT);
//
//        //number of rotations per Timeline
//        int cyclesPerTimeline = 5;
//
//        //Create recursive timeline to slow down the wheel
//        //Timeline chaining
//        Timeline nextTimeline = null;
//
//        for (int numberOfTimelines = 10; numberOfTimelines > 0; numberOfTimelines--)
//        {
//            final KeyFrame duration = new KeyFrame(Duration.millis(100 * numberOfTimelines))
//            nextTimeline = createTimeline(root, duration, nextTimeline);
//            nextTimeline.setCycleCount(cyclesPerTimeline);
//        }
//
//        arrowText = new Text("Winner!");
//        arrowText.getStyleClass().add("arrow-text");
//        arrowText.setX(250);
//        arrowText.setY(CENTER_Y);
//
//        Rectangle rectangle = new Rectangle();
//        rectangle.getStyleClass().add("rectangle");
//        rectangle.setX(240);
//        rectangle.setY(((HEIGHT-75)/2));
//        rectangle.setWidth(450);
//        rectangle.setHeight(60);
//        root.getChildren().add(rectangle);
//
//        paintArrow(root);
//        //root.getChildren().addAll(phrases);
//        //root.getChildren().addAll(arrowText);
//
//        Scene scene = new Scene(root, WIDHT, HEIGHT);
//
//        primaryStage.setTitle("Wheel Of Fortune!");
//        primaryStage.setScene(scene);
//        primaryStage.getScene().getStylesheets().add("rotatingNames");
//        primaryStage.show();
//
//        nextTimeline.setDelay(Duration.seconds(10));
//        nextTimeline.play();
//    }
//
//
//
//    /**
//     * Calculate all points around the center.
//     *
//     *  @param points Number of points
//     *  @param centerX The center coordinate X.
//     * @ param center Y The center coordinate Y.
//     *  @param radius The radius (orbit) in pixel around the center.
//     * @return A List with Points.
//     */
//    public List<Point> calculatePoints(int points, double centerX, double centery, double radius)
//    {
//        List<Point> pointList = new ArrayList<>();
//
//        double rotateAngleDegree = 360d / (double)phrases.length;
//
//        double startAngleDegree = 270;
//        for (int rotationStep = 0; rotationStep < points; rotationStep++){
//            double degreeStart = rotationStep * rotateAngleDegree;
//
//            double angleAlpha = (degreeStart + startAngleDegree)*((Math.PI)/180);
//            Point p = new Point();
//            p.x = CENTER_X + ORBIT * Math.sin(angleAlpha);
//            p.y = CENTER_Y - ORBIT * Math.cos(angleAlpha);
//            p.position = rotationStep;
//            p.angle = degreeStart;
//            pointList.add(p);
//        }
//
//        return pointList;
//    }
//
//    private void paintArrow(Pane root)
//    {
//        double rightSpot = WIDHT/2 - ORBIT - 90;
//
//        //Get Arrow style in here.
//    }
//
//    private Timeline createTimeline(final Pane root, final KeyFrame duration, final Timeline nextTimeline) {
//        final Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//                moveNumbers(duration);
//            }
//        }), duration);
//
//        // Start next timeline on finish
//        timeline.setOnFinished(e -> {
//          {
//                handleNextTimelineAndWinner(root, nextTimeline);
//          };
//        });
//
//        return timeline;
//    }
//
//    public void handleNextTimelineAndWinner(Pane pane, Timeline nexTime )
//    {
//        if(nexTime != null)
//        {
//            //start next timeline
//            nexTime.play();
//        }
//        else
//        {
//            //only executed if the final timeline is reached.
//
//            //Make the text visible again
//            FadeTransition fadeTransition = new FadeTransition(Duration.millis(200),winnerName);
//            fadeTransition.setFromValue(0.3f);
//            fadeTransition.setToValue(1f);
//            fadeTransition.playFromStart();
//
//            pane.getChildren().remove(arrowText);
//
//
//        }
//    }
//
//    public static String[] input(File file)
//    {
//        String expression = "";
//        try
//        {
//            //create a new Scanner
//            Scanner read = new Scanner(file);
//
//            //scans file and puts into string to convert.
//            expression = read.nextLine();
//        }
//        catch(FileNotFoundException error)
//        {
//            //will print ONLY if the file is not found. Will print in RED
//            System.out.println(new File("phrases.txt").getAbsolutePath());
//            System.err.println("Did not find file");
//        }
//        //put read in string into string array and split
//        String[] words = expression.split("\n");
//
//        //return array of integers
//        return words;
//    }
//
//    private void shufflePhrases(String[] phrases){
//        //assign the string array into new array
//        String[] temp = phrases;
//
//        //shuffle Phrases array
//        for(int position = 0; position < temp.length; position++)
//        {
//            int end = temp.length - 1;
//            if (temp[position] == temp[end])
//            {
//                temp[position] = temp[0];
//            }
//            else
//            {
//                temp[position] = temp[position++];
//            }
//        }
//    }
//
//    public static void main(String[] args){
//        launch(args);
//    }
}
