package ku.cs.services;

import ku.cs.models.FoodList;

public interface DataSource {
    FoodList getFoodsData();

    void  setFoodsData(FoodList foods);



}
