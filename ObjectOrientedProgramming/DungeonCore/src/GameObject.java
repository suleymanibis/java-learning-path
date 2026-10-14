public abstract class GameObject {
    protected String name;

    public GameObject(String name){
        this.name = name;
    }

    public abstract void interact();
}
