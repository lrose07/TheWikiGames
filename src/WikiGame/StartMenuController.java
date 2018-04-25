package WikiGame;

import javafx.fxml.FXML;

/**
 * Handles the Buttons on the Start screen
 *
 * @author Lauren Rose
 * @version 0.1.2
 */
public class StartMenuController {

    @FXML
    private ApplicationController parent;

    /**
     * Handler for connection button
     */
    @FXML
    public void onConnectionClicked() {
        parent.launchConnectionGame();
    }

    /**
     * Handler for fill in the blanks button
     */
    @FXML
    public void onFillBlanksClicked() {
        parent.launchFillBlanksGame();
    }

    /**
     * Handler for about button
     */
    @FXML
    public void aboutClicked() {
        parent.goToAboutPage();
    }

    /**
     * Sets the parent controller for the FXMLloader
     * @param ac parent controller
     */
    public void setParent(ApplicationController ac) {
        parent = ac;
    }
}