public class Diamond extends WeaponDecorator{

    public Diamond(Weapon Weapon) {
        super(Weapon);
    }

    public String getDescription(){
        return tempWeapon.getDescription()+ ",Diamond";
    }

    public int getDamage(){
        return tempWeapon.getDamage()+2;
    }

    public int getDurability(){
        return tempWeapon.getDurability()+1;
    }

    @Override
    public String toString() {
        return "Diamond";
    }

    @Override
    public Weapon addEnhancement(Weapon weapon) {
        return new Diamond(weapon);
    }
    
}
