import javax.swing.JOptionPane;
public class Player {
    int health;
    Weapon Sword; 
    Weapon specialWeapon;
    boolean HamWeapon=false;

    Weapon chosenWeapon;

    public Player(){
        this.health=1;
        this.Sword=null;
        this.specialWeapon=null;
    }

    public int getHealth(){
        return health;
    }

    public Weapon getWeapon(){
        if (Sword != null) {
            return Sword;
        } else {
            return specialWeapon;
        }
    }

    public void pickSword(Weapon sword){
        if(Sword==null){
            this.Sword=sword;
            chosenWeapon=sword;
            System.out.println("[New Weapon: "+sword.getDescription()+"]");
            showStats(sword);
        }
    }

    public void pickSpecialWeapon(Weapon food){
        if(specialWeapon==null){
        this.specialWeapon=food;
        this.HamWeapon=true;
        chosenWeapon=specialWeapon;
        System.out.println("[New Weapon: "+food.getDescription()+"]");
        showStats(food);
        }
    }

    public void boostHealth(Food food){
        health=food.getEnergy()+health;
        System.out.println("[Ate the "+food.getDescription()+"]");
         System.out.println("Health: "+health+" HP\n");
    }

    

    
    public void PickupSimulation(Item item){
        if(item instanceof Weapon && !(item instanceof WeaponDecorator)){
            Weapon weapon=(Weapon) item;
            int result = JOptionPane.showConfirmDialog(null, weapon.getDescription() + " : pick up?", null, JOptionPane.YES_NO_OPTION);
            if(result== JOptionPane.YES_OPTION){
                if(weapon instanceof Sword){
                    pickSword(weapon);
                }
                else if(weapon instanceof FoodAdapter){
                    if(!HamWeapon){
                        int choice=JOptionPane.showConfirmDialog(null, "Do you want to use the ham as a weapon?",null,JOptionPane.YES_NO_OPTION);
                        if(choice == JOptionPane.YES_OPTION){
                        pickSpecialWeapon(weapon);
                    }
                    }
                    else{
                        boostHealth(new Ham());
                    }
                }
            }
        }
        else if(item instanceof WeaponDecorator){
            WeaponDecorator Enhancement=(WeaponDecorator) item;
            int result = JOptionPane.showConfirmDialog(null, Enhancement.toString() + " : pick up?",null, JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION && this.Sword!= null && this.specialWeapon!=null ){
                String[] buttons = {"sword","ham"};
                int choice = JOptionPane.showOptionDialog(null,
                    "Select the weapon to enhance:",
                    null,
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    buttons,
                    buttons[1]);
                if(choice==0){
                    System.out.println("[Added Enhancement: "+Enhancement.toString()+"]");
                    Sword=Enhancement.addEnhancement(Sword);
                    showStats(Sword);
                }
                else if(choice==1){
                    System.out.println("[Added Enhancement: "+Enhancement.toString()+"]");
                    specialWeapon=Enhancement.addEnhancement(specialWeapon);
                    showStats(specialWeapon);
                }

            }else if(result==JOptionPane.YES_OPTION && Sword!=null){
                System.out.println("[Added Enhancement: "+Enhancement.toString()+"]");
                Sword=Enhancement.addEnhancement(Sword);
                    showStats(Sword);
            }
            else if(result==JOptionPane.YES_OPTION && specialWeapon!=null){
                System.out.println("[Added Enhancement: "+Enhancement.toString()+"]");
                specialWeapon=Enhancement.addEnhancement(specialWeapon);
                showStats(specialWeapon);
            }
            else if(this.Sword==null||this.specialWeapon==null){
                System.out.println("No weapon to enhance");
            }
            else{
                System.out.println("Skipped Enhancement: "+Enhancement.toString());
            }
        }
        else if(item instanceof Food){
            Food booster=(Food) item;
            int result = JOptionPane.showConfirmDialog(null, booster.getDescription() + " : pick up?",null, JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION){
                boostHealth((Food) item);
            }
            else{
                System.out.println("Skipped Food: "+booster.getDescription());
            }
        }
    }

    public void showStats(Weapon weapon){ 
        if (weapon!=null){
            System.out.println("Weapon Stats: | Damage: "+weapon.getDamage()+ " | durability: "+weapon.getDurability()+"\n");
        }
        else{
            System.out.println("Player has no weapon");
        }
    }
}
