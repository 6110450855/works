package ku.cs.models;

import java.util.ArrayList;

public class Refrigerator extends RefrigeratorBoxList{
    private String brand;

    public Refrigerator(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void add(RefrigeratorBox refrigeratorBox) {
        super.add(refrigeratorBox);
    }

    @Override
    public ArrayList<RefrigeratorBox> getRefrigeratorBoxes() {
        return super.getRefrigeratorBoxes();
    }

}
