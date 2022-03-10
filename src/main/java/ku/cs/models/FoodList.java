package ku.cs.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FoodList extends Food {
    private ArrayList<Food> foods;

    public FoodList() {
        foods = new ArrayList<>();
    }

    public FoodList(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public FoodList(String boxType, int boxNumber, String foodName, String foodType, double quantity, String foodUnit, ArrayList<Food> foods) {
        super(boxType, boxNumber, foodName, foodType, quantity, foodUnit);
        this.foods = foods;
    }

    @Override
    public boolean checkFoodName(Food food) {
        for (Food f : foods) {
            if (f.checkFoodName(food)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkFoodName(String foodName) {
        for (Food f : foods) {
            if (f.getFoodName().equals(foodName)) {
                return super.checkFoodName(foodName);
            }
        }
        return false;
    }

    public void addFood(Food food) {
        if (!checkFoodName(food)) {
            foods.add(food);
        }
        return;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void sortExpire() {
        Collections.sort(foods, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return (o1.getExpire().compareTo(o2.getExpire()));
            }
        });
    }

    public String getImagePath() {
        String path = null;
        for (Food f : foods) {
            sortExpire();
            path = f.getImagePath();
        }
        return path;
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
