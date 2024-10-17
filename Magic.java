public class Magic extends WeaponDecorator{

    public Magic(Weapon Weapon) {
        super(Weapon);
    }

    public String getDescription(){
        return tempWeapon.getDescription()+ ",Magic";
    }

    public int getDamage(){
        return tempWeapon.getDamage()+3;
    }

    public int getDurability(){
        return tempWeapon.getDurability()+3;
    }

    @Override
    public String toString() {
        return "Magic";
    }

    @Override
    public Weapon addEnhancement(Weapon weapon) {
       return new Magic(weapon);
    }

    
    
}
