package ku.cs.models;

import java.util.ArrayList;

public class Refrigerator extends RefrigeratorBoxList {
    private RefrigeratorBox box;
    private ArrayList<RefrigeratorBoxList> boxes;

    public Refrigerator() {
        super();
        boxes = new ArrayList<>();
    }

    @Override
    public void add(RefrigeratorBox refrigeratorBox) {
        super.add(refrigeratorBox);
    }

    @Override
    public ArrayList<RefrigeratorBox> getRefrigeratorBoxes() {
        return super.getRefrigeratorBoxes();
    }

    public RefrigeratorBox getBox() {
        return box;
    }
}
