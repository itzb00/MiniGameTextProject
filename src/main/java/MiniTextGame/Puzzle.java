package MiniTextGame;

public class Puzzle {

    private String puzzleName;
    private int puzzleRoomID;
    private String puzzleDescription;
    private String puzzleAnswer;
    private boolean solved;
    private int attempts;

    public Puzzle() {

    }

    public String getPuzzleName() {
        return puzzleName;
    }

    public void setPuzzleName(String puzzleName) {
        this.puzzleName = puzzleName;
    }

    public int getPuzzleRoomID() {
        return puzzleRoomID;
    }

    public void setPuzzleRoomID(int puzzleRoomID) {
        this.puzzleRoomID = puzzleRoomID;
    }

    public String getPuzzleDescription() {
        return puzzleDescription;
    }

    public void setPuzzleDescription(String puzzleDescription) {
        this.puzzleDescription = puzzleDescription;
    }

    public String getPuzzleAnswer() {
        return puzzleAnswer;
    }

    public void setPuzzleAnswer(String puzzleAnswer) {
        this.puzzleAnswer = puzzleAnswer;
    }

    public boolean wasSolved() {
        return solved;
    }

    public void setWasSolved(boolean solved) {
        this.solved = solved;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    @Override
    public String toString() {
        return "Puzzle{" +
                "puzzleName='" + puzzleName + '\'' +
                ", puzzleRoomID=" + puzzleRoomID +
                ", puzzleDescription='" + puzzleDescription + '\'' +
                ", puzzleAnswer='" + puzzleAnswer + '\'' +
                ", wasSolved=" + solved +
                ", attempts=" + attempts +
                '}';
    }
}
