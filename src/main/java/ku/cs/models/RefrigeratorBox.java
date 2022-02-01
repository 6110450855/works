package ku.cs.models;

import javafx.scene.image.Image;

import java.time.LocalDate;

public class RefrigeratorBox {
    private String boxType; // Freezer, Chiller
    private int boxNumber;
    private FoodList foods;

    public RefrigeratorBox(String boxType, int boxNumber) {
        this.boxType = boxType;
        this.boxNumber = boxNumber;
        foods = new FoodList();
    }

    public void takeFoodIn(Food food) {
        foods.addFood(food);
    }

    public String getBoxType() {
        return boxType;
    }

    public int getBoxNumber() {
        return boxNumber;
    }

    public FoodList getFoods() {
        return foods;
    }

    @Override
    public String toString() {
        return "ช่องแช่ : " + boxType + " | หมายเลข : " + boxNumber;
    }
}
