package ku.cs.services;


import ku.cs.models.Food;
import ku.cs.models.RefrigeratorBox;
import ku.cs.models.RefrigeratorBoxList;

import java.time.format.DateTimeFormatter;


public class RefrigeratorBoxHardcodeDatasource implements Datasource<RefrigeratorBoxList> {

    @Override
    public RefrigeratorBoxList readData() {

        RefrigeratorBoxList boxes = new RefrigeratorBoxList();

        //Freezer
        Food food1 = new Food("ไอติม", "ของหวาน", 3 );
        RefrigeratorBox freezer1 = new RefrigeratorBox("Freezer", 1);
        freezer1.takeFoodIn(food1);
        boxes.add(freezer1);

        Food food2 = new Food("อกไก่", "อาหารสด", 6);
        RefrigeratorBox freezer2 = new RefrigeratorBox("Freezer", 2);
        freezer2.takeFoodIn(food2);
        boxes.add(freezer2);

        //Chiller
        Food food3 = new Food("หัวหมู", "อาหารสด", 1);
        RefrigeratorBox chiller1 = new RefrigeratorBox("Chiller", 1);
        chiller1.takeFoodIn(food3);
        boxes.add(chiller1);

        Food food4 = new Food("ไข่ไก่", "อาหารสด", 10);
        RefrigeratorBox chiller2 = new RefrigeratorBox("Chiller", 2);
        chiller2.takeFoodIn(food4);
        boxes.add(chiller2);

        Food food5 = new Food("ขนมช๊อคโกแลต" , "ของกินเล่น", 5);
        RefrigeratorBox chiller3 = new RefrigeratorBox("Chiller", 3);
        chiller3.takeFoodIn(food5);
        boxes.add(chiller3);

        Food food6 = new Food("นมจืดกลิ่นกล้วยหอม" , "ผลิตภัณฑ์นม", 2);
        RefrigeratorBox chiller4 = new RefrigeratorBox("Chiller", 4);
        chiller4.takeFoodIn(food6);
        boxes.add(chiller4);

        Food food7 = new Food("น้ำเปล่า" , "เครื่องดื่ม", 3);
        RefrigeratorBox chiller5 = new RefrigeratorBox("Chiller", 5);
        chiller5.takeFoodIn(food7);
        boxes.add(chiller5);

        Food food8 = new Food("บัวลอย" , "ของหวาน", 3);
        RefrigeratorBox chiller6 = new RefrigeratorBox("Chiller", 6);
        chiller6.takeFoodIn(food8);
        boxes.add(chiller6);





        //        RefrigeratorBox five = new RefrigeratorBox("Chiller", 5, "ขนมช๊อคโกแลต", "ขนม", 3,"28/12/2021", "02/05/2022");
//        boxes.add(five);
//
//        RefrigeratorBox six = new RefrigeratorBox("Chiller", 6, "น้ำอัดลมรสส้ม", "เครื่องดื่ม", 2,"29/12/2021", "09/07/2022");
//        boxes.add(six);
//
//        RefrigeratorBox seven = new RefrigeratorBox("Chiller", 7, "น้ำเปล่า", "เครื่องดื่ม", 5,"30/12/2021", "03/09/2022");
//        boxes.add(seven);
//
//        RefrigeratorBox eight = new RefrigeratorBox("Chiller", 8, "ขนมปอเปี๊ยะลาวา", "ขนม", 10,"31/12/2021", "1/01/2022");
//        boxes.add(eight);

        return boxes;
    }

    @Override
    public void writeData(RefrigeratorBoxList boxes) {

    }
}
