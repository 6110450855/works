package ku.cs.models;

import java.util.ArrayList;

public class RefrigeratorBoxList {
    private ArrayList<RefrigeratorBox> refrigeratorBoxes;

    public RefrigeratorBoxList() {
        refrigeratorBoxes = new ArrayList<>();
    }

    public void add(RefrigeratorBox refrigeratorBox) {
        refrigeratorBoxes.add(refrigeratorBox);
    }

    public ArrayList<RefrigeratorBox> getRefrigeratorBoxes() {
        return refrigeratorBoxes;
    }

    @Override
    public String toString() {
        return "RefrigeratorBoxList{" +
                "refrigeratorBoxes=" + refrigeratorBoxes +
                '}';
    }
}