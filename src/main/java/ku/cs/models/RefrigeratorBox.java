package ku.cs.models;


import java.util.ArrayList;


public class RefrigeratorBox {
    private String boxType; // Freezer, Chiller
    private int boxNumber;
    private ArrayList<Food> foods;
    private Food food;
    private FoodList foodList;

    public RefrigeratorBox() {
    }

    public RefrigeratorBox(String boxType, int boxNumber) {
        this.boxType = boxType;
        this.boxNumber = boxNumber;
        foods = new ArrayList<>();
        foodList = new FoodList();
    }

    public void add(Food food) {
        this.food = food;
        foods.add(food);
    }

    public void addFoodList(FoodList foodList) {
        this.foodList = foodList;
    }

    public void takeFoodIn(Food food) {
        foods.add(food);
    }

    public String getBoxType() {
        return boxType;
    }

    public int getBoxNumber() {
        return boxNumber;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public FoodList getFoodList() {
        return foodList;
    }

    public Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "ช่องแช่ : " + boxType + " | หมายเลข : " + boxNumber;
    }
}
