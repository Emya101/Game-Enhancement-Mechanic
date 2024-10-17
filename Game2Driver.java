import java.util.Random;

import javax.swing.JOptionPane;
public class Game2Driver {
    public static void main(String[] args) {
        System.out.println("****************************");
        System.out.println("A Knighty night");
        System.out.println("****************************");
        

        Player Participant=new Player();
        Weapon sword=new Sword();


        Ham ham=new Ham();
        Weapon hamSword=new FoodAdapter(ham);


        Bread bread=new Bread();
        Pizza pizza=new Pizza();
        Poison poison=new Poison();
        WeaponDecorator IronChant=new Iron(null);
        WeaponDecorator GoldChant=new Gold(null);
        WeaponDecorator DiamondChant=new Diamond(null);
        WeaponDecorator MagicChant=new Magic(null);


        Random rand=new Random();
        Item[] items={sword,hamSword,bread,pizza,poison,IronChant,GoldChant,DiamondChant,MagicChant};
        boolean gameProcess=false;

        while(!gameProcess){
            int random=rand.nextInt(items.length);
            Item PickupItem=items[random];

            if (PickupItem instanceof Poison) {
                int result = JOptionPane.showConfirmDialog(null, PickupItem.getDescription() + " : pick up?",null, JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    gameProcess = true;
                    System.out.println("[Ate the poison]\n");
                    System.out.println("***Game Over :(***");
                }
            }
            else{
                Participant.PickupSimulation(PickupItem);
            }
        }
    }
}
