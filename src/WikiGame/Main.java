package WikiGame;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main JavaFX Application
 *
 * @author Lauren Rose
 * @version 0.1.2
 */
public class Main extends Application {

    /**
     * Starts the program
     * @param primaryStage main stage
     * @throws Exception general exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        new ApplicationController(primaryStage);
    }

    /**
     * Runs the launcher
     * @param args standard arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}