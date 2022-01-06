package services;


import ku.cs.models.Food;
import ku.cs.models.FoodList;
import ku.cs.models.RefrigeratorBox;
import ku.cs.models.RefrigeratorBoxList;


public class RefrigeratorBoxHardcodeDatasource implements Datasource<RefrigeratorBoxList> {

    @Override
    public RefrigeratorBoxList readData() {

        RefrigeratorBoxList boxes = new RefrigeratorBoxList();

        RefrigeratorBox one = new RefrigeratorBox("Freezer", 1);
        one.addFood(new Food("ไข่ไก่", "ของสด", 5));
        boxes.add(one);

        RefrigeratorBox two = new RefrigeratorBox("Freezer", 2);
        two.addFood(new Food("ปลาแซลมอน", "ของสด", 10));
        boxes.add(two);

        RefrigeratorBox three = new RefrigeratorBox("Chiller", 3);
        three.addFood(new Food("น้ำอัดลมน้ำส้ม", "เครื่องดื่ม", 1));
        boxes.add(three);

        RefrigeratorBox four = new RefrigeratorBox("Chiller", 4);
        four.addFood(new Food("ช็อคโกแล9", "เครื่องดื่ม", 1));
        boxes.add(four);

        return boxes;
    }

    @Override
    public void writeData(RefrigeratorBoxList boxes) {

    }
}





