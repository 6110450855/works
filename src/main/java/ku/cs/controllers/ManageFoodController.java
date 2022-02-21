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
import ku.cs.models.*;
import ku.cs.services.Datasource;
import ku.cs.services.FoodFileDatasource;
import ku.cs.services.RefrigeratorBoxFileDatasource;
import ku.cs.services.RefrigeratorHardcodeDatasource;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ManageFoodController {

    private RefrigeratorBox currentBox;
    private Refrigerator fridge;
    private FoodList foodList;
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @FXML private TableView<Food> foodTableView;
    @FXML private TextField foodNameTextField;
    @FXML private ChoiceBox foodTypeChoiceBox;
    @FXML private TextField foodQuantityTextField;
    @FXML private TextField editQuantityTextField;
    @FXML private TextField reduceFoodTextField;
    @FXML private TextField imagePathTextField;
    @FXML private TextField unitTextField;
    @FXML private DatePicker buyInDatePicker;
    @FXML private DatePicker expireDatePicker;
    @FXML private ImageView foodImage;

    private RefrigeratorBoxFileDatasource refrigeratorBoxFileDatasource;


    @FXML
    public void initialize() {
        this.currentBox = (RefrigeratorBox) FXRouter.getData();
        this.foodList = this.currentBox.getFoods();



        assignFoodType();
        showFoodList();
        showFoodImage();

    }

    private void showFoodImage() {
        foodTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Food>() {
            @Override
            public void changed(ObservableValue<? extends Food> observableValue, Food old, Food food) {
                File imageFile = new File(food.getImagePath());
                Image image = new Image(imageFile.toURI().toString());
                foodImage.setImage(image);
            }
        });
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

        TableColumn<Food, String> boxTypeColumn = new TableColumn<>("ประเภท");
        boxTypeColumn.setCellValueFactory(cellData -> {
            Food food = cellData.getValue();
            return new ReadOnlyStringWrapper(food.getFoodType());
        });
        foodTableView.getColumns().add(boxTypeColumn);

        TableColumn<Food, String> quantityColumn = new TableColumn<>("จำนวน");
        quantityColumn.setCellValueFactory(cellData -> {
            Food food = cellData.getValue();
            return new ReadOnlyStringWrapper("" + food.getQuantity());
        });
        foodTableView.getColumns().add(quantityColumn);

        TableColumn<Food, String> unitColumn = new TableColumn<>("หน่วย");
        unitColumn.setCellValueFactory(cellData -> {
            Food food = cellData.getValue();
            return new ReadOnlyStringWrapper(food.getFoodUnit());
        });
        foodTableView.getColumns().add(unitColumn);

        TableColumn<Food, String> buyInColumn = new TableColumn<>("วันที่ซื้อเข้ามา");
        buyInColumn.setCellValueFactory(cellData -> {
            Food food = cellData.getValue();
            return new ReadOnlyStringWrapper(food.getBuyIn().format(format));
        });
        foodTableView.getColumns().add(buyInColumn);

        TableColumn<Food, String> expireColumn = new TableColumn<>("วันหมดอายุ");
        expireColumn.setCellValueFactory(cellData -> {
            Food food = cellData.getValue();
            return new ReadOnlyStringWrapper(food.getExpire().format(format));
        });
        foodTableView.getColumns().add(expireColumn);

        TableColumn<Food, String> countDayColumn = new TableColumn<>("จำนวนวันที่อยู่ในตู้เย็น");
        countDayColumn.setCellValueFactory(cellData -> {
            Food food = cellData.getValue();
            return new ReadOnlyStringWrapper(food.getDurationInFridge());
        });
        foodTableView.getColumns().add(countDayColumn);

        foodTableView.setItems(data);
        foodTableView.refresh();

    }

    @FXML private void increaseButton() {
        foodTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Food>() {
            @Override
            public void changed(ObservableValue<? extends Food> observableValue, Food old, Food food) {
                Double quantity = Double.parseDouble(editQuantityTextField.getText());
                food.addFoodQuantity(quantity);
            }
        });
    }

    @FXML private void decreaseButton() {
        foodTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Food>() {
            @Override
            public void changed(ObservableValue<? extends Food> observableValue, Food old, Food food) {
                Double quantity = Double.parseDouble(editQuantityTextField.getText());
                food.putOutFood(quantity);
            }
        });
    }

    @FXML private void addFoodButton(){
        try {
            String input = foodQuantityTextField.getText();
            double quantity = Double.parseDouble(input);
            Food food = new Food(foodNameTextField.getText(),foodTypeChoiceBox.getValue().toString(),quantity, unitTextField.getText());
            food.setImagePath(imagePathTextField.getText());
            food.setBuyIn(buyInDatePicker.toString());
            food.setExpire(expireDatePicker.toString());
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
