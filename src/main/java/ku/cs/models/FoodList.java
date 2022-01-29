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
        if (checkDuplicatedFood(food)) {
            return;
        }
        foods.add(food);
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }
}
