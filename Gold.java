public class Gold extends WeaponDecorator{

    public Gold(Weapon Weapon) {
        super(Weapon);
    }

    public String getDescription(){
        return tempWeapon.getDescription()+" ,Gold";
    }

    public int getDamage(){
        return tempWeapon.getDamage()+1;
    }

    public int getDurability(){
        return tempWeapon.getDurability()+2;
    }

    @Override
    public String toString() {
        return "Gold";
    }

    @Override
    public Weapon addEnhancement(Weapon weapon) {
        return new Gold(weapon);
    }
    
}