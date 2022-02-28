package ku.cs.services;

import ku.cs.models.FoodList;
import ku.cs.models.RefrigeratorBox;

public interface Datasource  {
    RefrigeratorBox getRefrigeratorBoxesData();

    void  setRefrigeratorBoxesData(RefrigeratorBox box);



}
