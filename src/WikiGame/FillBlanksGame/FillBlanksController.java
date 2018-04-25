package WikiGame.FillBlanksGame;

import WikiGame.ApplicationController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

public class FillBlanksController {

    @FXML
    private ApplicationController parent;
    @FXML
    private Text titleText;
    @FXML
    private Text bodyText;
    @FXML
    private Text scoreText;
    @FXML
    private ChoiceBox blankA;
    @FXML
    private ChoiceBox blankB;
    @FXML
    private ChoiceBox blankC;
    @FXML
    private ChoiceBox blankD;
    @FXML
    private ChoiceBox blankE;
    @FXML
    private ChoiceBox blankF;
    @FXML
    private Button doneButton;

    //todo: put Read more link after score of 6/6 is achieved

    /**
     *
     * @param e
     */
    @FXML
    public void backClicked(ActionEvent e) {
        parent.goBack();

        reset();
    }

    /**
     *
     * @param ac
     */
    public void setParent(ApplicationController ac) {
        parent = ac;
    }

    /**
     *
     */
    @FXML
    public void sanFranClicked() {
        scoreText.setText("0");

        titleText.setText("San Francisco");
        bodyText.setText("San Francisco, officially the _____(a)_____ of San Francisco, is the cultural, " +
                "commercial, and _____(b)_____ center of Northern California. It covers an area of about _____(c)_____ " +
                "square miles, mostly at the north end of the San Francisco Peninsula in the San Francisco " +
                "Bay Area. San Francisco is the _____(d)_____ populous city in California and the 13th-most " +
                "populous in the United States, with a 2017 census-estimated population of _____(e)_____. The " +
                "consolidated city-county is also the fifth most densely populated U.S. county, behind only four " +
                "New York City _____(f)_____. As of 2016, it was the 7th highest-income county in the United States, " +
                "with a per capita personal income of $110,418.");

        blankA.setItems(FXCollections.observableArrayList(
                "City and County", "Township", "Province", "Region"
        )); // city and county
        blankB.setItems(FXCollections.observableArrayList(
                "recreational", "business", "financial", "technology"
        )); // financial
        blankC.setItems(FXCollections.observableArrayList(
                "75.97", "46.89", "22.72", "105.54"
        )); // 46.89
        blankD.setItems(FXCollections.observableArrayList(
                "second-most", "third-most", "fourth-most", "fifth-most"
        )); // fourth-most
        blankE.setItems(FXCollections.observableArrayList(
                "884,363", "1,452,390", "702,566", "991,329"
        )); // 884,363
        blankF.setItems(FXCollections.observableArrayList(
                "counties", "townships", "cities", "boroughs"
        )); // boroughs

        doneButton.setDisable(false);
    }

    /**
     *
     */
    @FXML
    public void borderCollieClicked() {
        scoreText.setText("0");

        titleText.setText("Border Collie");
        bodyText.setText("The Border Collie is a working and _____(a)_____ dog breed developed in the _____(b)_____ " +
                "border region for herding livestock, especially sheep. It was specifically bred for intelligence " +
                "and _____(c)_____. Considered highly intelligent, extremely energetic, acrobatic and athletic, " +
                "they frequently compete with great success in _____(d)_____ and dog sports. They are often cited as " +
                "the most _____(e)_____ of all domestic dogs. Border Collies continue to be employed in their " +
                "traditional work of _____(f)_____ throughout the world.");

        blankA.setItems(FXCollections.observableArrayList(
                "toy", "sporting", "herding", "hound"
        )); // herding
        blankB.setItems(FXCollections.observableArrayList(
                "Anglo-Scottish", "Northern Irish", "French-German", "Welsh"
        )); // Anglo-Scottish
        blankC.setItems(FXCollections.observableArrayList(
                "dominance", "obedience", "aggression", "loyalty"
        )); // obedience
        blankD.setItems(FXCollections.observableArrayList(
                "dog shows", "races", "sheepdog trials", "The Highlander Dog Competitions"
        )); // sheepdog trials
        blankE.setItems(FXCollections.observableArrayList(
                "loyal", "intelligent", "quiet", "high-maintenance"
        )); // intelligent
        blankF.setItems(FXCollections.observableArrayList(
                "herding livestock", "fetching fowl", "driving racecars", "pulling sleds"
        )); // herding livestock

        doneButton.setDisable(false);

    }

    /**
     *
     */
    @FXML
    public void calculusClicked() {
        scoreText.setText("0");

        titleText.setText("Calculus");
        bodyText.setText("Calculus is a part of modern _____(a)_____ education. A course in calculus is a gateway " +
                "to other, more advanced courses in mathematics devoted to the study of _____(b)_____ and " +
                "_____(c)_____, broadly called mathematical analysis. Calculus has historically been called \"the " +
                "calculus of _____(d)_____\", or \"infinitesimal calculus\". The term calculus (plural calculi) is " +
                "also used for naming specific methods of _____(e)_____ or notation as well as some _____(f)_____, " +
                "such as propositional calculus, Ricci calculus, calculus of variations, lambda calculus, and " +
                "process calculus.");

        blankA.setItems(FXCollections.observableArrayList(
                "science", "mathematics", "algebra", "statistics"
        )); // mathematics
        blankB.setItems(FXCollections.observableArrayList(
                "functions", "derivatives", "vectors", "lines"
        )); // functions
        blankC.setItems(FXCollections.observableArrayList(
                "integrals", "identities", "limits", "proofs"
        )); // limits
        blankD.setItems(FXCollections.observableArrayList(
                "physics", "space", "everything", "infinitesimals"
        )); // infinitesimals
        blankE.setItems(FXCollections.observableArrayList(
                "calculation", "solving equations", "finding limits", "graphing functions"
        )); // calculation
        blankF.setItems(FXCollections.observableArrayList(
                "theorems", "specialties", "theories", "problems"
        )); // theories

        doneButton.setDisable(false);
    }

    /**
     *
     */
    @FXML
    public void radfordClicked() {
        scoreText.setText("0");

        titleText.setText("Radford University");
        bodyText.setText("Radford University is a _____(a)_____ campus located in a residential area of " +
                "_____(b)_____, Virginia. Nearly all of the 31 administrative, academic, student services, and " +
                "residence halls are located on three _____(c)_____ and a pedestrian thoroughfare in a 76-acre " +
                "area. The university opened a new COBE building (College of Business and Economics) in _____(d)_____. " +
                "In 2014 a new _____(e)_____ opened. A new Center for Sciences opened during the _____(f)_____ " +
                "semester of 2016. The following fall semester, the new CHBS (College of Humanities and " +
                "Behavioral Sciences) Building opened its doors. As of 2016, nearly all dorms at Radford have been " +
                "renovated.");

        blankA.setItems(FXCollections.observableArrayList(
                "157-acre", "840-acre", "601-acre", "204-acre"
        )); // 204-acre
        blankB.setItems(FXCollections.observableArrayList(
                "Radford", "Blacksburg", "Christiansburg", "Roanoke"
        )); // Radford
        blankC.setItems(FXCollections.observableArrayList(
                "courtyards", "quadrangles", "city blocks", "fields"
        )); // quadrangles
        blankD.setItems(FXCollections.observableArrayList(
                "2009", "2010", "2011", "2012"
        )); // 2012
        blankE.setItems(FXCollections.observableArrayList(
                "residence hall", "bus depot", "student fitness center", "dining hall"
        )); // Student Fitness Center
        blankF.setItems(FXCollections.observableArrayList(
                "spring", "Augustmester", "fall", "Maymester"
        )); // spring

        doneButton.setDisable(false);
    }

    /**
     *
     */
    @FXML
    public void doneClicked() {
        int score = 0;
        for (int i = 0; i < 6; i++) {
            if (getCorrectAnswers()[i].equals(getPlayerAnswers()[i])) {
                score++;
            }
        }
        scoreText.setText(Integer.toString(score));
    }

    /**
     *
     * @return
     */
    private String[] getCorrectAnswers() {
        String SFanswers[] = {"City and County", "financial", "46.89", "fourth-most", "884,363", "boroughs"};
        String BCanswers[] = {"herding", "Anglo-Scottish", "obedience", "sheepdog trials", "intelligent", "herding livestock"};
        String CAanswers[] = {"mathematics", "functions", "limits", "infinitesimals", "calculation", "theories"};
        String RUanswers[] = {"204-acre", "Radford", "quadrangles", "2012", "student fitness center", "spring"};

        String currentAnswers[];

        if (titleText.getText().equals("San Francisco")) {
            currentAnswers = SFanswers;
        } else if (titleText.getText().equals("Border Collie")) {
            currentAnswers = BCanswers;
        } else if (titleText.getText().equals("Calculus")) {
            currentAnswers = CAanswers;
        } else {
            currentAnswers = RUanswers;
        }

        return currentAnswers;
    }

    /**
     *
     * @return
     */
    private String[] getPlayerAnswers() {
        String playerAnswers[] = new String[6];

        if (blankA.getSelectionModel().getSelectedItem() != null) {
            playerAnswers[0] = blankA.getSelectionModel().getSelectedItem().toString();
        } else {
            playerAnswers[0] = "unanswered";
        }

        if (blankB.getSelectionModel().getSelectedItem() != null) {
            playerAnswers[1] = blankB.getSelectionModel().getSelectedItem().toString();
        } else {
            playerAnswers[1] = "unanswered";
        }

        if (blankC.getSelectionModel().getSelectedItem() != null) {
            playerAnswers[2] = blankC.getSelectionModel().getSelectedItem().toString();
        } else {
            playerAnswers[2] = "unanswered";
        }

        if (blankD.getSelectionModel().getSelectedItem() != null) {
            playerAnswers[3] = blankD.getSelectionModel().getSelectedItem().toString();
        } else {
            playerAnswers[3] = "unanswered";
        }

        if (blankE.getSelectionModel().getSelectedItem() != null) {
            playerAnswers[4] = blankE.getSelectionModel().getSelectedItem().toString();
        } else {
            playerAnswers[4] = "unanswered";
        }

        if (blankF.getSelectionModel().getSelectedItem() != null) {
            playerAnswers[5] = blankF.getSelectionModel().getSelectedItem().toString();
        } else {
            playerAnswers[5] = "unanswered";
        }

        return playerAnswers;
    }

    /**
     *
     */
    @FXML
    private void resetClicked() {
        reset();
    }

    /**
     *
     */
    private void reset() {
        titleText.setText("");
        bodyText.setText("");
        scoreText.setText("0");

        blankA.getItems().clear();
        blankB.getItems().clear();
        blankC.getItems().clear();
        blankD.getItems().clear();
        blankE.getItems().clear();
        blankF.getItems().clear();

        doneButton.setDisable(true);
    }
}
