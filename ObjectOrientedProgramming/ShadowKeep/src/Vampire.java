public class Vampire extends Monster {

    public Vampire(String name) {
        super(name, 100, 25);
    }

    @Override
    public void attack() {
        this.hp += 15;

        if (this.hp > 100) {
            this.hp = 100;
        }

        System.out.println(this.name + " performed a life-stealing attack! It dealt " + this.damage + " damage and restored 15 HP. Current HP: " + this.hp);
    }
}
