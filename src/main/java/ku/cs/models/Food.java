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
    private int quantity;
    private String foodUnit;
    private LocalDate buyIn, expire;
    private String imagePath;
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Food(String foodName, String foodType, int quantity, String foodUnit) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.quantity = quantity;
        this.foodUnit = foodUnit;
    }

    public void addFoodQuantity(int num) {
        this.quantity = this.quantity + num;
    }

    public void putOutFood(int num) {
        if (num <= this.quantity) {
            this.quantity = this.quantity - num;
        }

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


    public String getFoodName() {
        return foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public int getQuantity() {
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

    public DateTimeFormatter getFormat() {
        return format;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBuyIn(String buyIn) {
        this.buyIn = LocalDate.parse(buyIn, format);
    }

    public void setExpire(String expire) {
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
                ", buyIn=" + buyIn.format(format) +
                ", expire=" + expire.format(format) +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
