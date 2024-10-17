public abstract class Weapon implements Item{
    protected String description;
    protected int damage;
    protected int durability;
    
    public String getDescription(){
        return this.description;
    }

    public int getDamage(){
        return this.damage;
    }

    public int getDurability(){
        return this.durability;
    }


    public abstract String toString();
}
