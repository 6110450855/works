package ku.cs.services;


import ku.cs.models.*;


public class RefrigeratorHardcodeDatasource implements Datasource {

    @Override
    public RefrigeratorBoxList getRefrigeratorBoxesData() {

        Refrigerator fridge = new Refrigerator();
        RefrigeratorBoxList boxes = new RefrigeratorBoxList();
        

        //Freezer
        Food food1 = new Food("ไอติม", "ของหวาน", 3 ,"กล่อง");
        food1.setBuyIn("08/02/2022");
        food1.setExpire("15/04/2023");
        food1.setImagePath("images/icecream.png");
        RefrigeratorBox freezer1 = new RefrigeratorBox("Freezer", 1);
        freezer1.takeFoodIn(food1);
        boxes.add(freezer1);

        Food food2 = new Food("สันคอหมูแช่แข็ง", "อาหารสด", 5, "กิโลกรัม");
        food2.setBuyIn("11/02/2022");
        food2.setExpire("20/04/2022");
        food2.setImagePath("images/porkNeck.png");
        RefrigeratorBox freezer2 = new RefrigeratorBox("Freezer", 2);
        freezer2.takeFoodIn(food2);
        boxes.add(freezer2);

        //Chiller
        Food food3 = new Food("ผักบุ้ง", "อาหารสด", 250, "กรัม");
        food3.setBuyIn("16/02/2022");
        food3.setExpire("25/02/2022");
        food3.setImagePath("images/waterSpinach.png");
        RefrigeratorBox chiller1 = new RefrigeratorBox("Chiller", 1);
        chiller1.takeFoodIn(food3);
        boxes.add(chiller1);

        Food food4 = new Food("ไข่ไก่", "อาหารสด", 10, "ฟอง");
        food4.setBuyIn("05/01/2022");
        food4.setExpire("05/02/2022");
        food4.setImagePath("images/egg.png");
        RefrigeratorBox chiller2 = new RefrigeratorBox("Chiller", 2);
        chiller2.takeFoodIn(food4);
        boxes.add(chiller2);

        Food food5 = new Food("ขนมช๊อคโกแลต" , "ของกินเล่น", 5, "ซอง");
        food5.setBuyIn("16/01/2022");
        food5.setExpire("19/05/2023");
        food5.setImagePath("images/chocolate.png");
        RefrigeratorBox chiller3 = new RefrigeratorBox("Chiller", 3);
        chiller3.takeFoodIn(food5);
        boxes.add(chiller3);

        Food food6 = new Food("นมจืดกลิ่นกล้วยหอม" , "ผลิตภัณฑ์นม", 2, "กล่อง");
        food6.setBuyIn("08/11/2021");
        food6.setExpire("20/11/2021");
        food6.setImagePath("images/bananaMilk.png");
        RefrigeratorBox chiller4 = new RefrigeratorBox("Chiller", 4);
        chiller4.takeFoodIn(food6);
        boxes.add(chiller4);

        Food food7 = new Food("น้ำผลไม้" , "เครื่องดื่ม", 3, "กล่อง");
        food7.setBuyIn("10/01/2022");
        food7.setExpire("10/11/2022");
        food7.setImagePath("images/tipco.png");
        RefrigeratorBox chiller5 = new RefrigeratorBox("Chiller", 5);
        chiller5.takeFoodIn(food7);
        boxes.add(chiller5);

        Food food8 = new Food("บัวลอย" , "ของหวาน", 3, "ถุง");
        food8.setBuyIn("14/02/2022");
        food8.setExpire("21/02/2022");
        food8.setImagePath("images/bualoy.png");
        RefrigeratorBox chiller6 = new RefrigeratorBox("Chiller", 6);
        chiller6.takeFoodIn(food8);
        boxes.add(chiller6);

        return boxes;
    }

    @Override
    public void setRefrigeratorBoxesData(RefrigeratorBoxList refrigerator) {
        
    }
    
}
