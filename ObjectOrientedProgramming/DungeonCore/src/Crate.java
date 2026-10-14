public class Crate extends GameObject implements Destructible {
    private int hp = 50;

    public Crate(String name){
        super(name);
    }

    @Override
    public void takeDamage(int damage) {
        this.hp -= damage;

        if (this.hp <= 0) {
            this.hp = 0;
            System.out.printf("\n%s was smashed! You have found a gold!", this.name);
            System.out.println();
        }
    }

    @Override
    public void interact() {
        System.out.printf("\n%s is being examined... This is an ordinary wooden chest!", this.name);
        System.out.println();
    }
}
