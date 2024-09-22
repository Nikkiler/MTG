package edu.QASMT.Nikita.MTG;

public class Instant {
    private int attackCounter;
    private int toughnessCounter;
    private int manaCost;
    public void assignCounters(int attackCounter, int toughnessCounter) {
        this.attackCounter = attackCounter;
        this.toughnessCounter = toughnessCounter;
    }
    public void addCounterToCreature(Creature creature) {
        creature.putCounter(attackCounter, toughnessCounter);
    }
    public void takeCounterToCreature(Creature creature) {
        creature.takeCounter(attackCounter, toughnessCounter);
    }
    public void destroyCreature(Creature creature, Battlefield battlefield, boolean player) {
        battlefield.destroyCreatureInBattleField(creature);
    }
}