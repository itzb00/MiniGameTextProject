package MiniTextGame;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PuzzleInput {

    private static ArrayList<Puzzle> puzzles = new ArrayList<>();
    public static ArrayList <Puzzle> getPuzzles() {
        try {

            List<String> lines = FileUtils.readLines(new File("Puzzles.txt"), "UTF-8");
            System.out.println(lines);

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                Puzzle puzzle = new Puzzle();
                String[] puzzleData = line.split(",");
                //split by comma
                int j = 0;
                puzzle.setPuzzleName(puzzleData[j]);
                j++;
                puzzle.setPuzzleRoomID(Integer.parseInt(puzzleData[j]));
                j++;
                puzzle.setPuzzleDescription(puzzleData[j]);
                j++;
                puzzle.setPuzzleAnswer(puzzleData[j]);
                j++;
                puzzle.setWasSolved(Boolean.parseBoolean(puzzleData[j]));
                j++;
                puzzle.setAttempts(Integer.parseInt(puzzleData[j]));
                puzzles.add(puzzle);
            }
        } catch(Exception e) {
            System.out.println("Puzzle file not found");
            e.printStackTrace();
        }
        return puzzles;
    }
}
