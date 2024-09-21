package edu.QASMT.Nikita.MTG;

public class Sorcery {
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
    public void createTokens(String type, int number, Battlefield battlefield, String name, boolean player) {
        for (int i = 0; i < number; i++) {
            Creature Token = new Creature();
            Token.assignToken(toughnessCounter, attackCounter, name, type);
            battlefield.addTokenToBattleField(Token, player);
        }
    }

    public void searchLibrary(String type, Deck deck) {
        switch (type) {
            case "Land":
                Land forest = new Land();
                deck.landHand.add(forest);
                deck.landDeck.remove(forest);
                break;
        }
    }
    public void giveTrample(Creature creature) {
        creature.giveTrample();
    }
}
