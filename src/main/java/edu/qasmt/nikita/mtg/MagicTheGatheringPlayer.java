package edu.qasmt.nikita.mtg;

public class MagicTheGatheringPlayer {
    private int life = 20;
    private Battlefield battlefield;
    private Hand hand;
    public void takeLife(int damage) {
        life -= damage;
    }
    public void giveLife(int damage) {
        life += damage;
    }
    public int getLife() {
        int lifeClone = life;
        return lifeClone;
    }
    public Battlefield getBattlefield() {return battlefield;}
    public Hand getHand() {return hand;}
    public void setHand(Hand hand) {this.hand = hand;}
    public void setBattlefield(Battlefield battlefield) {
        this.battlefield = battlefield;
    }
}