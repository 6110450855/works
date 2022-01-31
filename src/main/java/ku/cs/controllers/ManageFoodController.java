package ku.cs.controllers;

import com.github.saacsos.FXRouter;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ku.cs.models.Food;
import ku.cs.models.FoodList;
import ku.cs.models.RefrigeratorBox;
import ku.cs.models.RefrigeratorBoxList;
import ku.cs.services.Datasource;
import ku.cs.services.RefrigeratorBoxHardcodeDatasource;

import java.io.IOException;
import java.time.LocalDateTime;

public class ManageFoodController {

    private RefrigeratorBox currentBox;
    private FoodList foodList;


    @FXML private TableView<Food> foodTableView;
    @FXML private TextField foodNameTextField;
    @FXML private ChoiceBox foodTypeChoiceBox;
    @FXML private TextField foodQuantityTextField;
    @FXML private TextField addFoodTextField;
    @FXML private TextField reduceFoodTextField;
    @FXML private TextField imagePathTextField;
    @FXML private DatePicker buyInDatePicker;
    @FXML private DatePicker expireDatePicker;
    @FXML private ImageView image4;

    @FXML
    public void initialize() {
        this.currentBox = (RefrigeratorBox) FXRouter.getData();
        this.foodList = this.currentBox.getFoods();

        assignFoodType();
        showFoodList();

        String path4 = getClass().getResource("/ku/cs/pic/foodimage.png").toExternalForm();
        image4.setImage(new Image(path4));


    }

    private void showFoodList(){
        foodTableView.getColumns().clear();

        ObservableList<Food> data = FXCollections.observableArrayList();
        for (Food food: this.foodList.getFoods()){
            data.add(food);
        }

        TableColumn<Food, String> nameColumn = new TableColumn<>("ชื่ออาหาร");
        nameColumn.setCellValueFactory(cellData -> {
            Food food = cellData.getValue();
            return new ReadOnlyStringWrapper(food.getFoodName());
        });
        foodTableView.getColumns().add(nameColumn);

        TableColumn<Food, String> boxTypeColumn = new TableColumn<>("ประเภทอาหาร");
        boxTypeColumn.setCellValueFactory(cellData -> {
            Food food = cellData.getValue();
            return new ReadOnlyStringWrapper(food.getFoodType());
        });
        foodTableView.getColumns().add(boxTypeColumn);

        TableColumn<Food, String> quantityColumn = new TableColumn<>("จำนวนอาหาร");
        quantityColumn.setCellValueFactory(cellData -> {
            Food food = cellData.getValue();
            return new ReadOnlyStringWrapper("" + food.getQuantity());
        });
        foodTableView.getColumns().add(quantityColumn);

        TableColumn<Food, String> buyInColumn = new TableColumn<>("วันที่ซื้อเข้ามา");
        buyInColumn.setCellValueFactory(cellData -> {
            Food food = cellData.getValue();
            return new ReadOnlyStringWrapper("" + food.getBuyIn());
        });
        foodTableView.getColumns().add(buyInColumn);
//
//        TableColumn<Food, String> expireColumn = new TableColumn<>("วันหมดอายุ");
//        expireColumn.setCellValueFactory(cellData -> {
//            Food food = cellData.getValue();
//            return new ReadOnlyStringWrapper("" + food.getExpire());
//        });
//        foodTableView.getColumns().add(expireColumn);
//
//        TableColumn<Food, String> countDayColumn = new TableColumn<>("จำนวนวันที่อยู่ในตู้เย็น");
//        countDayColumn.setCellValueFactory(cellData -> {
//            Food food = cellData.getValue();
//            return new ReadOnlyStringWrapper(food.getDurationInFridge());
//        });
//        foodTableView.getColumns().add(countDayColumn);

        foodTableView.setItems(data);
        foodTableView.refresh();

    }

    @FXML private void addFoodButton(){
        try {
            String input = foodQuantityTextField.getText();
            int quantity = Integer.parseInt(input);
            Food food = new Food(foodNameTextField.getText(),foodTypeChoiceBox.getValue().toString(),quantity);
            foodList.addFood(food);
            FXRouter.goTo("main_page",foodList);
        }
        catch (IOException e) {
            System.err.println("ไปไม่ได้");
        }
    }
    public void assignFoodType(){
        foodTypeChoiceBox.getItems().add("ของหวาน");
        foodTypeChoiceBox.getItems().add("ของกินเล่น");
        foodTypeChoiceBox.getItems().add("ผลิตภัณฑ์นม");
        foodTypeChoiceBox.getItems().add("อาหารสด");
        foodTypeChoiceBox.getItems().add("เครื่องดื่ม");
    }



    @FXML
    private void handleCancelButton() throws IOException {
        try {
            FXRouter.goTo("main_page");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
