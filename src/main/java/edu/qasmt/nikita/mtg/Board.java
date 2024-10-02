package edu.qasmt.nikita.mtg;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Board {
    private Cell[][] cells;
    private final int[] size = new int[2];
    private int[][] mineLocs;
    private int mines;
    private final Random rand = new Random();
    MineSweeperPlayer player = MineSweeperPlayer.getInstance();

    public void display() {
        System.out.print(" min ");
        for (int i = 0; i < size[1]*3-1; i++) {
            System.out.print('~');
        }
        System.out.println(" esw");
        for (int i = 0; i < size[0]; i++) {
            System.out.print(i);
            if (i > 9) {
                System.out.print(" [");
            } else {
                System.out.print("  [");
            }
            for (int j = 0; j < size[1]; j++) {
                System.out.print("  ");
                if (cells[i][j].getIsRevealed()) {
                    if (cells[i][j].getAdjacentMines() != 0) {
                        System.out.print(cells[i][j].getAdjacentMines());
                    } else {
                        System.out.print('-');
                    }
                } else if (cells[i][j].getIsFlagged()) {
                    System.out.print('F');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.print("  ]");
            if (i == 0) {
                System.out.print(" Squares dug: " + player.getSquaresDug());
            } else if (i == 1) {
                System.out.print(" Flags left: " + (mines-player.getFlagsUsed()));
            } else if (i == 2) {
                System.out.print(" Hints used: " + player.getHintsUsed());
            } else if (i == 3) {
                System.out.print(" Moves: " + player.getMoves());
            }
            System.out.println();

        }
        System.out.print(" eep ");
        for (int i = 0; i < size[1]*3; i++) {
            System.out.print('~');
        }
        System.out.print(" er\n      ");
        for (int i = 0; i < size[1]; i++) {
            System.out.print(i);
            if (i > 9) {
                System.out.print(" ");
            } else {
                System.out.print("  ");
            }
        }
    }

    public String setDifficulty(Scanner sc) {
        String difficulty;
        label:
        while (true) {
            System.out.print("> ");
            difficulty = sc.nextLine();
            switch (difficulty) {
                case "easy":
                case "1":
                    size[0] = 8;
                    size[1] = 8;
                    mines = 10;
                    break label;
                case "medium":
                case "2":
                    size[0] = 16;
                    size[1] = 16;
                    mines = 40;
                    break label;
                case "hard":
                case "3":
                    size[0] = 20;
                    size[1] = 24;
                    mines = 99;
                    break label;
                case "quit":
                    System.out.println("\nQuitting to menu...\n");
                    return "quit";
                default:
                    System.out.println("Please enter '1', 'easy', '2', 'medium', or '3', 'hard'.");
                    break;
            }
        }
        mineLocs = new int[mines][2];
        cells = new Cell[size[0]][size[1]];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
            }
        }
        return difficulty.toLowerCase();
    }

    public void generateMines(int[] start) {

        int count = 0;


        int[][] blocked = {{start[0]-1, start[1]-1}, {start[0]-1, start[1]}, {start[0]-1, start[1]+1}, {start[0], start[1]-1}, {start[0], start[1]}, {start[0], start[1]+1}, {start[0]+1, start[1]-1}, {start[0]+1, start[1]}, {start[0]+1, start[1]+1}};

        label:
        while (count < mines) {
            int x = rand.nextInt(size[0]);
            int y = rand.nextInt(size[1]);

            for (int[] b : blocked) {
                if (Arrays.equals(b, new int[]{x, y})) {
                    continue label;
                }
            }
            for (int[] b : mineLocs) {
                if (Arrays.equals(b, new int[]{x, y})) {
                    continue label;
                }
            }

            mineLocs[count] = new int[]{x, y};
            cells[x][y].setMine();
            count += 1;
        }
    }

    public void calculateAdjacents() {
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                int[][] toCheck = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

                int count = 0;
                for (int[] c : toCheck) {
                    if (i+c[0] >= 0 && j+c[1] >= 0 && i+c[0] < size[0] && j+c[1] < size[1]) {
                        if (cells[i+c[0]][j+c[1]].getIsMine()) {
                            count += 1;
                        }
                    }
                }

                cells[i][j].setAdjacentMines(count);

            }
        }
    }

    public boolean dig(int[] centre) {
        if (cells[centre[0]][centre[1]].getIsRevealed()) {
            System.out.println("This square has already been dug.");
            return false;
        }
        if (cells[centre[0]][centre[1]].getIsFlagged()) {
            System.out.println("You cannot dig a square that is flagged.");
            return false;
        }
        if (cells[centre[0]][centre[1]].getIsMine()) {
            player.endGame(2);
            return false;
        }

        player.dugSquare();
        cells[centre[0]][centre[1]].reveal();
        if (cells[centre[0]][centre[1]].getAdjacentMines() != 0) {
            return true;
        }

        int[][] toCheck = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int[] xy : toCheck) {
            if (xy[0] != 0 || xy[1] != 0) {
                if (centre[0]+xy[0] >= 0 && centre[1]+xy[1] >= 0 && centre[0]+xy[0] < size[0] && centre[1]+xy[1] < size[1]) {
                    if (!cells[centre[0]+xy[0]][centre[1]+xy[1]].getIsRevealed()) {
                        dig(new int[]{centre[0] + xy[0], centre[1] + xy[1]});
                    }
                }
            }
        }
        return true;
    }

    public void getHint(Scanner sc) {
        String[] rawInput;
        int[] newInput = new int[2];
        label:
        while (true) {
            System.out.println("Please input a square to get a hint:");
            System.out.print("> ");
            try {
                rawInput = sc.nextLine().split(" ");
                newInput = new int[]{Integer.parseInt(rawInput[0]), Integer.parseInt(rawInput[1])};
                if (newInput[0] >= 0 && newInput[1] >= 0 && newInput[0] < size[0] && newInput[1] < size[1]) {
                    if (!cells[newInput[0]][newInput[1]].getIsRevealed()) {
                        break label;
                    } else {
                        System.out.println("This cell is already revealed!");
                    }
                } else {
                    System.out.println("Invalid coordinate.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
                continue;
            }
        }
        if (cells[newInput[0]][newInput[1]].getIsMine()) {
            System.out.println(newInput[0] + " " + newInput[1] + " is a mine!");
        } else {
            System.out.println(newInput[0] + " " + newInput[1] + " is safe.");
        }
    }

    public boolean flagCell(int x, int y) {
        if (cells[x][y].getIsRevealed()) {
            System.out.println("You cannot flag a square that has been dug.");
            return false;
        }
        if (player.getSquaresDug() == 0) {
            System.out.println("Please dig a square before you begin placing flags.");
            return false;
        }
        if (mines-player.getFlagsUsed() == 0) {
            System.out.println("No flags remaining!");
            return false;
        }
        cells[x][y].changeFlag();
        return true;
    }

    public int[] getSize() {
        return size;
    }

    public int getMines() {
        return mines;
    }
}
