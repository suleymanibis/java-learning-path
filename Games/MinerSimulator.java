// This class simulates a mining process using a pickaxe durability system, 
// randomly collecting different resources (Diamond, Iron, Stone) into an inventory 
// based on specific drop probabilities.

import java.util.Random;
import java.util.HashMap;
public class MinerSimulator {
    public static void main(String[] args){
        int pickaxeDurability = 50;
        HashMap<String, Integer> inventory = new HashMap<String, Integer>();
        Random random = new Random();

        inventory.put("Elmas", 0);
        inventory.put("Demir", 0);
        inventory.put("Taş", 0);

        while (pickaxeDurability > 0) {
            int randomNumber = random.nextInt(100) + 1;

            if (randomNumber < 11){
                inventory.put("Elmas", inventory.get("Elmas") + 1);
            }
            else if (randomNumber <41)
            {
                inventory.put("Demir", inventory.get("Demir") + 1);
            }
            else
            {
                inventory.put("Taş", inventory.get("Taş") + 1);
            }

            pickaxeDurability--;
        }

        System.out.println("\nKazman kırıldı! İşte topladığın madenler: ");
        for (String item: inventory.keySet()){
            System.out.println("- " + inventory.get(item) + " adet " + item);
        }
    }
}
