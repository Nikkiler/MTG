package edu.qasmt.nikita.mtg;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
import java.util.Scanner;
import com.google.gson.Gson;


public class Game {
    public void gameSetAndRun() {
        Player player1 = new Player();
        Player player2 = new Player();
        Scanner scanner = new Scanner(System.in);
        Hand darkAngels = new Hand();
        Hand ultraMarines = new Hand();
        Gson gson = new Gson();

        // Read JSON from a file
        try (Reader reader = new FileReader("src/main/java/edu/qasmt/nikita/mtg/DarkAngels.json")) {
            Creature[] userArray = new Gson().fromJson(reader, Creature[].class);
            for(Creature creature : userArray) {
                System.out.println(creature.getName());
                darkAngels.addCreature(creature);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (Reader reader = new FileReader("src/main/java/edu/qasmt/nikita/mtg/Ultramarines.json")) {
            Creature[] userArray = new Gson().fromJson(reader, Creature[].class);
            for(Creature creature : userArray) {
                System.out.println(creature.getName());
                ultraMarines.addCreature(creature);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (Reader reader = new FileReader("src/main/java/edu/qasmt/nikita/mtg/DarkAngelsSpells.json")) {
            Spell[] userArray = new Gson().fromJson(reader, Spell[].class);
            for(Spell spell : userArray) {
                System.out.println(spell.getName());
                darkAngels.addSpell(spell);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (Reader reader = new FileReader("src/main/java/edu/qasmt/nikita/mtg/UltramarinesSpells.json")) {
            Spell[] userArray = new Gson().fromJson(reader, Spell[].class);
            for(Spell spell : userArray) {
                System.out.println(spell.getName());
                ultraMarines.addSpell(spell);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Choose between (1) Magic the Gathering and (2) Minesweeper");
        String choice = scanner.nextLine();
        while ((!Objects.equals(choice, "1")) && (!Objects.equals(choice, "2"))) {
            System.out.println("Error Invalid Input");
            System.out.println("Choose between (1) Magic the Gathering and (2) Minesweeper");
            choice = scanner.nextLine();
        }
        if (choice.equals("1")) {
            game(player1, player2, darkAngels, ultraMarines, scanner);
        } else {
            System.out.println("This is still under construction.");
        }
    }
    public static int attack(Creature attacker, Creature defender) {
        int attacking = attacker.getPower();
        int defending = defender.getToughness();
        if (attacking >= defending) {
            return attacking - defending;
        } else if (attacking < defending) {
            return attacking - defending;
        }
        return attacking - defending;
    }
    public static void game(Player player1, Player player2, Hand darkAngels, Hand ultraMarines, Scanner scanner) {
        Battlefield player1Battlefield = new Battlefield();
        Battlefield player2Battlefield = new Battlefield();
        player1.setBattlefield(player1Battlefield);
        player2.setBattlefield(player2Battlefield);
        System.out.println("Would you like to play the Dark Angels or the Ultramarines?");
        String deckChoice = scanner.nextLine();
        while (!Objects.equals(deckChoice, "Dark Angels") && !Objects.equals(deckChoice, "Ultramarines")) {
            System.out.println("Please enter Dark Angels or the Ultramarines");
            deckChoice = scanner.nextLine();
        }
        if (deckChoice.equals("Dark Angels")) {
            player1.setHand(darkAngels);
            player2.setHand(ultraMarines);
        } else {
            player1.setHand(ultraMarines);
            player2.setHand(darkAngels);
        }
        for (int i = 1; i < 4; i++) {
            System.out.println("Round " + i + ":");
            playerTurn(player1, player2, player1Battlefield, player2Battlefield, 1, scanner);
            System.out.println("Player 1 your Turn has ended");
            playerTurn(player2, player1, player2Battlefield, player1Battlefield, 2, scanner);

        }
        if (player1.getLife() > player2.getLife()) {
            System.out.println("Player 1 wins!");
        } else if (player2.getLife() > player1.getLife()) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("Draw...");
        }

    }
    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void playerTurn(Player player1, Player player2, Battlefield player1Battlefield, Battlefield player2Battlefield, int playerNum, Scanner scanner) {
        System.out.println("Player " + playerNum + " it is your turn would you like to place a land? You have " + player1.getHand().getNumLandsInHand() + " lands");
        System.out.println("y or n");
        char getLands = scanner.nextLine().charAt(0);
        while (getLands != 'n' && getLands != 'y') {
            System.out.println("Please enter a valid choice (y or n)");
            getLands = scanner.nextLine().charAt(0);
        }
        if (getLands == 'y') {
            player1.getHand().putLandOnBattlefield(player1Battlefield);
        }
        int usableMana = howMany(playerNum, scanner, "land", "tap", player1.getBattlefield().getLands(), player1);
        System.out.println("Player" + playerNum + " has " + usableMana + " usable mana");
        player1.getHand().getCreatures();
        System.out.println("Would you like to play a creature?");
        System.out.println("y or n");
        char getCreature = scanner.nextLine().charAt(0);
        while (getCreature != 'n' && getCreature != 'y') {
            System.out.println("Please enter a valid choice (y or n)");
            getCreature = scanner.nextLine().charAt(0);
        }
        if (getCreature == 'y') {
            int numCreatureChoices = howMany(playerNum, scanner, "creature", "play", (player1.getHand().getNumCreatures() - 1), player1);
            while (usableMana < player1.getHand().getManaCost(numCreatureChoices)) {
                System.out.println("Player " + playerNum + " has " + usableMana + " usable mana");
                System.out.println("And creature (" + numCreatureChoices + ") costs " + player1.getHand().getManaCost(numCreatureChoices) + " mana");
                numCreatureChoices = howMany(playerNum, scanner, "creature", "play", (player1.getHand().getNumCreatures() - 1), player1);
            }
            player1.getHand().putCreatureOnBattlefield(player1Battlefield, numCreatureChoices);
            usableMana -= player1.getHand().getManaCost(numCreatureChoices);
        }
        if (usableMana > 0) {
            castSpell(scanner, player1Battlefield, player2Battlefield, player1, player2, playerNum, usableMana);
        }
        System.out.println("Would you like to attack?");
        System.out.println("y or n");
        char getAttack = scanner.nextLine().charAt(0);
        while (getAttack != 'n' && getAttack != 'y') {
            System.out.println("Please enter a valid choice (y or n)");
            getAttack = scanner.nextLine().charAt(0);
        }
        if (getAttack == 'y') {
            if (player1Battlefield.getSize() > 0) {
                System.out.println("Which creature would you like to attack with?");
                int attackChoice = howMany(playerNum, scanner, "creature", "attack", (player1.getBattlefield().getSize() - 1), player1);
                if (player2Battlefield.getSize() < 1) {
                    System.out.println("Defender you have lost " + player1Battlefield.getCreaturePower(attackChoice) + " Life");
                    player2.takeLife(player1Battlefield.getCreaturePower(attackChoice));
                } else {
                    System.out.println("DEFENDER! ,Which Creature would you like to defend with?");
                    int defenderChoice = howMany(playerNum, scanner, "creature", "defend", (player1.getBattlefield().getSize() - 1), player2);
                    int attackResult = attack(player1Battlefield.getCreature(attackChoice), player2Battlefield.getCreature(defenderChoice));
                    if (attackResult >= 0) {
                        System.out.println("Congratulations you have defeated a creature");
                        player2Battlefield.destroyCreatureInBattleField(defenderChoice);
                        System.out.println("Defender you have lost " + attackResult + " Life");
                        player2.takeLife(attackResult);
                    } else {
                        System.out.println("Attacker you did not succeed...");
                    }
                }
            }
        }


    }
    public static int howMany(int playerNum, Scanner scanner, String type, String toDo, int numberOf, Player player) {
        howManyIfOfChoice(playerNum, type, toDo, numberOf, player);
        System.out.println("Please enter a number between 0 and " + numberOf);

        String doing = scanner.nextLine();
        boolean numCheck = isNumber(doing);
        if (!numCheck) {
            while (!numCheck) {
                howManyIfOfChoice(playerNum, type, toDo, numberOf, player);
                System.out.println("Please enter an integer! between 0 and " + numberOf);
                doing = scanner.nextLine();
                numCheck = isNumber(doing);
            }
        }
        int numLandTap = Integer.parseInt(doing);
        while (numLandTap < 0 || numLandTap > numberOf) {
            howManyIfOfChoice(playerNum, type, toDo, numberOf, player);
            doing = scanner.nextLine();
            numCheck = isNumber(doing);
            if (!numCheck) {
                while (!numCheck) {
                    howManyIfOfChoice(playerNum, type, toDo, numberOf, player);
                    System.out.println("Please enter an integer! between 0 and " + numberOf);
                    doing = scanner.nextLine();
                    numCheck = isNumber(doing);
                }
            }
            numLandTap = Integer.parseInt(doing);
        }
        return numLandTap;
    }

    public static void howManyIfOfChoice(int playerNum, String type, String toDo, int numberOf, Player player) {
        if (toDo.equals("attack") || toDo.equals("defend") || toDo.equals("casting") || toDo.equals("play")) {
            player.getBattlefield().getCreatures();
            System.out.println("Which creature?");
        } else if (toDo.equals("cast")) {
            player.getHand().getSpells();
            System.out.println("Which spell would you like to use?");
        } else {
            System.out.println("Player " + playerNum + " how many " + type + " would you like to " + toDo + "? " + numberOf + " " + type);
        }
    }
    public static void castSpell(Scanner scanner, Battlefield player1Battlefield, Battlefield player2Battlefield, Player player1, Player player2, int playerNum, int usableMana) {
        System.out.println("Would you like to cast a spell?");
        System.out.println("y or n");
        char getCast = scanner.nextLine().charAt(0);
        while (getCast != 'n' && getCast != 'y') {
            System.out.println("Please enter a valid choice (y or n)");
            getCast = scanner.nextLine().charAt(0);
        }
        if (getCast == 'y') {
            if (player1Battlefield.getSize() > 0 && player2Battlefield.getSize() > 0) {
                System.out.println("You do not have anything to cast a spell on!");
            } else {
                int castChoice = howMany(playerNum, scanner, "spell", "cast", (player1.getBattlefield().getSize() - 1), player1);
                if (player1.getHand().getSpellCost(castChoice) > usableMana) {
                    if (player1.getHand().getSpellPositive(castChoice)) {
                        if (player1Battlefield.getSize() > 0) {
                            System.out.println("Who (In your battle field) would you like to cast a spell on?");
                            int yourCreatureCastChoice = howMany(playerNum, scanner, "spell", "casting", (player1.getBattlefield().getSize() - 1), player1);
                            player1Battlefield.getCreature(yourCreatureCastChoice).changePower(player1.getHand().getSpellPower(yourCreatureCastChoice));
                            player1Battlefield.getCreature(yourCreatureCastChoice).changeToughness(player1.getHand().getSpellToughness(yourCreatureCastChoice));
                        } else {
                            System.out.println("You do not have anything to cast a spell on!");
                        }
                    } else {
                        if (player2Battlefield.getSize() > 0) {
                            System.out.println("Who (In your  opponents battle field) would you like to cast a spell on?");
                            int yourCreatureCastChoice = howMany(playerNum, scanner, "spell", "casting", (player2.getBattlefield().getSize() - 1), player2);
                            player2Battlefield.getCreature(yourCreatureCastChoice).changePower(player1.getHand().getSpellPower(yourCreatureCastChoice));
                            player2Battlefield.getCreature(yourCreatureCastChoice).changeToughness(player1.getHand().getSpellToughness(yourCreatureCastChoice));
                        } else {
                            System.out.println("You do not have anything to cast a spell on!");
                        }
                    }
                } else {
                    System.out.println("You do not have enough mana to cast a spell!");
                }
            }
        }
    }
}
