package edu.qasmt.nikita.mtg;

import java.util.ArrayList;

public class Battlefield {
    ArrayList<Creature> playerBattlefield = new ArrayList<Creature>();
    private int playerLands = 0;
    public void addCreatureToBattleField(int num) {
        Creature creature = playerBattlefield.get(num);
        playerBattlefield.add(creature);
    }
    public void addCreatureToBattleField(Creature creature) {
        playerBattlefield.add(creature);
    }
    public void destroyCreatureInBattleField(int num) {
        Creature creature = playerBattlefield.get(num);
        playerBattlefield.remove(creature);
    }
    public int getLands() {
        int lands = playerLands;
        return lands;
    }
    public void addLands() {
        playerLands++;
    }
    public void getCreatures() {
        for (int i = 0; i < playerBattlefield.size(); i++) {
            System.out.println("(" + i + ") " + playerBattlefield.get(i).getName() + " Power/Toughness (" + playerBattlefield.get(i).getPower() + "/" + playerBattlefield.get(i).getToughness() + ")" + " and mana cost of " + playerBattlefield.get(i).getManaCost());
        }
    }
    public int getSize() {
        return playerBattlefield.size();
    }
    public int getCreaturePower(int num) {
        return playerBattlefield.get(num).getPower();
    }
    public int getCreatureToughness(int num) {
        return playerBattlefield.get(num).getToughness();
    }
    public Creature getCreature(int num) {
        return playerBattlefield.get(num);
    }
}
