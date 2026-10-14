public class NPC extends GameObject{

    public NPC(String name){
        super(name);
    }

    @Override
    public void interact(){
        System.out.printf("\n%s says: Welcome to my dungeon, dude!", this.name);
        System.out.println();
    }
}
