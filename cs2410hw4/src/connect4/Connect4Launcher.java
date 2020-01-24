package connect4;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Nicole Fleming
 */

//Launch the Connect4 GUI
public class Connect4Launcher extends Application {
    public static void main(String [] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        connect4UI app = new connect4UI(new Presenter(), getParameters().getUnnamed());
        app.start(primaryStage);
    }

}