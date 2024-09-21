package edu.QASMT.Nikita.MTG;

public class Artifact {
    private int manaCost;
    public void giveDeathTouch(Creature Creature) {
        Creature.giveDeathTouch();
    }
    public void gainLife(Player player, int num) {
        player.giveLife(num);
    }
    public void assignManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
}