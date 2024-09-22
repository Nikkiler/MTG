package edu.QASMT.Nikita.MTG;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Creature> creatures;
    private int numLandsInHand = 3;
    public void putLandOnBattlefield(Battlefield battlefield) {
        numLandsInHand--;
        battlefield.addLands();
    }
    public void putCreatureOnBattlefield(Battlefield battlefield, int num) {
        Creature creature = creatures.get(num);
        creatures.remove(creature);
        battlefield.addCreatureToBattleField(num);
    }
    public int getNumLandsInHand() {
        int landClone = numLandsInHand;
        return landClone;
    }
    public void getCreatures() {
        for (int i = 0; i < creatures.size(); i++) {
            System.out.println("(" + i + ") " + creatures.get(i).getName() + "Power/Toughness (" + creatures.get(i).getPower() + "/" + creatures.get(i).getToughness() + ")" + " and mana cost of " + creatures.get(i).getManaCost());
        }
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
}
