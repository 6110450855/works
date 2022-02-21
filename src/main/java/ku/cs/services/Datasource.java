package ku.cs.services;

import ku.cs.models.FoodList;
import ku.cs.models.RefrigeratorBoxList;

public interface Datasource  {
    RefrigeratorBoxList getRefrigeratorBoxesData();

    void  setRefrigeratorBoxesData(RefrigeratorBoxList refrigeratorBoxes);



}
