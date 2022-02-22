package ku.cs.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FoodList {
    private ArrayList<Food> foods;

    public FoodList() {
        foods = new ArrayList<>();
    }


    private boolean checkDuplicatedFood(Food food) {
        for (Food f : foods) {
            if (f.checkFoodType(food)) {
                return true;
            }
        }
        return false;
    }

    public void addFood(Food food) {
        if (!checkDuplicatedFood(food)) {
            foods.add(food);
        }
        return;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    @Override
    public String toString() {
        return "FoodList{" +
                "foods=" + foods +
                '}';
    }
    public void removeFood(Food food) {
        foods.remove(food);
    }
}
