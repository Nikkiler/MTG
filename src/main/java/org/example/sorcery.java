package org.example;

public class sorcery {
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
    public void takeCounterToCreature(creature Creature) {
        Creature.takeCounter(attackCounter, toughnessCounter);
    }
    public void createTokens(String type, int number, Battlefield battlefield, String name, boolean player) {
        for (int i = 0; i < number; i++) {
            creature Token = new creature();
            Token.assignToken(toughnessCounter, attackCounter, name, type);
            battlefield.addTokenToBattleField(Token, player);
        }
    }

    public void searchLibrary(String type, Deck deck) {
        switch (type) {
            case "Land":
                land forest = new land();
                deck.landHand.add(forest);
                deck.landDeck.remove(forest);
                break;
        }
    }
    public void giveTrample(creature Creature) {
        Creature.giveTrample();
    }
}
