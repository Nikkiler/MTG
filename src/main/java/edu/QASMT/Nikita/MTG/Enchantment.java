package edu.QASMT.Nikita.MTG;

public class Enchantment {
    private int attackCounter;
    private int toughnessCounter;
    private int manaCost;
    public void assignCounters(int attackCounter, int toughnessCounter) {
        this.attackCounter = attackCounter;
        this.toughnessCounter = toughnessCounter;
    }
    public void addCounterToCreature(Creature Creature) {
        Creature.putCounter(attackCounter, toughnessCounter);
    }
    public void takeCounterFromCreature(Creature Creature) {
        Creature.takeCounter(attackCounter, toughnessCounter);
    }
}