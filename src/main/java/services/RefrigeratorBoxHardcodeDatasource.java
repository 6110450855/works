package services;


import ku.cs.models.RefrigeratorBox;
import ku.cs.models.RefrigeratorBoxList;


public class RefrigeratorBoxHardcodeDatasource implements Datasource<RefrigeratorBoxList> {

    @Override
    public RefrigeratorBoxList readData() {

        RefrigeratorBoxList boxes = new RefrigeratorBoxList();

        RefrigeratorBox one = new RefrigeratorBox("Freezer", 1, "ไอติม", "ของหวาน", 3);
        boxes.add(one);

        RefrigeratorBox two = new RefrigeratorBox("Freezer", 2, "อกไก่", "อาหารสด", 6);
        boxes.add(two);

        RefrigeratorBox three = new RefrigeratorBox("Freezer", 3, "หัวหมู", "อาหารสด", 1);
        boxes.add(three);

        RefrigeratorBox four = new RefrigeratorBox("Chiller", 4, "ไข่ไก่", "อาหารสด", 10);
        boxes.add(four);

        RefrigeratorBox five = new RefrigeratorBox("Chiller", 5, "ขนมช๊อคโกแลต", "ขนม", 3);
        boxes.add(five);

        RefrigeratorBox six = new RefrigeratorBox("Chiller", 6, "น้ำอัดลมรสส้ม", "เครื่องดื่ม", 2);
        boxes.add(six);

        RefrigeratorBox seven = new RefrigeratorBox("Chiller", 7, "น้ำเปล่า", "เครื่องดื่ม", 5);
        boxes.add(seven);

        RefrigeratorBox eight = new RefrigeratorBox("Chiller", 8, "ขนมปอเปี๊ยะลาวา", "ขนม", 10);
        boxes.add(eight);



        return boxes;
    }

    @Override
    public void writeData(RefrigeratorBoxList boxes) {

    }
}

