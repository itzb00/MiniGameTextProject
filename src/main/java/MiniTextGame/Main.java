package MiniTextGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * Anthony Morse
 * Rahaf Barakat ITEC3960
 * MiniText Adventure Game Part 1
 * September 20 2021
 */

public class Main {

    //setting up the game objects
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static ArrayList<Puzzle> puzzles;
    public static Room currentRoom;
    public static boolean gameFlag = true;
    public static Scanner input = new Scanner(System.in);
    public static String choice;
    public static int nextRoomID;
    public static int commandType;
    //command type 1 is valid, command type 0 is invalid

    public static void main(String[] args) throws IOException {
        //getting rooms/puzzles from IO classes
        rooms = IOClass.getRooms();
        puzzles = PuzzleInput.getPuzzles();
        for (int i = 0; i < puzzles.size(); i++) {
            Room room = rooms.get(puzzles.get(i).getPuzzleRoomID() - 1);
            room.setPuzzle(puzzles.get(i));
        }
        //System.out.println(puzzles);
        //System.out.println(rooms);
        System.out.println("Welcome to Castle Climb!");
        currentRoom = rooms.get(0);
        displayCurrentRoom();
        displayPuzzle();

        //main game loop
        do {
            System.out.println("Which way do you want to go? [n,s,e,w, or quit]");
            System.out.print(">");
            choice = input.nextLine();
            //user's input
            processChoice();
            if (!gameFlag) {
                break;
            }
            if (commandType == 1) {
                if (nextRoomID != 0) {
                    //updating the current room
                    currentRoom = rooms.get(nextRoomID - 1);
                    displayCurrentRoom();
                    displayPuzzle();
                } else {
                    System.out.println("You can't go that way.");
                }
            } else {
                System.out.println("Invalid command");
            }
        } while (gameFlag);
        System.out.println("Game was ended. Thanks for playing!");
    }

    public static void displayCurrentRoom() {
        //keeping track of visited rooms
        if (currentRoom.getWasVisited()) {
            System.out.println("You've been here before.");
        } else {
            currentRoom.setWasVisited(true);
        }
        System.out.println(currentRoom.getRoomName());
        for (int i = 0; i < currentRoom.getDescriptions().size(); i++) {
            System.out.println(currentRoom.getDescriptions().get(i));
        }
    }

    public static void displayPuzzle() {
        //if it HASN'T been solved yet
        if (!currentRoom.getPuzzle().wasSolved()) {
            System.out.println("There is a puzzle in this room");
            //print the name and description
            System.out.println(currentRoom.getPuzzle().getPuzzleName());
            System.out.println(currentRoom.getPuzzle().getPuzzleDescription());
            int attempts = currentRoom.getPuzzle().getAttempts();

            do {
                System.out.print(">");
                String answer = input.nextLine();
                answer = answer.toLowerCase();
                //check user's answer
                if (answer.compareTo(currentRoom.getPuzzle().getPuzzleAnswer()) == 0) {
                    System.out.println("Correct!");
                    currentRoom.getPuzzle().setWasSolved(true);
                    //if it matches, correct and set solved to true
                    return;
                }
                attempts--;
                if(attempts > 0) {
                    System.out.println("Incorrect. You have " + attempts + " attempts remaining.");
                } else {
                    break;
                }
            } while (attempts > 0);
                System.out.println("You are out of attempts.");
                //option to display correct answer upon failure
                //System.out.println("That's not it... too bad. The correct answer was " + currentRoom.getPuzzle().getPuzzleAnswer() + ".");
            }
        }


    public static void processChoice() {
        //normalizing input
        choice = choice.toLowerCase();
        //make the new map for current room. then check if statements
        Map <String,Integer> nav = currentRoom.getNavTable();
        if (choice.compareTo("north") == 0 || choice.compareTo("n") == 0) {
            nextRoomID = nav.get("north");
            commandType = 1;
        } else
        if (choice.compareTo("east") == 0 || choice.compareTo("e") == 0) {
            nextRoomID = nav.get("east");
            commandType = 1;
        } else
        if (choice.compareTo("west") == 0 || choice.compareTo("w") == 0) {
            nextRoomID = nav.get("west");
            commandType = 1;
        } else
        if (choice.compareTo("south") == 0 || choice.compareTo("s") == 0) {
            nextRoomID = nav.get("south");
            commandType = 1;
        } else
        if (choice.compareTo("quit") == 0 || choice.compareTo("q") == 0) {
            gameFlag = false;
            commandType = 1;
        }
        else {
            commandType = 0;
        }
    }
}

