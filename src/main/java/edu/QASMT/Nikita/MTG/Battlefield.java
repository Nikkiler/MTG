package edu.QASMT.Nikita.MTG;

import java.util.ArrayList;

public class Battlefield {
    ArrayList<Creature> player1Battlefield = new ArrayList<Creature>();
    ArrayList<Creature> player2Battlefield = new ArrayList<Creature>();
    ArrayList<Land> player1BattlefieldLands = new ArrayList<Land>();
    ArrayList<Land> player2BattlefieldLands = new ArrayList<Land>();
    public void addCreatureToBattleField(Creature Creature, Deck deck, Player player, boolean playerDecider) {
        deck.destroyCreature(Creature);
        player.takeMana(Creature.getManaCost());
        if (playerDecider) {
            player1Battlefield.add(Creature);
        } else {
            player2Battlefield.add(Creature);
        }
    }
    public void addLandToBattleField(Land lands, Deck deck, boolean playerDecider) {
        deck.destroyLand(lands);
        if (playerDecider) {
            player1BattlefieldLands.add(lands);
        } else {
            player2BattlefieldLands.add(lands);
        }
    }
    public void destroyCreatureToBattleField(Creature Creature, boolean playerDecider) {
        if (playerDecider) {
            player1Battlefield.remove(Creature);
        } else {
            player2Battlefield.remove(Creature);
        }
    }
    public void addTokenToBattleField(Creature Creature, boolean playerDecider) {
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
