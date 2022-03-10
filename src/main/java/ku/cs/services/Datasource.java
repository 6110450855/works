package ku.cs.services;

import ku.cs.models.FoodList;

public interface Datasource  {
    FoodList getFoodsData();

    void  setFoodsData(FoodList foods);



}
