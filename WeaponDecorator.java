public abstract class WeaponDecorator extends Weapon{
    protected Weapon tempWeapon;

    public WeaponDecorator(Weapon tempWeapon) {
        this.tempWeapon=tempWeapon;
    }

    public String getDescription(){
        return tempWeapon.getDescription();
    }
    
    public abstract Weapon addEnhancement(Weapon weapon);
}
