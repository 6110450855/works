package ku.cs.models;

public class RefrigeratorBox {
    private String type; // Freezer, Chiller
    private int daysInFridge;
    private int order;
    private FoodList foods;
    private Food food;

    public RefrigeratorBox(String type, int order) {
        this.type = type;
        this.order = order;
        foods = new FoodList();
    }

    public RefrigeratorBox(String type, int order, Food food) {
        this.type = type;
        this.order = order;
        this.food = food;
    }

    public void setDaysInFridge(int daysInFridge) {
        this.daysInFridge = daysInFridge;
    }

    public FoodList getFoods() {
        return foods;
    }

    public boolean checkAndSetType(String type) {
        if ((type == "Freezer") || (type == "Chiller")) {
            this.type = type;
            return true;
        }
        return false;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public boolean checkAndSetOrder(int order) {
        if (((this.type == "Freezer") && ((order == 1) || (order == 2)))) {
            this.order = order;
            return true;
        }

        else if (((this.type == "Chiller") && ((order >= 1) && (order <= 6)))) {
            this.order = order;
            return true;
        }
        return false;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public int getOrder() {
        return order;
    }

    public String getType() {
        return type;
    }

    public int getDaysInFridge() {
        return daysInFridge;
    }

}
