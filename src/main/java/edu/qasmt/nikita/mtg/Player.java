package edu.qasmt.nikita.mtg;

import java.util.Scanner;

public class Player {
    private int life = 20;
    private Battlefield battlefield;
    private Hand hand;
    public int tapLand(Battlefield battlefield) {
        int currentLands = battlefield.getLands();
        System.out.println("You can tap " + currentLands + " Lands");
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many lands would you like to tap (please enter an integer)?");
        int landTapper = scanner.nextInt();
        while (landTapper > currentLands) {
            System.out.println("Please enter a number equal to " + currentLands + " or lower (please enter an integer)?");
            landTapper = scanner.nextInt();
        }
        currentLands -= landTapper;
        return currentLands;
    }
    public void takeLife(int damage) {
        life -= damage;
    }
    public void giveLife(int damage) {
        life += damage;
    }
    public int getLife() {
        int lifeClone = life;
        return lifeClone;
    }
    public Battlefield getBattlefield() {return battlefield;}
    public Hand getHand() {return hand;}
    public void setHand(Hand hand) {this.hand = hand;}
    public void setBattlefield(Battlefield battlefield) {
        this.battlefield = battlefield;
    }
}