package edu.qasmt.nikita.mtg;

public class Creature {
    private int power;
    private int toughness;
    private int manaCost;
    private String name;
    public Creature(int power, int toughness, int manaCost, String name) {
        this.power = power;
        this.toughness = toughness;
        this.manaCost = manaCost;
        this.name = name;
    }
    public int getManaCost() {
        int manaClone = manaCost;
        return manaClone;
    }
    public int getPower() {
        int powerClone = power;
        return powerClone;
    }
    public int getToughness() {
        int toughnessClone = toughness;
        return toughnessClone;
    }
    public String getName() {
        String nameClone = name;
        return nameClone;
    }
    public void changePower(int power) {
        this.power += power;
    }
    public void changeToughness(int toughness) {
        this.toughness += toughness;
    }
}
