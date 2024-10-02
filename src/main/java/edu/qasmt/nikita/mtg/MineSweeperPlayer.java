package edu.qasmt.nikita.mtg;

import java.util.Scanner;

public class MineSweeperPlayer {
    private static MineSweeperPlayer instance;
    private int hintsUsed = 0;
    private int squaresDug = 0;
    private int moves = 0;
    private int flagsUsed = 0;
    private int gameover = 0;

    private MineSweeperPlayer() {
        reset();
    } // sin

    public static MineSweeperPlayer getInstance() {
        if (instance == null) {
            instance = new MineSweeperPlayer();
        }
        return instance;
    } // gle

    public void reset() {
        hintsUsed = 0;
        squaresDug = 0;
        moves = 0;
        flagsUsed = 0;
        gameover = 0;
    } // ton

    public int[] getInput(Scanner sc, int[] size) {
        System.out.print("> ");
        String rawInput = sc.nextLine().strip().toLowerCase();

        try {
            if (Character.isDigit(rawInput.charAt(0))) {
                String[] newInput = rawInput.split(" ");
                int[] n = {Integer.parseInt(newInput[0]), Integer.parseInt(newInput[1])};
                if (n[0] < 0 || n[1] < 0 || n[0] >= size[0] || n[1] >= size[1]) {
                    System.out.println("Please enter a coordinate within the playing field.");
                    return null;
                }
                return new int[] {Integer.parseInt(newInput[0]), Integer.parseInt(newInput[1])};
            } else if (rawInput.charAt(0) == 'f') {
                String[] newInput = rawInput.split(" ");
                int[] n = {Integer.parseInt(newInput[1]), Integer.parseInt(newInput[2]), 0};
                if (n[0] < 0 || n[1] < 0 || n[0] >= size[0] || n[1] >= size[1]) {
                    System.out .println("Please enter a coordinate within the playing field.");
                    return null;
                }
                return n;
            } else if (rawInput.startsWith("hint")) {
                return new int[] {0};
            } else if (rawInput.startsWith("quit")) {
                return new int[]{};
            } else {
                System.out.println("Invalid input.");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Invalid input.");
            return null;
        }    }

    public int getHintsUsed() {
        return hintsUsed;
    }

    public void useHint() {
        hintsUsed += 1;
    }

    public int getSquaresDug() {
        return squaresDug;
    }

    public void dugSquare() {
        squaresDug += 1;
    }

    public int getMoves() {
        return moves;
    }

    public void addMove() {
        moves += 1;
    }

    public int getFlagsUsed() {
        return flagsUsed;
    }

    public void addFlag() {
        flagsUsed += 1;
    }

    public void takeFlag() {
        flagsUsed -= 1;
    }

    public int getGameover() {
        return gameover;
    }

    public void endGame(int n) {
        gameover = n;
    }
}
