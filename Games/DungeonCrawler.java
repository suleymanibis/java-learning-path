package Games;

import java.util.Scanner;

public class DungeonCrawler {
    public static void main(String[] args) {
        String name, className, code = "", classTitle, special = "", tag, title, resultText;
        int golemHp, golemAttack, golemDamage, hp = 0, leftHp, damage = 0, bonus = 0, defense = 0, hit, golemLeft, earnedXp;
        boolean valid = true;

        golemHp = 19;
        golemAttack = 14;

        Scanner input = new Scanner(System.in);

        System.out.print("Hero name: ");
        name = input.nextLine().trim();

        if (name.isEmpty()) {
            valid = false;
        }

        if (valid) {
            System.out.print("Hero class: ");
            className = input.nextLine().trim().toLowerCase();

            switch (className) {
                case "warrior":
                    code = "WAR";
                    hp = 68;
                    damage = 17;
                    bonus = 0;
                    defense = 5;
                    special = "Block 5";
                    break;
                case "rogue":
                    code = "ROG";
                    hp = 51;
                    damage = 16;
                    bonus = 4;
                    defense = 0;
                    special = "Critical +4";
                    break;
                case "ranger":
                    code = "RAN";
                    hp = 56;
                    damage = 16;
                    bonus = 0;
                    defense = 3;
                    special = "Range 3";
                    break;
                case "mage":
                    code = "MAG";
                    hp = 39;
                    damage = 12;
                    bonus = 7;
                    defense = 0;
                    special = "Spell Power +7";
                    break;
                default:
                    className = "";
            }

            if (className.isEmpty()) {
                System.out.println("Invalid class.");
            } else {
                int endingIndex = name.length();

                if (name.length() >= 3) {
                    endingIndex = 3;
                }

                classTitle = className.toUpperCase().charAt(0) + className.substring(1);
                tag = name.substring(0, endingIndex).toUpperCase() + "-" + code;
                title = name.toUpperCase().charAt(0) + name.substring(1) + " the " + classTitle;

                hit = damage + bonus;
                earnedXp = hit;
                golemLeft = Math.max(0, golemHp - hit);

                System.out.println(tag + " " + title + " | HP " + hp + " | DMG " + damage + " | " + special);
                System.out.println(tag + " hits the Stone Golem for " + hit);
                System.out.println("Stone Golem HP left: " + golemLeft);

                if (golemLeft == 0) {
                    resultText = "Result: Victory";
                } else {
                    golemDamage = Math.abs(golemAttack - defense);
                    leftHp = hp - golemDamage;
                    System.out.println("Stone Golem hits " + tag + " for " + golemDamage + ", HP left " + leftHp);
                    resultText = "Result: The battle continues";
                }

                System.out.println(resultText);
                System.out.println("XP: " + tag + " " + earnedXp);
                input.close();
            }

        } else {
            System.out.println("Invalid name.");
        }
    }
}
