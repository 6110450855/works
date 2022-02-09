package ku.cs.models;

public class Refrigerator {
    private RefrigeratorBox box;

    public Refrigerator(RefrigeratorBox box) {
        this.box = box;
    }

    public RefrigeratorBox getBox() {
        return box;
    }
}
