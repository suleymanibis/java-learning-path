public class Hero {
    String name;
    int hp;
    int maxHp;
    protected boolean isDead = false;

    public void takeDamage(int damage) {
        hp -= damage;

        if (hp <= 0) {
            hp = 0;
            System.out.println("Character is dead!");
            isDead = true;
        }
    }

    public void heal(int amount) {
        hp += amount;

        if (hp > maxHp){
            hp = maxHp;
        }
    }

    public void displayStats(){
        System.out.printf("\nCharacter: %s | HP: %d/%d\n", name, hp, maxHp);
    }
}
