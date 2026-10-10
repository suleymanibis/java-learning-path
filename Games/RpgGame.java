package Games;
// This class implements a turn-based text RPG combat simulator 
// where a player fights a dragon using fast attacks, heavy attacks with a miss chance, and healing potions.

import java.util.Scanner;
import java.util.Random;

public class RpgGame {
    public static void main(String[] args){
        final int POTION_HEALING_COUNT = 30;
        final int SELF_MAX_HEALTH = 100;
        final int DRAGON_MAX_HEALTH = 100;
        final int MAX_POTION_COUNT = 3;

        int selfCurrentHealth = SELF_MAX_HEALTH;
        int dragonCurrentHealth = DRAGON_MAX_HEALTH;
        int potionCount = MAX_POTION_COUNT;
        int damage;

        String resultText = "";

        Scanner input = new Scanner(System.in);
        Random rnd = new Random();

        while(dragonCurrentHealth > 0 && selfCurrentHealth > 0){
            System.out.println("""
                    1- Hızlı Saldırı
                    2- Ağır Saldırı
                    3- Can İksiri
            """);

            System.out.print("Lütfen bir atak seçimi yapın (1-3): ");
            int choice = input.nextInt();

            switch(choice){
                case 1:
                    damage = rnd.nextInt(15, 25) + 1;
                    dragonCurrentHealth -= damage;

                    resultText = String.format("---------------------------\nDüşmana %d hasar verdin!\n---------------------------\n", damage);
                    break;
                case 2:
                    int possibility = rnd.nextInt(1, 100) + 1;

                    if (possibility <= 50){
                        resultText = "---------------------------\nDüşmana hiç hasar veremedin!\nŞansın yaver gitmedi.\n---------------------------\n";
                    }
                    else{
                        damage = rnd.nextInt(30, 50) + 1;
                        dragonCurrentHealth -= damage;

                        resultText = String.format("---------------------------\nDüşmana kritik bir atış yaptın ve %d hasar verdin!\n---------------------------\n", damage);
                    }
                    break;
                case 3:
                    if (potionCount > 0) {
                        selfCurrentHealth += POTION_HEALING_COUNT;

                        if (selfCurrentHealth > SELF_MAX_HEALTH){
                            selfCurrentHealth = SELF_MAX_HEALTH;
                        }

                        potionCount--;

                        resultText = String.format("---------------------------\nBir iksir kullandın ve %d can kazandın!\nMevcut iksir sayın: %d\n---------------------------\n", POTION_HEALING_COUNT, potionCount);

                    }
                    else {
                        resultText = "---------------------------\nŞuanda hiç iksirin yok!\n---------------------------\n";
                    }
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptın!");
                    continue;
            }

            System.out.println(resultText);
            System.out.println("Şimdi Ejderhanın sırası!");

            if(dragonCurrentHealth > 0){
                int dragonDamage = rnd.nextInt(10,40);

                selfCurrentHealth -= dragonDamage;

                resultText = String.format("---------------------------\nEjderha sana %d hasar verdi!\n---------------------------\n", dragonDamage);
                System.out.println(resultText);
            }
        }

        if(selfCurrentHealth < 0){
            selfCurrentHealth = 0;
        }

        if(dragonCurrentHealth < 0){
            dragonCurrentHealth = 0;
        }

        System.out.printf("Oyun Bitti!\nSenin canın: %d\nDüşmanın canı: %d\n", selfCurrentHealth, dragonCurrentHealth);

        if (selfCurrentHealth > dragonCurrentHealth){
            System.out.println("---------------------------\nTebrikler, oyunu sen kazandın!\n---------------------------");
        } else {
            System.out.println("---------------------------\nMaalesef oyunu kaybettin!\nEjderha seni yaktı geçti.\n---------------------------");
        }
    }
}
