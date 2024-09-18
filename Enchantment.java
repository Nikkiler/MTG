public class Enchantment {
    private int attackCounter;
    private int toughnessCounter;
    private int manaCost;
    public void assignCounters(int attackCounter, int toughnessCounter) {
        this.attackCounter = attackCounter;
        this.toughnessCounter = toughnessCounter;
    }
    public void addCounterToCreature(creature Creature) {
        Creature.putCounter(attackCounter, toughnessCounter);
    }
    public void takeCounterFromCreature(creature Creature) {
        Creature.takeCounter(attackCounter, toughnessCounter);
    }
}