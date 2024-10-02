package edu.qasmt.nikita.mtg;

import java.util.Scanner;

public class  mineSweeper {
    public void mineSweeperGame(Scanner sc, Currency currency) {

        System.out.println("\nWelcome to the game suite!\n");
        System.out.println("Here, you can play games to spend and earn money!");
        System.out.println("You currently have " + currency.getMoney() + " dollars.");
        System.out.println("Type 'quit' to quit.");
        System.out.println("Type 'play' to play mine sweeper.");

        label:
        while (true) {
            System.out.print("> ");
            String input = sc.nextLine().strip().toLowerCase();
            switch (input) {
                case "play": case "minesweeper":
                    System.out.println("\nEntering Minesweeper...\n\n--------------------------------------------------\n");
                    minesweeper(sc);
                    break;
                case "quit":
                    System.out.println("\nThank you for playing!");
                    break label;
                default:
                    System.out.println("\nInvalid input.\nPlease enter the number or name of a game.\n");
            }
        }


    }

    public static void minesweeper(Scanner sc) {
        Currency currency = Currency.getInstance();
        Board board = new Board();
        MineSweeperPlayer player = MineSweeperPlayer.getInstance();
        player.reset();

        System.out.println("Welcome to minesweeper!\n");
        System.out.println("Please choose a difficulty.");
        System.out.println(" 1. Easy");
        System.out.println(" 2. Medium");
        System.out.println(" 3. Hard\n");
        String difficulty = board.setDifficulty(sc);
        if (difficulty.equals("quit")) {
            return;
        }

        System.out.println("\nYou have chosen the " + difficulty + " difficulty.");
        System.out.println("There are " + board.getSize()[0] + " rows and " + board.getSize()[1] + " columns. (Labelled starting from 0)");
        System.out.println("There are " + board.getMines() + " mines to uncover.");
        System.out.println("\nType '[row] [column]' to dig a square.");
        System.out.println("Type 'f [row] [column]' to flag a square.");
        System.out.println("Type 'hint' to get a hint. (costs $100)");
        System.out.println("Type 'quit' to quit game.");
        System.out.println("\nLet the sweeping begin!\n");

        board.display();

        System.out.println("\n\nDig a square to begin.\n");

        while (player.getGameover() == 0) {
            // check if game is won
            if (player.getSquaresDug() == board.getSize()[0]*board.getSize()[1]-board.getMines()) {
                player.endGame(1);
                continue;
            }

            // get player input
            int[] userInput = player.getInput(sc, board.getSize());
            // invalid input
            if (userInput == null) {
                continue;
            }
            // quit game
            else if (userInput.length == 0) {
                System.out.println("Quitting game...");
                player.endGame(-1);
                continue;
            }
            // get hint
            else if (userInput.length == 1) {
                if (player.getSquaresDug() == 0) {
                    System.out.println("Please dig a square first.");
                    continue;
                }
                System.out.println("Do you want to buy a hint for $100?");
                System.out.println("Type 'yes' to confirm.");
                System.out.print("> ");
                String confirm = sc.nextLine().strip().toLowerCase();
                if (confirm.equals("yes")) {
                    if (currency.changeMoney(-100)) {
                        player.useHint();
                        board.getHint(sc);
                        System.out.println("You have $" + currency.getMoney() + " left.");
                        continue;
                    }
                }
                System.out.println("Cancelled.");
                continue;
            }
            // dig square
            else if (userInput.length == 2) {
                // generate mines locations after first click
                if (player.getSquaresDug() == 0 ) {
                    board.generateMines(userInput);
                    board.calculateAdjacents();
                }
                if (!board.dig(userInput)) {
                    continue;
                }
            }
            // flag cell
            else if (userInput.length == 3) {
                if (!board.flagCell(userInput[0], userInput[1])) {
                    continue;
                }
            }

            System.out.println();

            player.addMove();
            board.display();

            System.out.println("\n");
        }


        // print end game messages and return to menu
        if (player.getGameover() == 1) {
            System.out.println("You won!");
            System.out.println("You used " + player.getHintsUsed() + " hints.");

            switch (difficulty) {
                case "1": case "easy":
                    System.out.println("\nYou earned $300!\n");
                    currency.changeMoney(300);
                    break;
                case "2": case "medium":
                    System.out.println("\nYou earned 800!\n");
                    currency.changeMoney(800);
                    break;
                case "3": case "hard":
                    System.out.println("\nYou earned $3000!\n");
                    currency.changeMoney(3000);
                    break;
            }
        }
        else if (player.getGameover() == 2) {
            System.out.println("Game over! You stepped on a mine!");
            System.out.println("You used " + player.getHintsUsed() + " hints.");
        }

        System.out.println("Press enter to return to menu.");
        sc.nextLine();
    }

}