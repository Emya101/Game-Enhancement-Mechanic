public class FoodAdapter extends Weapon {
    private Food food;

    FoodAdapter(Food food){
        this.food=food;
    }
    public String getDescription(){
        return food.getDescription();
    }

    public int getDamage(){
        return food.getEnergy();
    }

    public int getDurability(){
        return 0;
    }

    public String toString() {
        return food.getDescription();
    }
}
