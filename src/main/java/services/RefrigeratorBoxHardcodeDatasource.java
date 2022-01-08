package services;


import ku.cs.models.RefrigeratorBox;
import ku.cs.models.RefrigeratorBoxList;


public class RefrigeratorBoxHardcodeDatasource implements Datasource<RefrigeratorBoxList> {

    @Override
    public RefrigeratorBoxList readData() {

        RefrigeratorBoxList boxes = new RefrigeratorBoxList();

        RefrigeratorBox one = new RefrigeratorBox("Freezer", 1, "ไอติม", "ของหวาน", 3,"25/12/2021", "03/05/2022");
        boxes.add(one);

        RefrigeratorBox two = new RefrigeratorBox("Freezer", 2, "อกไก่", "อาหารสด", 6,"25/12/2021", "06/05/2022");
        boxes.add(two);

        RefrigeratorBox three = new RefrigeratorBox("Chiller", 3, "หัวหมู", "ของหวาน", 1,"26/12/2021", "01/03/2022");
        boxes.add(three);

        RefrigeratorBox four = new RefrigeratorBox("Chiller", 4, "ไข่ไก่", "ของหวาน", 10,"27/12/2021", "01/06/2022");
        boxes.add(four);

        RefrigeratorBox five = new RefrigeratorBox("Chiller", 5, "ขนมช๊อคโกแลต", "ขนม", 3,"28/12/2021", "02/05/2022");
        boxes.add(five);

        RefrigeratorBox six = new RefrigeratorBox("Chiller", 6, "น้ำอัดลมรสส้ม", "เครื่องดื่ม", 2,"29/12/2021", "09/07/2022");
        boxes.add(six);

        RefrigeratorBox seven = new RefrigeratorBox("Chiller", 7, "น้ำเปล่า", "เครื่องดื่ม", 5,"30/12/2021", "03/09/2022");
        boxes.add(seven);

        RefrigeratorBox eight = new RefrigeratorBox("Chiller", 8, "ขนมปอเปี๊ยะลาวา", "ขนม", 10,"31/12/2021", "1/01/2022");
        boxes.add(eight);



        return boxes;
    }

    @Override
    public void writeData(RefrigeratorBoxList boxes) {

    }
}
