package ku.cs.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
