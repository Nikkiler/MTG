package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deck black = new Deck();
        Deck green = new Deck();
        greenDeck(green);
        blackDeck(black);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose between (1) Magic the Gathering and (2) Minesweeper");
        int choice = scanner.nextInt();
        while ((choice != 1) && (choice != 2)) {
            System.out.println("Error Invalid Input");
            System.out.println("Choose between (1) Magic the Gathering and (2) Minesweeper");
            choice = scanner.nextInt();
        }
        if (choice == 1) {
            game();
        } else {
            System.out.println("This is still under construction.");
        }
    }
    public static boolean attack(int attacking, int defending) {
        if (attacking >= defending) {
            return true;
        } else if (attacking < defending) {
            return false;
        }
        return false;
    }
    public static void game() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to play the Green or the Black deck?");
        String deckChoice = scanner.nextLine();
        while (deckChoice != "Green" || deckChoice != "Black") {
            System.out.println("Please enter Green or Black");
            deckChoice = scanner.nextLine();
        }


    }
    public static void greenDeck(Deck green) {
        land forest = new land();
        for (int i = 0; i < 24; i++) {
            green.landDeck.add(forest);
        }
        creature yevaForceMage = new creature();
        yevaForceMage.assign(2, 2, "Yeva's forcemage", 3, "Elf Shaman", false, false);
        for (int i = 0; i < 2; i++) {
            green.creatureDeck.add(yevaForceMage);
        }
        creature woodBornBehemoth = new creature();
        woodBornBehemoth.assign(4, 4, "Woodborn Behemoth", 5, "Elemental", true, false);
        green.creatureDeck.add(woodBornBehemoth);
        creature stingerFlingSpider = new creature();
        stingerFlingSpider.assign(5, 2, "Stingerfling Spider", 5, "Spider", false, false);
        green.creatureDeck.add(stingerFlingSpider);
        creature rumblingBaloth = new creature();
        rumblingBaloth.assign(4, 4, "Rumbling Baloth", 4, "Beast", false, false);
        for (int i = 0; i < 2; i++) {
            green.creatureDeck.add(rumblingBaloth);
        }
        creature llanoWarElves = new creature();
        llanoWarElves.assign(1, 1, "Llanowar Elves", 1, "Elf Druid", false, false);
        for (int i = 0; i < 4; i++) {
            green.creatureDeck.add(llanoWarElves);
        }
        creature jadeMage = new creature();
        jadeMage.assign(1, 2, "Jade Mage", 2, "Human Shaman", false, false);
        green.creatureDeck.add(jadeMage);
        creature giantSpider = new creature();
        giantSpider.assign(4, 2, "Giant Spider", 4, "Spider", false, false);
        for (int i = 0; i < 3; i++) {
            green.creatureDeck.add(giantSpider);
        }
        creature garucksCompanion = new creature();
        garucksCompanion.assign(2, 3, "Garucks Companion", 2, "Beast", true, false);
        for (int i = 0; i < 4; i++) {
            green.creatureDeck.add(garucksCompanion);
        }
        creature cudgelTroll = new creature();
        cudgelTroll.assign(3, 4, "Cudgel Troll", 4, "Troll", false, false);
        green.creatureDeck.add(cudgelTroll);
        creature brindleBoar = new creature();
        brindleBoar.assign(2, 2, "Brindle Boar", 3, "Beast", false, false);
        for (int i = 0; i < 2; i++) {
            green.creatureDeck.add(brindleBoar);
        }
        creature acidicSlime = new creature();
        acidicSlime.assign(2, 2, "Acidic Slime", 5, "Slime", false, true);
        green.creatureDeck.add(acidicSlime);
        Artifact vialOfPoison = new Artifact();
        green.artifactDeck.add(vialOfPoison);
        Enchantment trollHide = new Enchantment();
        trollHide.assignCounters(2, 2);
        for (int i = 0; i < 2; i++) {
            green.enchantmentDeck.add(trollHide);
        }
        sorcery rampantGrowth = new sorcery();
        for (int i = 0; i < 4; i++) {
            green.sorceryDeck.add(rampantGrowth);
        }
        sorcery overRun = new sorcery();
        overRun.assignCounters(3,3);
        green.sorceryDeck.add(overRun);
        sorcery howlOfTheNightPack = new sorcery();
        howlOfTheNightPack.assignCounters(2,2);
        green.sorceryDeck.add(howlOfTheNightPack);
        instant giantGrowth = new instant();
        giantGrowth.assignCounters(3,3);
        for (int i = 0; i < 3; i++) {
            green.instantDeck.add(giantGrowth);
        }
        instant naturalize = new instant();
        green.instantDeck.add(naturalize);
        instant plummet = new instant();
        green.instantDeck.add(plummet);
    }
    public static void blackDeck(Deck black) {
        land swamp = new land();
        for (int i = 0; i < 24; i++) {
            black.landDeck.add(swamp);
        }
        creature warPathGhoul = new creature();
        warPathGhoul.assign(2,3, "Warpath Ghoul", 3, "Zombie", false, false);
        for (int i = 0; i < 4; i++) {
            black.creatureDeck.add(warPathGhoul);
        }
        creature vampireNightHawk = new creature();
        vampireNightHawk.assign(2,3, "Vampire Night Hawk", 3, "Vampire Shaman", false, true);
        black.creatureDeck.add(vampireNightHawk);
        creature sengirVampire = new creature();
        sengirVampire.assign(4,4, "Sengir Vampire", 4, "Vampire", false, false);
        black.creatureDeck.add(sengirVampire);
        creature onyxMage = new creature();
        onyxMage.assign(1, 2, "Onyx Mage", 2, "Human Wizard", false, true);
        creature graveDigger = new creature();
        graveDigger.assign(2,2, "Grave Digger", 4, "Zombie", false, false);
        for (int i = 0; i < 2; i++) {
            black.creatureDeck.add(graveDigger);
        }
        creature driftingShade = new creature();
        driftingShade.assign(1,1, "Drifting Shade", 4, "Shade", false, false);
        for (int i = 0; i < 2; i++) {
            black.creatureDeck.add(driftingShade);
        }
        creature childOfNight = new creature();
        childOfNight.assign(1,2, "Child Of Night", 2, "Vampire", false, false);
        for (int i = 0; i < 2; i++) {
            black.creatureDeck.add(childOfNight);
        }
        creature bloodThorneVampire = new creature();
        bloodThorneVampire.assign(1,1, "Bloodthorne Vampire", 2, "Vampire", false, false);
        for (int i = 0; i < 4; i++) {
            black.creatureDeck.add(bloodThorneVampire);
        }
        Artifact staffOfTheDeathMagus = new Artifact();
        black.artifactDeck.add(staffOfTheDeathMagus);
        Enchantment quagSickness = new Enchantment();
        quagSickness.assignCounters(-1, -1);
        for (int i = 0; i < 3; i++) {
            black.enchantmentDeck.add(quagSickness);
        }
        Enchantment darkFavor = new Enchantment();
        darkFavor.assignCounters(1, 3);
        black.enchantmentDeck.add(darkFavor);
        sorcery signInBlood = new sorcery();
        for (int i = 0; i < 3; i++) {
            black.sorceryDeck.add(signInBlood);
        }
        sorcery duress = new sorcery();
        for (int i = 0; i < 4; i++) {
            black.sorceryDeck.add(duress);
        }
        sorcery diobolicTutor = new sorcery();
        black.sorceryDeck.add(diobolicTutor);
        sorcery corrupt = new sorcery();
        black.sorceryDeck.add(corrupt);
        instant wringFlesh = new instant();
        wringFlesh.assignCounters(-1, -3);
        black.instantDeck.add(wringFlesh);
        instant doomBlade = new instant();
        for (int i = 0; i < 4; i++) {
            black.instantDeck.add(doomBlade);
        }

    }
}