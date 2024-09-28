package edu.qasmt.nikita.mtg;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Creature> creatures = new ArrayList<Creature>();
    private ArrayList<Spell> spells = new ArrayList<Spell>();
    private int numLandsInHand = 3;
    public void putLandOnBattlefield(Battlefield battlefield) {
        numLandsInHand--;
        battlefield.addLands();
    }
    public void putCreatureOnBattlefield(Battlefield battlefield, int num) {
        Creature creature = creatures.get(num);
        creatures.remove(creature);
        battlefield.addCreatureToBattleField(creature);
    }
    public int getNumLandsInHand() {
        int landClone = numLandsInHand;
        return landClone;
    }
    public void getSpells() {
        for (int i = 0; i < spells.size(); i++) {
            System.out.println("(" + i + ") " + spells.get(i).getName() + " Power/Toughness  Modifier (" + spells.get(i).getPower() + "/" + spells.get(i).getToughness() + ")" + " and mana cost of " + spells.get(i).getManaCost());
        }
    }
    public void getCreatures() {
        for (int i = 0; i < creatures.size(); i++) {
            System.out.println("(" + i + ") " + creatures.get(i).getName() + " Power/Toughness (" + creatures.get(i).getPower() + "/" + creatures.get(i).getToughness() + ")" + " and mana cost of " + creatures.get(i).getManaCost());
        }
    }
    public boolean getSpellPositive(int num) {
        Spell spell = spells.get(num);
        return spell.getPositive();
    }
    public int getSpellPower(int num) {
        Spell spell = spells.get(num);
        return spell.getPower();
    }
    public int getSpellToughness(int num) {
        Spell spell = spells.get(num);
        return spell.getToughness();
    }
    public int getSpellCost(int num) {
        Spell spell = spells.get(num);
        return spell.getManaCost();
    }
    public int getNumCreatures() {
        return creatures.size();
    }
    public int getManaCost(int num) {
        int cost = creatures.get(num).getManaCost();
        return cost;
    }
    public void addCreature(Creature creature) {
        creatures.add(creature);
    }
    public void addSpell (Spell spell) {spells.add(spell);}
}
