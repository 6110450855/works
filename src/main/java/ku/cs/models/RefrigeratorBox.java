package ku.cs.models;

import javafx.scene.image.Image;

import java.time.LocalDate;

public class RefrigeratorBox {
    private String type; // Freezer, Chiller
    private int number;
    private String foodName, foodType;
    private double quantity;
    private String buyInDate, expireDate;
    private int daysInFridge;
    private String foodImage;

    public RefrigeratorBox(String type, int number, String foodName, String foodType, double quantity, String buyInDate, String expireDate) {
        this.type = type;
        this.number = number;
        this.foodName = foodName;
        this.foodType = foodType;
        this.quantity = quantity;
        this.buyInDate = buyInDate;
        this.expireDate = expireDate;
        this.daysInFridge = 0;
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

    public String getBuyInDate() {
        return buyInDate;
    }

    public void setBuyInDate(String buyInDate) {
        this.buyInDate = buyInDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }
}
