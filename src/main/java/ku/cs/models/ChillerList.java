package ku.cs.models;

import java.util.ArrayList;

public class ChillerList {
    private ArrayList<Chiller> chillers;

    public ChillerList() {
        chillers = new ArrayList<>();
    }

    private boolean checkDifferentFood(Chiller chiller) {
        for (Chiller c : chillers) {
            if (c.checkFood()) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Chiller> getChillers() {
        return chillers;
    }

    public void addFoodToChiller(Chiller chiller) {
        if (checkDifferentFood(chiller)) {
            return;
        }
        chillers.add(chiller);
    }

    public void getTotalDaysInChiller() {
        int total = 0;
        for (Chiller chiller : chillers) {
            total += chiller.getFood().getDaysInFridge();
        }
    }

    @Override
    public String toString() {
        return "ChillerList{" +
                "chillers=" + chillers +
                '}';
    }
}
