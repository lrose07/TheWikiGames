package WikiGame;

import WikiGame.AboutScreen.AboutController;
import WikiGame.ConnectionGame.ConnectionController;
import WikiGame.FillBlanksGame.FillBlanksController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controls the entire application and moving between scenes
 *
 * @author Lauren Rose
 * @version 0.1.2
 */
public class ApplicationController {

    private Stage primaryStage;

    private Scene SMCscene;
    private Scene CONscene;
    private Scene FIBscene;
    private Scene ABOscene;

    /**
     * Defines the separate scenes for the game
     * @param s stage
     * @throws Exception any exception
     */
    ApplicationController(Stage s) throws Exception {
        primaryStage = s;

        FXMLLoader SMCloader = new FXMLLoader(ApplicationController.class.getResource("StartMenuScene.fxml"));
        SMCscene = new Scene(SMCloader.load());
        StartMenuController SMCcontroller = SMCloader.getController();
        SMCcontroller.setParent(this);

        FXMLLoader CONloader = new FXMLLoader(ApplicationController.class.getResource("ConnectionGame/ConnectionScene.fxml"));
        CONscene = new Scene(CONloader.load());
        ConnectionController CONcontroller = CONloader.getController();
        CONcontroller.setParent(this);

        FXMLLoader FIBloader = new FXMLLoader(ApplicationController.class.getResource("FillBlanksGame/FillBlanksScene.fxml"));
        FIBscene = new Scene(FIBloader.load());
        FillBlanksController FIBcontroller = FIBloader.getController();
        FIBcontroller.setParent(this);

        FXMLLoader ABOloader = new FXMLLoader(ApplicationController.class.getResource("AboutScreen/AboutScene.fxml"));
        ABOscene = new Scene(ABOloader.load());
        AboutController ABOcontroller = ABOloader.getController();
        ABOcontroller.setParent(this);

        primaryStage.setTitle("May The Searches Be Ever In Your Favor");
        primaryStage.setScene(SMCscene);
        primaryStage.show();
    }

    /**
     * Launches Connection Game
     */
    public void launchConnectionGame() {
        primaryStage.setScene(CONscene);
    }

    /**
     * Launches Fill in the Blanks Game
     */
    public void launchFillBlanksGame() {
        primaryStage.setScene(FIBscene);
    }

    /**
     * Sets scene back to home screen
     */
    public void goBack() {
        primaryStage.setScene(SMCscene);
    }

    /**
     * Opens about page
     */
    public void goToAboutPage() {
        primaryStage.setScene(ABOscene);
    }

}