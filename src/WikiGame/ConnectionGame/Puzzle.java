package WikiGame.ConnectionGame;

/**
 * Puzzle objects have a start page, end page, list of options, and the index of the correct object
 *
 * @author Lauren Rose
 * @version 0.1.2
 */
public class Puzzle {

    private String startPage;
    private String endPage;
    private String[] optionsList;
    private int correctOption;

    /**
     * Puzzle constructor
     * @param start starting page
     * @param end ending page
     * @param options list of options
     * @param correct index of correct option
     */
    public Puzzle(String start, String end, String[] options, int correct) {
        this.startPage = start;
        this.endPage = end;
        this.optionsList = options;
        this.correctOption = correct;
    }

    /**
     * Gets start page text
     * @return starting page
     */
    protected String getStartPage() {
        return startPage;
    }

    /**
     * Get end page text
     * @return end page text
     */
    protected String getEndPage() {
        return endPage;
    }

    /**
     * Gets options list as an array
     * @return list of options
     */
    protected String[] getOptionsList() {
        return optionsList;
    }

    /**
     * Gets the index of the correct option
     * @return index of the correct option
     */
    protected int getCorrectOption() {
        return correctOption;
    }
}
