package edu.QASMT.Nikita.MTG;

import java.util.ArrayList;

public class Deck {
    private boolean artifactTaken = false;
    private int randomNum = (int)(Math.random() * 7);
    public ArrayList<Creature> creatureDeck = new ArrayList<Creature>();
    public ArrayList<Land> landDeck = new ArrayList<Land>();
    public ArrayList<Enchantment> enchantmentDeck = new ArrayList<Enchantment>();
    public ArrayList<Instant> instantDeck = new ArrayList<Instant>();
    public ArrayList<Sorcery> sorceryDeck = new ArrayList<Sorcery>();
    public ArrayList<Artifact> artifactDeck = new ArrayList<Artifact>();
    private int cardsLeft = 60;
    public ArrayList<Creature> creatureHand = new ArrayList<Creature>();
    public ArrayList<Land> landHand = new ArrayList<Land>();
    public ArrayList<Enchantment> enchantmentHand = new ArrayList<Enchantment>();
    public ArrayList<Instant> instantHand = new ArrayList<Instant>();
    public ArrayList<Sorcery> sorceryHand = new ArrayList<Sorcery>();
    public ArrayList<Artifact> artifactHand = new ArrayList<Artifact>();
    public void getCard() {
        if (artifactTaken) {
            randomNum = (int)(Math.random() * 6);
        } else {
            randomNum = (int)(Math.random() * 7);
        }
        switch (randomNum) {
            case 1:
                int randomCreature = (int)(Math.random() * creatureDeck.size());
                if (creatureDeck.isEmpty()) {
                    getCard();
                } else {
                    creatureHand.add(creatureDeck.get(randomCreature));
                    creatureDeck.remove(randomCreature);
                    cardsLeft--;
                }
                break;
            case 2:
                landHand.add(landDeck.getFirst());
                break;
            case 3:
                int randomEnchantment = (int)(Math.random() * enchantmentDeck.size());
                if (enchantmentDeck.isEmpty()) {
                    getCard();
                } else {
                    enchantmentHand.add(enchantmentDeck.get(randomEnchantment));
                    enchantmentDeck.remove(randomEnchantment);
                    cardsLeft--;
                }
                break;
            case 4:
                int randomInstant = (int)(Math.random() * instantDeck.size());
                if (instantDeck.isEmpty()) {
                    getCard();
                } else {
                    instantHand.add(instantDeck.get(randomInstant));
                    instantDeck.remove(randomInstant);
                    cardsLeft--;
                }
                break;
            case 5:
                int randomSorcery = (int)(Math.random() * sorceryDeck.size());
                if (sorceryDeck.isEmpty()) {
                    getCard();
                } else {
                    sorceryHand.add(sorceryDeck.get(randomSorcery));
                    sorceryDeck.remove(randomSorcery);
                    cardsLeft--;
                }
                break;
            case 6:
                artifactHand.add(artifactDeck.getFirst());
                artifactTaken = true;
                cardsLeft--;
                break;
        }
    }
    public void destroyCreature(Creature Creature) {
        creatureHand.remove(Creature);
    }
    public void searchLibrary(String type, Battlefield battlefield, boolean player, Deck deck) {
        if (type.equals("Land")) {
            landDeck.removeLast();
            Land tokenLand = new Land();
            battlefield.addLandToBattleField(tokenLand, deck, player);
        }
    }
    public void destroyLand(Land lands) {
        landHand.remove(lands);
    }

}