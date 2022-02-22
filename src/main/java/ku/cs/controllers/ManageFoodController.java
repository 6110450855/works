package ku.cs.controllers;

import com.github.saacsos.FXRouter;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import ku.cs.models.*;
import ku.cs.services.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ManageFoodController {

    private RefrigeratorBox currentBox;
    private Refrigerator fridge;
    private FoodList foods;
    private Food selectedFood;

    @FXML
    private  Label label;




    @FXML
    private TableView<Food> foodTableView;
    @FXML
    private TextField foodNameTextField;
    @FXML
    private ChoiceBox foodTypeChoiceBox;
    @FXML
    private TextField foodQuantityTextField;
    @FXML
    private TextField editQuantityTextField;
    @FXML
    private TextField reduceFoodTextField;
    @FXML
    private TextField imagePathTextField;
    @FXML
    private TextField unitTextField;
    @FXML
    private DatePicker buyInDatePicker;
    @FXML
    private DatePicker expireDatePicker;
    @FXML
    private ImageView foodImage;
    @FXML
    private Label durationLabel;

    private FoodFileDatasource datasource;
    private ObservableList<Food> foodObservableList;



    @FXML
    public void initialize() {


        datasource = new FoodFileDatasource("data", "food.csv");
        foods = datasource.getFoodsData();


        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                showFoodData();
                assignFoodType();
                foodTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue != null){
                        setSelectedFood(newValue);
                        File imageFile = new File(selectedFood.getImagePath());
                        Image image = new Image(imageFile.toURI().toString());
                        foodImage.setImage(image);
                        durationLabel.setText(selectedFood.getDurationInFridge());
                    }
                });
            }
        });
    }

    private void showFoodData() {
        foodObservableList = FXCollections.observableArrayList(foods.getFoods());
        foodTableView.setItems(foodObservableList);

        TableColumn<Food, String> foodName = new TableColumn<>("ชื่ออาหาร");
        TableColumn<Food, String> foodType = new TableColumn<>("ประเภทอาหาร");
        TableColumn<Food, Double> quantity = new TableColumn<>("ปริมาณอาหาร");
        TableColumn<Food, String> foodUnit = new TableColumn<>("หน่วยของปริมาณอาหาร");
        TableColumn<Food, String> buyIn = new TableColumn<>("วันที่ซื้อ");
        TableColumn<Food, String> expire = new TableColumn<>("วันหมดอายุ");

        foodName.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getFoodName()));
        foodType.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getFoodType()));
        quantity.setCellValueFactory(celldata -> new SimpleDoubleProperty(celldata.getValue().getQuantity()).asObject());
        foodUnit.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getFoodUnit()));
        buyIn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getBuyIn().toString()));
        expire.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getExpire().toString()));


        foodTableView.getColumns().clear();
        foodTableView.getColumns().add(foodName);
        foodTableView.getColumns().add(foodType);
        foodTableView.getColumns().add(quantity);
        foodTableView.getColumns().add(foodUnit);
        foodTableView.getColumns().add(buyIn);
        foodTableView.getColumns().add(expire);


    }

    private void setSelectedFood(Food food){
        selectedFood = food;
    }


    @FXML
    private void increaseButton() throws IOException{
        Double quantity = Double.parseDouble(editQuantityTextField.getText());
        selectedFood.setQuantity(selectedFood.getQuantity() + quantity);
        foodTableView.refresh();
        showFoodData();
        datasource.setFoodsData(foods);
    }

    @FXML
    private void decreaseButton() {
        Double quantity = Double.parseDouble(editQuantityTextField.getText());
        if (selectedFood.checkFoodQuantity(quantity)) {
            selectedFood.setQuantity(selectedFood.getQuantity() - quantity);
        }
        foodTableView.refresh();
        showFoodData();
        datasource.setFoodsData(foods);
    }

    @FXML
    private void addFoodButton() {
        try {
            String input = foodQuantityTextField.getText();
            double quantity = Double.parseDouble(input);
            Food food = new Food(foodNameTextField.getText(), foodTypeChoiceBox.getValue().toString(), quantity, unitTextField.getText());
            food.setImagePath(imagePathTextField.getText());
            food.setBuyIn(buyInDatePicker.toString());
            food.setExpire(expireDatePicker.toString());
            foods.addFood(food);
            FXRouter.goTo("main_page", foods);
        } catch (IOException e) {
            System.err.println("ไปไม่ได้");
        }
    }

    public void assignFoodType() {
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

    @FXML
    private void deleteFood() throws IOException {
        foods.removeFood(selectedFood);
        selectedFood = null;
        foodTableView.refresh();
        foodTableView.getSelectionModel().clearSelection();
        showFoodData();
        datasource.setFoodsData(foods);
//        try {
//            FXRouter.goTo("main_page");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}