package ku.cs.models;

import java.util.ArrayList;

public class FreezerList {
    private ArrayList<Freezer> freezers;

    public FreezerList() {
        freezers = new ArrayList<>();
    }

    private boolean checkDifferentFood(Freezer freezer) {
        for (Freezer f : freezers) {
            if (f.checkFood()) {
                return false;
            }
        }
        return true;
    }

    public void addFoodToFreezer(Freezer freezer) {
        if (checkDifferentFood(freezer)) {
            return;
        }
        freezers.add(freezer);
    }

    public ArrayList<Freezer> getFreezers() {
        return freezers;
    }

    @Override
    public String toString() {
        return "FreezerList{" +
                "freezers=" + freezers +
                '}';
    }
}
