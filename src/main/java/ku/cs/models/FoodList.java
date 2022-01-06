package ku.cs.models;

import java.util.ArrayList;

public class FoodList {
    private ArrayList<Food> foods;

    public FoodList() {
        foods = new ArrayList<>();
    }

    public void add(Food food) {
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
