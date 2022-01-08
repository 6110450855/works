package ku.cs.models;

import javafx.scene.image.Image;

import java.time.LocalDate;

public class RefrigeratorBox {
    private String type; // Freezer, Chiller
    private int daysInFridge;
    private int number;
    private String foodName, foodType;
    private double quantity;
    private LocalDate buyInDate, expireDate;
    private Image foodImage;

    public RefrigeratorBox(String type, int number, String foodName, String foodType, double quantity) {
        this.type = type;
        this.daysInFridge = 0;
        this.number = number;
        this.foodName = foodName;
        this.foodType = foodType;
        this.quantity = quantity;
    }

    public boolean checkName(String name) {
        return this.foodName.equals(name);
    }

    public boolean checkName(RefrigeratorBox box) {
        return this.foodName.equals(box.getFoodName());
    }

    public String getType() {
        return type;
    }

    public int getDaysInFridge() {
        return daysInFridge;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public double getQuantity() {
        return quantity;
    }

    public Image getFoodImage() {
        return foodImage;
    }
}
