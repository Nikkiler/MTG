public class creature {
    private int toughness;
    private int attack;
    private String name;
    private int manaCost = 0;
    private String type;
    private boolean trample;
    private boolean deathTouch;
    private boolean tapped = false;
    public void assign(int toughness, int attack, String name, int manaCost, String type, boolean trample, boolean deathTouch) {
        this.toughness = toughness;
        this.attack = attack;
        this.name = name;
        this.manaCost = manaCost;
        this.type = type;
        this.trample = trample;
        this.deathTouch = deathTouch;
    }
    public void assignToken(int toughness, int attack, String name, String type) {
        this.toughness = toughness;
        this.attack = attack;
        this.name = name;
        this.type = type;
    }
    public void putCounter(int attackIncrease, int toughnessIncrease) {
        toughness += toughnessIncrease;
        attack += attackIncrease;
    }
    public void takeCounter(int attackDecrease, int toughnessDecrease) {
        toughness -= toughnessDecrease;
        attack -= attackDecrease;
    }
    public int getManaCost() {
        return manaCost;
    }
    public void giveTrample() {
        trample = true;
    }
    public void giveDeathTouch() {
        deathTouch = true;
    }
    public void tap() {
        tapped = true;
    }
    public void untap() {
        tapped = false;
    }

}
