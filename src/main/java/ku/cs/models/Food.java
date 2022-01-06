package ku.cs.models;

import javafx.scene.image.Image;

public class Food {
    private String name, foodType;
    private double quantity;
    //private LocalDate buyInDate, expireDate;
    private Image foodImage;

    public Food(String name, String foodType, double quantity) {
        this.name = name;
        this.foodType = foodType;
        this.quantity = quantity;
    }

    public boolean checkName(String name) {
        return this.name.equals(name);
    }

    public boolean checkName(Food food) {
        return this.name.equals(food.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

//    public LocalDate getBuyInDate() {
//        return buyInDate;
//    }
//
//    public void setBuyInDate(LocalDate buyInDate) {
//        this.buyInDate = buyInDate;
//    }
//
//    public LocalDate getExpireDate() {
//        return expireDate;
//    }
//
//    public void setExpireDate(LocalDate expireDate) {
//        this.expireDate = expireDate;
//    }

    public Image getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(Image foodImage) {
        this.foodImage = foodImage;
    }
}
