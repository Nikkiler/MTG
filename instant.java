public class instant {
    private int attackCounter;
    private int toughnessCounter;
    private int manaCost;
    public void assignCounters(int attackCounter, int toughnessCounter, int manaCost) {
        this.attackCounter = attackCounter;
        this.toughnessCounter = toughnessCounter;
        this.manaCost = manaCost;
    }
    public void addCounterToCreature(creature Creature) {
        Creature.putCounter(attackCounter, toughnessCounter);
    }
    public void takeCounterToCreature(creature Creature) {
        Creature.takeCounter(attackCounter, toughnessCounter);
    }
    public void destroyCreature(creature Creature, Battlefield battlefield, boolean player) {
        battlefield.destroyCreatureToBattleField(Creature, player);
    }
}