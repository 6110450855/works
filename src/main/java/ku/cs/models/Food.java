package ku.cs.models;

import javafx.scene.image.Image;

import java.time.LocalDate;

public class Food {
    private String name, type;
    private double quantity;
    private LocalDate buyInDate, expireDate;
    private int daysInFridge;
    private Image foodImage;

    public Food(String name, String type, double quantity, LocalDate buyInDate, LocalDate expireDate, int daysInFridge) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.buyInDate = buyInDate;
        this.expireDate = expireDate;
        this.daysInFridge = daysInFridge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public LocalDate getBuyInDate() {
        return buyInDate;
    }

    public void setBuyInDate(LocalDate buyInDate) {
        this.buyInDate = buyInDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public int getDaysInFridge() {
        return daysInFridge;
    }

    public void setDaysInFridge(int daysInFridge) {
        this.daysInFridge = daysInFridge;
    }

    public Image getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(Image foodImage) {
        this.foodImage = foodImage;
    }
}
