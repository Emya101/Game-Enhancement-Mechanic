public class Sword extends Weapon{

    public Sword() {
        this.damage=2;
        this.durability=1;
    }

    public int getDamage(){
        return this.damage;
    }

    public int getDurability(){
        return this.durability ;
    }

    public String getDescription(){
        return "Sword";
    }

    public String toString(){
        return getDescription();
    }
    
}
