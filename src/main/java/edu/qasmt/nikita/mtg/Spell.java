package edu.qasmt.nikita.mtg;

public class Spell {
    private String name;
    private int manaCost;
    private int power;
    private int toughness;
    private boolean positive;
    public Spell(int power, int toughness, int manaCost, String name, boolean isPositive) {
        this.power = power;
        this.toughness = toughness;
        this.manaCost = manaCost;
        this.name = name;
        this.positive = isPositive;
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
    public boolean getPositive() {
        boolean positiveClone = positive;
        return positiveClone;
    }
}
