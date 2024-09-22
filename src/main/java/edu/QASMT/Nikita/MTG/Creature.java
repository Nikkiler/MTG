package edu.QASMT.Nikita.MTG;

public class Creature {
    private int power;
    private int toughness;
    private int manaCost = 0;
    private String name;
    public Creature(int power, int toughness, int manaCost) {
        this.power = power;
        this.toughness = toughness;
        this.manaCost = manaCost;
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
}
