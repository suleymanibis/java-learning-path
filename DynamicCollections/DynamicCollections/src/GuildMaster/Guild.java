package GuildMaster;

import java.util.ArrayList;

public class Guild {
    private String guildName;
    private ArrayList<Hero> roster;

    public Guild(String guildName){
        this.guildName = guildName;

        roster = new ArrayList<Hero>();
    }

    public void recruit(Hero hero){
        roster.add(hero);
    }

    public void kick(String heroName){
        if(!(roster.isEmpty())){
            boolean isKicked = false;
            Hero kickedHero = null;
            for (Hero hero: roster){
                if (hero.getName().equals(heroName)) {
                    kickedHero = hero;
                    isKicked = true;
                }
            }


            if(!isKicked){
                System.out.printf("Error: Cannot found any player called %s in the guild!", heroName);
                System.out.println();
            } else {
                roster.remove(kickedHero); // to prevent ConcurrentModificationException
                System.out.printf("\nInfo: %s was kicked from the guild!", kickedHero.getName());
                System.out.println();
            }
        } else {
            System.out.println("Error: Now, this guild is empty!");
        }
    }

    public void showRoster(){
        if(!(roster.isEmpty())){
            int i = 1;
            System.out.println("==== MEMBERS LIST ====");
            for(Hero h: roster){
                System.out.printf("%d. %s | %s | Level: %d\n", i, h.getName(), h.getRole(), h.getLevel());
                i++;
            }
            System.out.println("\n======================");
        } else {
            System.out.println("Error: Now, this guild is empty!");
        }
    }
}
