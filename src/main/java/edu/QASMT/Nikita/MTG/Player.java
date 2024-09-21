package edu.QASMT.Nikita.MTG;

import java.util.Scanner;

public class Player {
    private int life = 20;
    private int mana = 0;

    public void tapLand(Battlefield battlefield, boolean player) {
        int currentLands = battlefield.getLands(player);
        System.out.println("You can tap " + currentLands + " Lands");
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many app.src.main.mtg.land would you like to tap (please enter an integer)?");
        int landTapper = scanner.nextInt();
        while (landTapper > currentLands) {
            System.out.println("Please enter a number equal to " + currentLands + " or lower (please enter an integer)?");
            landTapper = scanner.nextInt();
        }
        currentLands -= landTapper;
        mana = currentLands;
    }
    public void takeLife(int damage) {
        life -= damage;
    }
    public void giveLife(int damage) {
        life += damage;
    }
    public void takeMana(int manaTake) {
        mana -= manaTake;
    }
    public int getMana() {
        return mana;
    }
    public void giveMana(int manaGive) {
        mana += manaGive;
    }
}