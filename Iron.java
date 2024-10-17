public class Iron extends WeaponDecorator{

    public Iron(Weapon Weapon) {
        super(Weapon);
    }

    public String getDescription(){
        return tempWeapon.getDescription()+" ,Iron";
    }

    public int getDamage(){
        return tempWeapon.getDamage()+1;
    }

    public int getDurability(){
        return tempWeapon.getDurability()+1;
    }

    @Override
    public String toString(){
        return "Iron";
    }

    @Override
    public Weapon addEnhancement(Weapon weapon) {
        return new Iron(weapon);
    }
    
}
