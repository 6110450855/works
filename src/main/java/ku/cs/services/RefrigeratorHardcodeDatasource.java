package ku.cs.services;


import ku.cs.models.Food;
import ku.cs.models.Refrigerator;
import ku.cs.models.RefrigeratorBox;
import ku.cs.models.RefrigeratorBoxList;


public class RefrigeratorHardcodeDatasource implements Datasource<Refrigerator> {

    @Override
    public Refrigerator readData() {

        Refrigerator fridge = new Refrigerator();
        RefrigeratorBoxList boxes = new RefrigeratorBoxList();
        

        //Freezer
        Food food1 = new Food("ไอติม", "ของหวาน", 3 ,"กล่อง");
        food1.setBuyIn("08/02/2022");
        food1.setExpire("15/04/2023");
        RefrigeratorBox freezer1 = new RefrigeratorBox("Freezer", 1);
        freezer1.takeFoodIn(food1);
        boxes.add(freezer1);

        Food food2 = new Food("อกไก่", "อาหารสด", 6, "ขีด");
        RefrigeratorBox freezer2 = new RefrigeratorBox("Freezer", 2);
        freezer2.takeFoodIn(food2);
        boxes.add(freezer2);

        //Chiller
        Food food3 = new Food("หัวหมู", "อาหารสด", 1, "กิโล");
        RefrigeratorBox chiller1 = new RefrigeratorBox("Chiller", 1);
        chiller1.takeFoodIn(food3);
        boxes.add(chiller1);

        Food food4 = new Food("ไข่ไก่", "อาหารสด", 10, "ฟอง");
        RefrigeratorBox chiller2 = new RefrigeratorBox("Chiller", 2);
        chiller2.takeFoodIn(food4);
        boxes.add(chiller2);

        Food food5 = new Food("ขนมช๊อคโกแลต" , "ของกินเล่น", 5, "ซอง");
        RefrigeratorBox chiller3 = new RefrigeratorBox("Chiller", 3);
        chiller3.takeFoodIn(food5);
        boxes.add(chiller3);

        Food food6 = new Food("นมจืดกลิ่นกล้วยหอม" , "ผลิตภัณฑ์นม", 2, "กล่อง");
        RefrigeratorBox chiller4 = new RefrigeratorBox("Chiller", 4);
        chiller4.takeFoodIn(food6);
        boxes.add(chiller4);

        Food food7 = new Food("น้ำเปล่า" , "เครื่องดื่ม", 3, "ขวด");
        RefrigeratorBox chiller5 = new RefrigeratorBox("Chiller", 5);
        chiller5.takeFoodIn(food7);
        boxes.add(chiller5);

        Food food8 = new Food("บัวลอย" , "ของหวาน", 3, "ถุง");
        RefrigeratorBox chiller6 = new RefrigeratorBox("Chiller", 6);
        chiller6.takeFoodIn(food8);
        boxes.add(chiller6);

        fridge.add(boxes);
        
        return fridge;
    }

    @Override
    public void writeData(Refrigerator refrigerator) {
        
    }
    
}
