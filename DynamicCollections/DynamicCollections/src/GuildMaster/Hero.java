package GuildMaster;

public class Hero {
    private String name;
    private String role;
    private int level;

    public Hero(String name, String role, int level){
        this.name = name;
        this.role = role;
        this.level = level;
    }

    public String getName(){
        return this.name;
    }

    public String getRole(){
        return this.role;
    }

    public int getLevel(){
        return this.level;
    }
}
