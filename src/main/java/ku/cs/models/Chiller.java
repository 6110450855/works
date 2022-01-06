package ku.cs.models;

public class Chiller {
    private int order;
    private Food food;

    public Chiller(int order, Food food) {
        this.order = order;
        this.food = food;
    }

    public boolean checkFood() {
        return this.food.getName().equals(food.getName());
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
