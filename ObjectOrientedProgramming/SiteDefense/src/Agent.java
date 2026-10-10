public class Agent {
    private String name;
    private int credits;
    private Weapon equippedWeapon;

    public Agent(String name){
        this.name = name;
        this.credits = 3000;
        equippedWeapon = null;
    }

    public void buyWeapon(Weapon targetWeapon){
        if(this.credits >= targetWeapon.getPrice()){
            this.credits -= targetWeapon.getPrice();
            this.equippedWeapon = targetWeapon;

            System.out.println("Info: " + targetWeapon.getName() + " was bought!");
        } else {
            System.out.println("Error: Not enough credit!");
        }
    }

    public void displayLoadouts(){
        String weaponName = this.equippedWeapon == null ? "only knife" : this.equippedWeapon.getName();
        System.out.printf("""
                
                ===== AGENT INFO =====
                Agent name: %s
                Current credits: %d credits
                Current weapon: %s
                ======================
                
                """,
                this.name, this.credits, weaponName);
    }
}
