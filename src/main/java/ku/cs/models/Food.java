package ku.cs.models;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;

public class Food {
    private String foodName;
    private String foodType;
    private int quantity;
    private LocalDateTime buyIn, expire;
    private String imagePath;

    public Food(String foodName, String foodType, int quantity) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.quantity = quantity;
    }

    public void addFoodQuantity(int num) {
        this.quantity = this.quantity + num;
    }

    public void putOutFood(int num) {
        if (num <= this.quantity) {
            this.quantity = this.quantity - num;
        }

    }

    public void getDurationInFridge() {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, this.buyIn);
    }

    public boolean checkFoodType(String foodType) {
        return this.foodName.equals(foodType);
    }

    public boolean checkFoodType(Food food) {
        return this.foodName.equals(food.getFoodType());
    }


    public String getFoodName() {
        return foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getBuyIn() {
        return buyIn;
    }

    public LocalDateTime getExpire() {
        return expire;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBuyIn(LocalDateTime buyIn) {
        this.buyIn = buyIn;
    }

    public void setExpire(LocalDateTime expire) {
        this.expire = expire;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                ", foodType='" + foodType + '\'' +
                ", quantity=" + quantity +
                ", buyIn=" + buyIn +
                ", expire=" + expire +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
