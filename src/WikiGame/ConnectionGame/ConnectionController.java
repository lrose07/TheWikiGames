package WikiGame.ConnectionGame;

import WikiGame.ApplicationController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.util.ArrayList;

/**
 * Controller class for the Connection mini-game
 *
 * @author Lauren Rose
 * @version 0.1.2
 */
public class ConnectionController {

    private int selected;
    private String category = "";

    private ArrayList<Puzzle> techPuzzles;
    private ArrayList<Puzzle> animalPuzzles;
    private ArrayList<Puzzle> collegePuzzles;
    private ArrayList<Puzzle> carPuzzles;
    private ArrayList<Puzzle> instrumentPuzzles;

    private Puzzle currentPuzzle;

    private boolean[] puzzlesAttempted;
    private int escapeCount;

    private int playerScoreValue;
    private int puzzleCountValue;

    private String lastCat;

    @FXML
    private Text startPageText;
    @FXML
    private Text endPageText;
    @FXML
    private Text playerScore;
    @FXML
    private Text totalTried;
    @FXML
    private Text categoryText;
    @FXML
    private Text correctBoolLabel;
    @FXML
    private Text missingLinkText;

    @FXML
    private Button optionOne;
    @FXML
    private Button optionTwo;
    @FXML
    private Button optionThree;
    @FXML
    private Button optionFour;
    @FXML
    private Button optionFive;

    @FXML
    private Button tryAnother;
    @FXML
    private Button newCategory;

    @FXML
    private Button endGameNewCat;
    @FXML
    private Button trySameCat;

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
     * Gets a new puzzle from the same category
     */
    @FXML
    private void newPuzzle() {

        switch (category) {
            case "Technology":
                updateTechCat();
                break;
            case "Domestic Animals":
                updateAnimalCat();
                break;
            case "Virginia Colleges":
                updateCollegeCat();
                break;
            case "German Cars":
                updateCarCat();
                break;
            default:
                updateInstrumentCat();
        }

        if (currentPuzzle != null) {
            enableOptionButtons();
        }
        tryAnother.setDisable(true);
        correctBoolLabel.setText("");
    }

    /**
     * Button handler for new category button
     */
    @FXML
    private void newCategoryClicked() {
        endGameNewCat.setVisible(false);
        trySameCat.setVisible(false);
        reset();
    }

    /**
     * Button handler for go home button
     */
    @FXML
    private void goBackClicked() {
        reset();
        parent.goBack();
    }

    /**
     * Button handler for try again button
     */
    @FXML
    private void trySameCat() {
        trySameCat.setVisible(false);
        endGameNewCat.setVisible(false);

        resetScores();

        enableOptionButtons();

        category = lastCat;

        switch (lastCat) {
            case "Technology":
                runTechCat();
                break;
            case "Domestic Animals":
                runAnimalCat();
                break;
            case "Virginia Colleges":
                runCollegeCat();
                break;
            case "German Cars":
                runCarCat();
                break;
            default:
                runInstrumentCat();
        }
    }

    /**
     * Resets scene and all values
     */
    private void reset() {
        lastCat = category;
        category = "";
        categoryText.setText("");

        optionOne.setText("Technology");
        optionTwo.setText("Domestic Animals");
        optionThree.setText("Virginia Colleges");
        optionFour.setText("German Cars");
        optionFive.setText("Musical Instruments");

        startPageText.setText("Choose a category ->");
        endPageText.setText("");
        missingLinkText.setText("");



        playerScore.setText("0");
        totalTried.setText("0");

        correctBoolLabel.setText("");

        enableOptionButtons();
        disableLowerButtons();

        try {
            resetPuzzlesAttemptedList();
        } catch (NullPointerException e) { // correct behavior
            System.out.println("User left game without making a selection.");
        }

        endGameNewCat.setVisible(false);
        trySameCat.setVisible(false);
    }

    /**
     * Resets scores
     */
    private void resetScores() {
        playerScoreValue = 0;
        puzzleCountValue = 0;
    }

    /**
     * Handles the case of the option 1 button
     */
    @FXML
    private void optionOneSelected() {
        enableLowerButtons();
        if (!category.equals("")) {
            selected = 1;
            checkIfCorrect();
            disableOptionButtons();
        } else {
            category = "Technology";
            runTechCat();
            tryAnother.setDisable(true);

            resetScores();
        }
    }

    /**
     * Handles the case of the option 2 button
     */
    @FXML
    private void optionTwoSelected() {
        enableLowerButtons();
        if (!category.equals("")) {
            selected = 2;
            checkIfCorrect();
            disableOptionButtons();
        } else {
            category = "Domestic Animals";
            runAnimalCat();
            tryAnother.setDisable(true);

            resetScores();
        }
    }

    /**
     * Handles the case of the option 3 button
     */
    @FXML
    private void optionThreeSelected() {
        enableLowerButtons();
        if (!category.equals("")) {
            selected = 3;
            checkIfCorrect();
            disableOptionButtons();
        } else {
            category = "Virginia Colleges";
            runCollegeCat();
            tryAnother.setDisable(true);

            resetScores();
        }
    }

    /**
     * Handles the case of the option 4 button
     */
    @FXML
    private void optionFourSelected() {
        enableLowerButtons();
        if (!category.equals("")) {
            selected = 4;
            checkIfCorrect();
            disableOptionButtons();
        } else {
            category = "German Cars";
            runCarCat();
            tryAnother.setDisable(true);

            resetScores();
        }
    }

    /**
     * Handles the case of the option 5 button
     */
    @FXML
    private void optionFiveSelected() {
        enableLowerButtons();
        if (!category.equals("")) {
            selected = 5;
            checkIfCorrect();
            disableOptionButtons();
        } else {
            category = "Musical Instruments";
            runInstrumentCat();
            tryAnother.setDisable(true);

            resetScores();
        }
    }

    /**
     * Checks if the selected answer is the correct answer
     */
    private void checkIfCorrect() {
        puzzleCountValue++;
        totalTried.setText(Integer.toString(puzzleCountValue));

        if (currentPuzzle.getCorrectOption() == selected) {
            playerScoreValue++;
            playerScore.setText(Integer.toString(playerScoreValue));

            correctBoolLabel.setText("Correct!");
            correctBoolLabel.setFill(Color.GREEN);
        } else {
            correctBoolLabel.setText("Wrong!");
            correctBoolLabel.setFill(Color.RED);
        }
    }

    /**
     * Disables option buttons
     */
    private void disableOptionButtons() {
        optionOne.setDisable(true);
        optionTwo.setDisable(true);
        optionThree.setDisable(true);
        optionFour.setDisable(true);
        optionFive.setDisable(true);
    }

    /**
     * Disables buttons at the bottom of screen
     */
    private void disableLowerButtons() {
        tryAnother.setDisable(true);
        newCategory.setDisable(true);
    }

    /**
     * Enables option buttons
     */
    private void enableOptionButtons() {
        optionOne.setDisable(false);
        optionTwo.setDisable(false);
        optionThree.setDisable(false);
        optionFour.setDisable(false);
        optionFive.setDisable(false);
    }

    /**
     * Enables buttons at bottom of the screen
     */
    private void enableLowerButtons() {
        tryAnother.setDisable(false);
        newCategory.setDisable(false);
    }

    /**
     * Runs the Technology category
     */
    private void runTechCat() {
        createTechPuzzles();
        categoryText.setText("Technology");
        puzzlesAttempted = new boolean[techPuzzles.size()];

        currentPuzzle = getPuzzle("Technology");

        if (currentPuzzle == null) {
            reset();
        } else {
            setUpScene(currentPuzzle);
        }
    }

    /**
     * Updates the puzzle within the Tech category
     */
    private void updateTechCat() {
        currentPuzzle = getPuzzle("Technology");
        update();
    }

    /**
     * Runs the Domestic Animals category
     */
    private void runAnimalCat() {
        createAnimalPuzzles();
        categoryText.setText("Domestic Animals");
        puzzlesAttempted = new boolean[animalPuzzles.size()];

        currentPuzzle = getPuzzle("Domestic Animals");

        setUpScene(currentPuzzle);
    }

    /**
     * Updates the puzzle within the Animal category
     */
    private void updateAnimalCat() {
        currentPuzzle = getPuzzle("Domestic Animals");
        update();
    }

    /**
     * Runs the VA Colleges category
     */
    private void runCollegeCat() {
        createCollegesPuzzles();
        categoryText.setText("Virginia Colleges");
        puzzlesAttempted = new boolean[collegePuzzles.size()];

        currentPuzzle = getPuzzle("Virginia Colleges");

        setUpScene(currentPuzzle);
    }

    /**
     * Updates the puzzle within the Colleges category
     */
    private void updateCollegeCat() {
        currentPuzzle = getPuzzle("Virginia Colleges");
        update();
    }

    /**
     * Runs the German Cars category
     */
    private void runCarCat() {
        createCarsPuzzles();
        categoryText.setText("German Cars");
        puzzlesAttempted = new boolean[carPuzzles.size()];

        currentPuzzle = getPuzzle("German Cars");

        setUpScene(currentPuzzle);
    }

    /**
     * Updates the puzzle within the Cars category
     */
    private void updateCarCat() {
        currentPuzzle = getPuzzle("German Cars");
        update();
    }

    /**
     * Runs the Instrument category
     */
    private void runInstrumentCat() {
        createInstrumentsPuzzles();
        categoryText.setText("Musical Instruments");
        puzzlesAttempted = new boolean[instrumentPuzzles.size()];

        currentPuzzle = getPuzzle("Musical Instruments");

        setUpScene(currentPuzzle);
    }

    /**
     * Updates the puzzle within the Instruments category
     */
    private void updateInstrumentCat() {
        currentPuzzle = getPuzzle("Musical Instruments");
        update();
    }

    /**
     * Checks for end of category case
     */
    private void update() {
        if (currentPuzzle == null) {
            handleCatEndCase();
        } else {
            setUpScene(currentPuzzle);
        }
    }

    /**
     * Handles end of category case
     */
    private void handleCatEndCase() {
        reset();

        startPageText.setText("You scored " + playerScoreValue + " out of " + puzzleCountValue + "!");
        endGameNewCat.setVisible(true);
        trySameCat.setVisible(true);

        disableOptionButtons();
    }

    /**
     * Sets up the display for the given puzzle
     * @param p current Puzzle being played
     */
    private void setUpScene(Puzzle p) {
        startPageText.setText(p.getStartPage());
        endPageText.setText(p.getEndPage());
        missingLinkText.setText("______?______");

        optionOne.setText(p.getOptionsList()[0]);
        optionTwo.setText(p.getOptionsList()[1]);
        optionThree.setText(p.getOptionsList()[2]);
        optionFour.setText(p.getOptionsList()[3]);
        optionFive.setText(p.getOptionsList()[4]);
    }

    /**
     * Gets a puzzle from the current category
     * @param cat current gameplay category
     * @return randomly selected puzzle from within category
     */
    private Puzzle getPuzzle(String cat) {

        switch (cat) {
            case "Technology":
                return chooseRandom(techPuzzles);
            case "Domestic Animals":
                return chooseRandom(animalPuzzles);
            case "Virginia Colleges":
                return chooseRandom(collegePuzzles);
            case "German Cars":
                return chooseRandom(carPuzzles);
            default:
                return chooseRandom(instrumentPuzzles);
        }
    }

    /**
     * Chooses a random puzzle from the category
     * @param list list of puzzles
     * @return a single puzzle from the list
     */
    private Puzzle chooseRandom(ArrayList<Puzzle> list) {
        double index;
        int indexInt;

        do {
            index = Math.random()*(list.size());
            indexInt = (int)index;
        }
        while ((!isValid(indexInt, puzzlesAttempted)) && (escapeCount < puzzlesAttempted.length));

        if (escapeCount == puzzlesAttempted.length) {
            return null;
        } else {
            puzzlesAttempted[indexInt] = true;
            escapeCount++;
            return list.get(indexInt);
        }
    }

    /**
     * Resets the tagalong list of puzzles attempted
     */
    private void resetPuzzlesAttemptedList() {
        for (int i = 0; i < puzzlesAttempted.length; i++) {
            puzzlesAttempted[i] = false;
        }

        escapeCount = 0;
    }

    /**
     * Checks if a puzzle has been attempted this game or not
     * @param num number selected randomly by calling method
     * @param bools list of boolean values that corresponds to list of puzzles
     * @return if the selected puzzle has been played or not
     */
    private boolean isValid(int num, boolean[] bools) {
        boolean valid = true;
        if (bools[num]) {
            valid = false;
        }
        return valid;
    }

    /**
     * Creates the puzzles for the Tech category
     */
    private void createTechPuzzles() {
        // Tech category
        techPuzzles = new ArrayList<>();

        String[] optionsGo = {"Stanford University",
                "Sergey Brin", "Buffy the Vampire Slayer",
                "People's Republic of China", "London"};
        Puzzle google = new Puzzle("Google", "California State University-Sacramento", optionsGo, 3);
        techPuzzles.add(google);

        String[] optionsLe = {"European Commission", "portmanteau",
                "network attached storage", "Development Bank of Japan", "malware"};
        Puzzle lenovo = new Puzzle("Lenovo", "gerrymandering", optionsLe, 2);
        techPuzzles.add(lenovo);

        String[] optionsSn = {"McDonald's", "social media", "TechCrunch", "The Wall Street Journal", "monetization"};
        Puzzle snapchat = new Puzzle("SnapChat", "bioplastics", optionsSn, 1);
        techPuzzles.add(snapchat);

        String[] optionsJa = {"syntax", "computer architecture", "GNU Classpath",
                "game consoles", "pointer arithmetic"};
        Puzzle java = new Puzzle("Java (programming language)", "JavaScript", optionsJa, 5);
        techPuzzles.add(java);

        String[] optionsBe = {"videotape", "chrominance", "RadioShack", "wow", "Internet auctions"};
        Puzzle betemax = new Puzzle("Betamax", "digital signal processing", optionsBe, 4);
        techPuzzles.add(betemax);

        String[] optionsZe = {"Famicon Disk System", "recorder", "Tinker Bell", "Super NES", "3D game engine"};
        Puzzle zelda = new Puzzle("The Legend of Zelda", "batteries", optionsZe, 1);
        techPuzzles.add(zelda);

        String[] optionsSa = {"Texas", "aircraft", "Seagate", "theme park", "weapons technology"};
        Puzzle samsung = new Puzzle("Samsung", "Big Dipper", optionsSa, 4);
        techPuzzles.add(samsung);

        String[] optionsLi = {"YouTube", "solid state drives", "workstations", "EVGA", "access points"};
        Puzzle linusTech = new Puzzle("Linus Sebastian (LTT)", "Garbage collection", optionsLi, 2);
        techPuzzles.add(linusTech);

        String[] optionsHt = {"meta data", "heading", "structured documents", "MathML", "\"Hello, World!\" program"};
        Puzzle html = new Puzzle("HTML", "traffic analysis", optionsHt, 1);
        techPuzzles.add(html);

        String[] optionsDo = {"social media", "cryptocurrency wallet", "Danika Patrick",
                "Sochi Winter Olympics", "Reddit"};
        Puzzle dogecoin = new Puzzle("Dogecoin", "The Simpsons", optionsDo, 3);
        techPuzzles.add(dogecoin);
    }

    /**
     * Creates the puzzles for the Animal category
     */
    private void createAnimalPuzzles() {
        // Domestic animals
        animalPuzzles = new ArrayList<>();

        String[] optionsBa = {"Central African Republic", "traditional religion", "striped mice",
                "Philadelphia Zoo", "oviparous"};
        Puzzle ballPython = new Puzzle("Ball python", "human sacrifice", optionsBa, 2);
        animalPuzzles.add(ballPython);

        String[] optionGe = {"sable", "police", "Poodles", "Batman", "anti-German sentiment"};
        Puzzle germanS = new Puzzle("German Shepherd", "Sherlock Holmes", optionGe, 4);
        animalPuzzles.add(germanS);

        String[] optionsVe = {"royal charter", "domesticated", "livestock", "Boston", "Twelfth Dynasty of Egypt"};
        Puzzle vetMed = new Puzzle("Veterinary medicine", "British Broadcasting Corporation",
                optionsVe, 1);
        animalPuzzles.add(vetMed);

        String[] optionsCa = {"dexter", "hippopotamuses", "neatsfoot oil", "archaic", "electrolyte"};
        Puzzle cattle = new Puzzle("Cattle", "baseball gloves", optionsCa, 3);
        animalPuzzles.add(cattle);

        String[] optionsDo = {"Coronado, California", "maintenance", "ASPCA", "Great Dane", "Dog Fancy magazine"};
        Puzzle dogPark = new Puzzle("Dog park", "Köppen climate classification", optionsDo, 1);
        animalPuzzles.add(dogPark);

        String[] optionsDr = {"Olympic Games", "Portuguese", "Pirouette", "impulsion", "Renaissance"};
        Puzzle dressage = new Puzzle("Dressage", "moral philosophy", optionsDr, 5);
        animalPuzzles.add(dressage);
    }

    /**
     * Creates the puzzles for the College category
     */
    private void createCollegesPuzzles() {
        // Virginia colleges
        collegePuzzles = new ArrayList<>();

        String[] optionsRa = {"Little River", "Interstate 81", "Sigma Gamma Rho", "Tennis", "doctorates"};
        Puzzle radford = new Puzzle("Radford University", "Ontario", optionsRa, 2);
        collegePuzzles.add(radford);

        String[] optionsUVA = {"Northern Virginia", "James Monroe", "Edgar Allen Poe", "Reddit", "human brain"};
        Puzzle uniVA = new Puzzle("University of Virginia", "crowd psychology", optionsUVA, 4);
        collegePuzzles.add(uniVA);

        String[] optionsGe = {"Rapidan River", "Associate's degrees", "2011 Virginia earthquake",
                "Fredericksburg", "National League for Nursing Accrediting Commission"};
        Puzzle germanna = new Puzzle("Germanna Community College", "Verizon Wireless", optionsGe, 3);
        collegePuzzles.add(germanna);
    }

    /**
     * Creates the puzzles for the Cars category
     */
    private void createCarsPuzzles() {
        // German cars
        carPuzzles = new ArrayList<>();

        String[] optionsPo = {"rear-engined", "kilowatts", "transmission", "Bugatti", "sport utility vehicle"};
        Puzzle porsche = new Puzzle("Porsche", "mechanical advantage", optionsPo, 3);
        carPuzzles.add(porsche);

        String[] optionsBMW = {"slang", "electronic stability control", "Jeep",
                "series production", "Rolls-Royce Phantom"};
        Puzzle BMW = new Puzzle("BMW", "Sussex", optionsBMW, 5);
        carPuzzles.add(BMW);

        String[] optionsMa = {"electronic control unit", "fuzzy logic", "steering wheel",
                "torque converter", "redline"};
        Puzzle manumatic = new Puzzle("Manumatic", "control theory", optionsMa, 2);
        carPuzzles.add(manumatic);

    }

    /**
     * Creates the puzzles for the Instruments category
     */
    private void createInstrumentsPuzzles() {
        // Musical instruments
        instrumentPuzzles = new ArrayList<>();

        String[] optionsVi = {"acoustic", "equestrian", "Venice", "rock music", "Baroque"};
        Puzzle violin = new Puzzle("Violin", "Cabaret", optionsVi, 4);
        instrumentPuzzles.add(violin);

        String[] optionsCl = {"marching bands", "air pressure", "harmonics", "vibrato", "jazz"};
        Puzzle clarinet = new Puzzle("Clarinet", "college", optionsCl, 1);
        instrumentPuzzles.add(clarinet);

        String[] optionsDr = {"rhythm section", "backup vocals", "musical theater", "cowbells", "big band swing"};
        Puzzle drums = new Puzzle("Drums", "Fall Out Boy", optionsDr, 2);
        instrumentPuzzles.add(drums);
    }
}