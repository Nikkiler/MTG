package edu.QASMT.Nikita.MTG;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        Scanner scanner = new Scanner(System.in);
        Hand darkAngels = new Hand();
        Hand ultraMarines = new Hand();
        Creature darkAngelMarine = new Creature(1, 2, 1, "Dark Angels Marine");
        darkAngels.addCreature(darkAngelMarine);
        Creature ultraMarine = new Creature(1, 2, 1, "Ultramarine");
        ultraMarines.addCreature(ultraMarine);
        Creature azraelSupremeGrandmaster = new Creature(2, 2, 2, "Azrael Supreme Grandmaster");
        darkAngels.addCreature(azraelSupremeGrandmaster);
        Creature marneusCalgarChapterMaster = new Creature(2, 2, 2, "Marneus Calgar Chapter Master");
        ultraMarines.addCreature(marneusCalgarChapterMaster);
        Creature lionElJohnson = new Creature(3, 3, 3, "Lion El Johnson");
        darkAngels.addCreature(lionElJohnson);
        Creature robouteGuilliman = new Creature(3, 3, 3, "Roboute Guilliman");
        ultraMarines.addCreature(robouteGuilliman);
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
    public static int howManyTapLands(Player player1, Player player2, int playerNum, Scanner scanner) {
        System.out.println("Player " + playerNum + " how many lands would you like to tap? " + player1.getBattlefield().getLands() + " lands");
        System.out.println("Please enter a number between 0 and " + player1.getBattlefield().getLands());
        String tapLands = scanner.nextLine();
        boolean numCheck = isNumber(tapLands);
        if (!numCheck) {
            while (!numCheck) {
                System.out.println("Not an integer");
                System.out.println("Player " + playerNum + " how many lands would you like to tap? " + player1.getBattlefield().getLands() + " lands");
                System.out.println("Please enter an integer! between 0 and " + player1.getBattlefield().getLands());
                tapLands = scanner.nextLine();
                numCheck = isNumber(tapLands);
            }
        }
        int numLandTap = Integer.parseInt(tapLands);
        while (numLandTap < 0 || numLandTap > player1.getBattlefield().getLands()) {
            System.out.println("Please enter an integer! between 0 and " + player1.getBattlefield().getLands());
            tapLands = scanner.nextLine();
            numCheck = isNumber(tapLands);
            if (!numCheck) {
                while (!numCheck) {
                    System.out.println("Not an integer");
                    System.out.println("Player " + playerNum + " how many lands would you like to tap? " + player1.getBattlefield().getLands() + " lands");
                    System.out.println("Please enter an integer! between 0 and " + player1.getBattlefield().getLands());
                    tapLands = scanner.nextLine();
                    numCheck = isNumber(tapLands);
                }
            }
            numLandTap = Integer.parseInt(tapLands);
        }
        return numLandTap;
    }
    public static int numCreature(Player player, Scanner scanner) {
        player.getHand().getCreatures();
        System.out.println("Which creature?");
        System.out.println("Please enter a number between 0 and " + (player.getHand().getNumCreatures() - 1));
        String whichCreature = scanner.nextLine();
        boolean creatureCheck = isNumber(whichCreature);
        if (!creatureCheck) {
            while (!creatureCheck) {
                System.out.println("Not an integer");
                player.getHand().getCreatures();
                System.out.println("Please enter a number between 0 and " + (player.getHand().getNumCreatures() - 1));
                whichCreature = scanner.nextLine();
                creatureCheck = isNumber(whichCreature);
            }
        }
        int numCreatureChoice = Integer.parseInt(whichCreature);
        while (numCreatureChoice < 0 || numCreatureChoice > (player.getHand().getNumCreatures() - 1)) {
            player.getHand().getCreatures();
            System.out.println("Please enter a number between 0 and " + (player.getHand().getNumCreatures() - 1));
            whichCreature = scanner.nextLine();
            creatureCheck = isNumber(whichCreature);
            if (!creatureCheck) {
                while (!creatureCheck) {
                    System.out.println("Not an integer");
                    player.getHand().getCreatures();
                    System.out.println("Please enter a number between 0 and " + (player.getHand().getNumCreatures() - 1));
                    whichCreature = scanner.nextLine();
                    creatureCheck = isNumber(whichCreature);
                }
            }
            numCreatureChoice = Integer.parseInt(whichCreature);
        }
        return  numCreatureChoice;
    }
    public static int numBattleFieldCreature(Player player, Scanner scanner) {
        player.getBattlefield().getCreatures();
        System.out.println("Which creature?");
        System.out.println("Please enter a number between 0 and " + (player.getBattlefield().getSize() - 1));
        String whichCreature = scanner.nextLine();
        boolean creatureCheck = isNumber(whichCreature);
        if (!creatureCheck) {
            while (!creatureCheck) {
                System.out.println("Not an integer");
                player.getBattlefield().getCreatures();
                System.out.println("Please enter a number between 0 and " + (player.getBattlefield().getSize() - 1));
                whichCreature = scanner.nextLine();
                creatureCheck = isNumber(whichCreature);
            }
        }
        int numCreatureChoice = Integer.parseInt(whichCreature);
        while (numCreatureChoice < 0 || numCreatureChoice > (player.getBattlefield().getSize() - 1)) {
            player.getBattlefield().getCreatures();
            System.out.println("Please enter a number between 0 and " + (player.getBattlefield().getSize() - 1));
            whichCreature = scanner.nextLine();
            creatureCheck = isNumber(whichCreature);
            if (!creatureCheck) {
                while (!creatureCheck) {
                    System.out.println("Not an integer");
                    player.getHand().getCreatures();
                    System.out.println("Please enter a number between 0 and " + (player.getBattlefield().getSize() - 1));
                    whichCreature = scanner.nextLine();
                    creatureCheck = isNumber(whichCreature);
                }
            }
            numCreatureChoice = Integer.parseInt(whichCreature);
        }
        return  numCreatureChoice;
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
        int usableMana = howManyTapLands(player1, player2, playerNum, scanner);
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
            int numCreatureChoices = numCreature(player1, scanner);
            while (usableMana < player1.getHand().getManaCost(numCreatureChoices)) {
                System.out.println("Player " + playerNum + " has " + usableMana + " usable mana");
                System.out.println("And creature (" + numCreatureChoices + ") costs " + player1.getHand().getManaCost(numCreatureChoices) + " mana");
                numCreatureChoices = numCreature(player1, scanner);
            }
            player1.getHand().putCreatureOnBattlefield(player1Battlefield, numCreatureChoices);
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
                int attackChoice = numBattleFieldCreature(player1, scanner);
                if (player2Battlefield.getSize() < 1) {
                    System.out.println("Defender you have lost " + player1Battlefield.getCreaturePower(attackChoice) + " Life");
                    player2.takeLife(player1Battlefield.getCreaturePower(attackChoice));
                } else {
                    System.out.println("DEFENDER! ,Which Creature would you like to defend with?");
                    int defenderChoice = numBattleFieldCreature(player2, scanner);
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
}