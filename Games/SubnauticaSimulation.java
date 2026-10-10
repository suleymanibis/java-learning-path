package Games;
// This class implements a text-based Subnautica diving simulation 
// where the player manages oxygen levels, collects resources, avoids random Leviathan attacks, 
// and must safely return to base before drowning.

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SubnauticaSimulation {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String RANDOM = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String SILVER = "\u001B[97m";
    public static void main(String[] args) {
        final double MAX_OXYGEN_AMOUNT = 100;

        int diamondAmount = 0;
        int titaniumAmount = 0;
        double currentOxygenAmount = MAX_OXYGEN_AMOUNT;

        TreeMap<String, Integer> inventory = new TreeMap<String, Integer>();
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        inventory.put("Elmas \uD83D\uDC8E", diamondAmount);
        inventory.put("Titanyum \uD83D\uDD18", titaniumAmount);

        System.out.println("Merhaba reis, Subnautica'ya hoşgeldin.");
        System.out.println("Oyunun amacı okyanusa dalış yaparak madenler toplamak. Tabii bunu yaparken oksijen seviyene çok dikkat etmelisin.");
        System.out.println("Başlangıçta " + MAX_OXYGEN_AMOUNT + " oksijen miktarıyla oyuna başlarsın.");
        System.out.println("Belirli seçimler yaparak okyanusun altından elmas veya titanyum toplarsın.");
        System.out.println("Ha, bu arada, bazen garip bir canavar seni rahatsız edip oksijenini boşa kullanmana sebep olabilir.");
        System.out.println("----------------------------------");
        System.out.println("İşte envanterin: ");
        for (String element : inventory.keySet()) {
            System.out.printf("%s: %d adet ", element, inventory.get(element));
        }
        System.out.println("\n");

        game:
        while (currentOxygenAmount > 0) {

            System.out.println("""
                    İşte seçeneklerin:
                    1- Derine dalış yap.
                    2- Etrafı araştır.
                    3- Yüzeye çık.
                    4- Üsse dön (çıkış).
                    """);

            System.out.print("Lütfen bir seçim yap: ");
            int choice = input.nextInt();
            int possibility = random.nextInt(0, 101);
            String resultText = "";
            int bossPossibility = random.nextInt(0, 101);

            switch (choice) {
                case 1:
                    currentOxygenAmount -= 25;

                    if (bossPossibility <= 20) {
                        currentOxygenAmount -= 15;
                        System.out.println(RED + "!!!  Reaper Leviathan \uD83D\uDD31 saldırdı! Kaçarken fazladan 15 oksijen kaybettin!  !!!" + RESET);
                    }

                    if (possibility > 40 && possibility <= 100) {
                        diamondAmount += 1;
                        resultText = "Tebrikler "+ RANDOM +"1 adet elmas \uD83D\uDC8E" + RESET + " buldun! Yeni oksijen seviyen: " + currentOxygenAmount;
                    } else {
                        resultText = "Maalesef okyanusun dibinden elin boş döndün. Yeni oksijen seviyen: " + currentOxygenAmount;
                    }
                    break;
                case 2:
                    currentOxygenAmount -= 10;

                    if (bossPossibility <= 20) {
                        currentOxygenAmount -= 15;
                        System.out.println(RED + "!!!  Reaper Leviathan \uD83D\uDD31 saldırdı! Kaçarken fazladan 15 oksijen kaybettin!  !!!" + RESET);
                    }

                    if (possibility > 20 && possibility <= 100) {
                        titaniumAmount += 1;
                        resultText = "Tebrikler" +  SILVER + " 1 adet titanyum" + RESET + "\uD83D\uDD18 buldun! Yeni oksijen seviyen: " + currentOxygenAmount;
                    } else {
                        resultText = "Maalesef yüzeyde hiçbir maden bulamadın. Yeni oksijen seviyen: " + currentOxygenAmount;
                    }
                    break;
                case 3:
                    if (currentOxygenAmount == 100){
                        System.out.println("Zaten oksijenin maksimum!");
                    }else{
                        System.out.println();
                        System.out.println(RANDOM + "...yüzeye çıkılıyor...\uD83E\uDEE7" + RESET);
                        try {
                            double amount = 100 - currentOxygenAmount;
                            for (int i = 1; i <= 4; i++){
                                TimeUnit.SECONDS.sleep(1);
                                currentOxygenAmount += (amount/4);
                                System.out.println(GREEN + "Yeni oksijen miktarı: " + currentOxygenAmount + RESET);
                            }

                            resultText = "Bu tur dinlenmeyi seçtin demek. İşte yeni oksijen seviyen: " + currentOxygenAmount;

                        }catch (InterruptedException e){
                            System.out.println("Sistem hatası");
                        }
                    }

                    System.out.println();
                    break;

                case 4:
                    System.out.println();
                    System.out.println("\uD83D\uDEA2 Üsse dönülüyor...");
                    try {
                        for (int i = 1; i <= 4; i++){
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println("...");
                        }

                        System.out.println("⚓");

                    }catch (InterruptedException e){
                        System.out.println("Sistem hatası");
                    }
                    break game;
                default:
                    System.out.println("Dostum, olmayan bir seçeneği seçemezsin!");
                    continue;

            }

            if (currentOxygenAmount < 0) {
                currentOxygenAmount = 0;
            }

            System.out.println(resultText);
        }

        if (currentOxygenAmount > 0) {
            inventory.put("Elmas \uD83D\uDC8E", inventory.get("Elmas \uD83D\uDC8E") + diamondAmount);
            inventory.put("Titanyum \uD83D\uDD18", inventory.get("Titanyum \uD83D\uDD18") + titaniumAmount);

            System.out.println("\nTebrikler boğulmadan üsse döndün. İşte topladıkların: ");

            for (String element : inventory.keySet()) {
                System.out.printf("%s: %d adet ", element, inventory.get(element));
            }
            System.out.println("\n");
        } else {
            System.out.println("Maalesef boğuldun! Geçmiş olsun tüm topladıkların okyanusta kayboldu!");
        }

        input.close();
    }
}
