public class Monster {
    protected String name;
    protected int hp;
    protected int damage;

    public Monster(String name, int hp, int damage){
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public void attack(){
        System.out.println(this.name + " attacked, dealing " + this.damage + " damage!");
    }
}
