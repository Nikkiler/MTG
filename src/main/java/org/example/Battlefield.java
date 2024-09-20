package org.example;

import java.util.ArrayList;

public class Battlefield {
    ArrayList<creature> player1Battlefield = new ArrayList<creature>();
    ArrayList<creature> player2Battlefield = new ArrayList<creature>();
    ArrayList<land> player1BattlefieldLands = new ArrayList<land>();
    ArrayList<land> player2BattlefieldLands = new ArrayList<land>();
    public void addCreatureToBattleField(creature Creature, Deck deck, Player player, boolean playerDecider) {
        deck.destroyCreature(Creature);
        player.takeMana(Creature.getManaCost());
        if (playerDecider) {
            player1Battlefield.add(Creature);
        } else {
            player2Battlefield.add(Creature);
        }
    }
    public void addLandToBattleField(land lands, Deck deck, boolean playerDecider) {
        deck.destroyLand(lands);
        if (playerDecider) {
            player1BattlefieldLands.add(lands);
        } else {
            player2BattlefieldLands.add(lands);
        }
    }
    public void destroyCreatureToBattleField(creature Creature, boolean playerDecider) {
        if (playerDecider) {
            player1Battlefield.remove(Creature);
        } else {
            player2Battlefield.remove(Creature);
        }
    }
    public void addTokenToBattleField(creature Creature, boolean playerDecider) {
        if (playerDecider) {
            player1Battlefield.add(Creature);
        } else {
            player2Battlefield.add(Creature);
        }
    }
    public int getLands(boolean player) {
        if (player) {
            return player1BattlefieldLands.size();
        } else {
            return player2BattlefieldLands.size();
        }
    }
}
