package ku.cs.models;

import java.util.ArrayList;

public class FoodList {
    private ArrayList<Food> foods;

    public FoodList() {
        foods = new ArrayList<>();
    }

    public boolean checkDuplicateFood(Food food) {
        for (Food f : foods) {
            if (f.checkName(food)) {
                return true;
            }
        }
        return false;
    }

    public void add(Food food) {
        if (checkDuplicateFood(food)) {
            return;
        }
        foods.add(food);
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
}
