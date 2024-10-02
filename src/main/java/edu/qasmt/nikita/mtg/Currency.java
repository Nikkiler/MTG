package edu.qasmt.nikita.mtg;

public class Currency {
    private static Currency instance;
    private int money = 0;

    private Currency() {

    }

    public static Currency getInstance() {
        if (instance == null) {
            instance = new Currency();
        }
        return instance;
    }

    public int getMoney() {
        return money;
    }

    public boolean changeMoney(int n) {
        if (n < 0) {
            if (money >= n) {
                money -= n;
                System.out.println("Transaction complete. Money remaining: " + money + " dollars.");
                return true;
            }
            System.out.println("Not enough money! (missing " + (n - money) + " dollars)");
            return false;
        } else {
            money += n;
            return true;
        }
    }
}
