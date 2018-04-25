package WikiGame.AboutScreen;

import WikiGame.ApplicationController;
import javafx.fxml.FXML;

/**
 * Handles the About page
 *
 * @author Lauren Rose
 * @version 0.1.2
 */
public class AboutController {

    @FXML
    private ApplicationController parent;

    /**
     * Sets the parent controller for the FXMLloader
     * @param ac parent controller
     */
    public void setParent(ApplicationController ac) {
        parent = ac;
    }

    /**
     * Handles the go home button click
     */
    @FXML
    public void goBackClicked() {
        parent.goBack();
    }
}