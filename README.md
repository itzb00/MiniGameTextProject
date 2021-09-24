# MiniGameTextProject


=======================
IOClass.java
-----------------------
Takes in room data from the file Rooms.txt and runs a simple loop. The loop assigns each item, split by "," into one propety of a room object.
After reaching the end of the line, it creates a room with the desired attributes.
It also creates an array list of Rooms called rooms. Then adds each room to that ArrayList.
=======================

=======================
Puzzle.java
-----------------------
Creates the puzzle Object, which has various properties.
Has typical getters and setters, as well as toString.
=======================

=======================
PuzzleInput.java
-----------------------
We do the same thing that was done in IOClass.java. Runs a loop through puzzles.txt and assigns each split into the puzzle object.
There are fewer attributes for the puzzle, and it should be noted that the puzzle exists within the room, dependent upon it, but the room
does not need a puzzle to exist.
=======================

=======================
Room.java
-----------------------
Creates the rooms that the game consists of. Includes an ArrayList for multiple lines of descriptions, as well as 
a Hashmap which becomes the navigation table. The last 4 splits in the Rooms.txt file are simple integers, which become
the nextRoomID for a given key in the hashmap e.g. map.put("north",1);
Typical getters and setters
=======================



=======================
Main.java
-----------------------
Contains the main program logic, and the main game loop. Starts by setting up game objects such as ArrayList of rooms, ArrayList of puzzles, String choice for user input,
boolean gameFlag to tell the program when to stop, a Scanner, and a commandType to check valid commands. The main method here contains the displayPuzzle and displayCurrentRoom
methods. It also contains the majority of the printing for the user to read, and accepts the user's input through the processChoice() method.
=======================

======================================================================================================================
Rooms.txt, Puzzles.txt
----------------------------------------------------------------------------------------------------------------------
Looks like this:
Rooms.txt
1,Entrance Hall,A towering castle appears as you step into the Entry Hall.,Armored Knights decorate the entire room. You see a few doors.,---,false,4,3,0,2
2,Potion Room,Bubbling gas makes it hard to see very far.,You stumble through some green mist.,---,false,5,1,0,0
3,Dungeon,Cold and leaky and full of rats.,You could swear one of the skeletons turned its head toward you.,---,false,6,0,0,1
4,Grand Balcony,Through stained glass views and freezing air,you can see a huge forest below.,---,false,7,6,1,5
5,Dining Hall,Looks like no food was served here for a while.,Cups are everywhere...some poured out.,---,false,0,4,2,0
6,Observatory,Peering through a nearby telescope,you can see bright wonderful stars.,---,false,0,0,3,4
7,Boss Room,A bat swoops down upon you and turns into a man.,He runs at you. The fight is on!,---,false,0,0,4,0
-----------------------------------------------------------------------------------------------------------------------
Tricky Stairs,1,Which step is the hardest to take?,the first one,false,3
Leaky Cauldron,2,What leaks but can never be plugged?,memory,false,3
Chains and Shackles,3,A chain is only as strong as its...,weakest link,false,3
Mate in Two,4,Which is the only chess piece that can jump over others?,knight,false,3
Feast or Famine,5,Which fruit is yellow and sour?,lemon,false,3
Shining Stars,6,Whats the galaxy nearest to us called?,andromeda,false,3
Final Rush,7,What are animals who thrive at night called?,nocturnal,false,3
========================================================================================================================


This project is a work in progress as of 22 September 2021
--Anthony Morse









