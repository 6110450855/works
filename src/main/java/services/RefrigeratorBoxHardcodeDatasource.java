package services;


import ku.cs.models.RefrigeratorBox;
import ku.cs.models.RefrigeratorBoxList;


public class RefrigeratorBoxHardcodeDatasource implements Datasource<RefrigeratorBoxList> {

    @Override
    public RefrigeratorBoxList readData() {

        RefrigeratorBoxList boxes = new RefrigeratorBoxList();

        RefrigeratorBox one = new RefrigeratorBox("Freezer", 1, "ไอติม", "ของหวาน", 2.5,"25/12/2021", "03/05/2022");
        boxes.add(one);

        return boxes;
    }

    @Override
    public void writeData(RefrigeratorBoxList boxes) {

    }
}





