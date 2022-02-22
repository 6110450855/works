package ku.cs.models;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Food {
    private String foodName;
    private String foodType;
    private double quantity;
    private String foodUnit;
    private LocalDate buyIn, expire;
    private String imagePath;


    public Food(String foodName, String foodType, double quantity, String foodUnit) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.quantity = quantity;
        this.foodUnit = foodUnit;
    }

    public void addFoodQuantity(double num) {
        this.quantity = this.quantity + num;
    }


    public String getDurationInFridge() {
        LocalDate now = LocalDate.now();
        long duration = ChronoUnit.DAYS.between(this.buyIn, now);
        return "" + duration + " วัน";
    }

    public boolean checkFoodType(String foodType) {
        return this.foodName.equals(foodType);
    }

    public boolean checkFoodType(Food food) {
        return this.foodName.equals(food.getFoodType());
    }

    public boolean checkFoodQuantity(double num) {
        if (quantity >= num) {
            return true;
        }
        return false;
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

    public LocalDate getBuyIn() {
        return buyIn;
    }

    public LocalDate getExpire() {
        return expire;
    }

    public String getImagePath() {
        return imagePath;
    }



    public String getFoodUnit() {
        return foodUnit;
    }

    public void setFoodUnit(String foodUnit) {
        this.foodUnit = foodUnit;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setBuyIn(String buyIn) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.buyIn = LocalDate.parse(buyIn, format);
    }

    public void setExpire(String expire) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.expire = LocalDate.parse(expire, format);
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
                ", foodUnit='" + foodUnit + '\'' +
                ", buyIn=" + buyIn +
                ", expire=" + expire +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
