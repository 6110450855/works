package ku.cs.controllers.manages;

import com.github.saacsos.FXRouter;
import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ku.cs.models.Food;
import ku.cs.models.FoodList;
import ku.cs.services.FoodFileDatasource;

import java.io.File;
import java.io.IOException;

public class ManageChiller3Controller {

    private FoodList foods;
    private Food selectedFood;
    private FoodFileDatasource datasource;


    @FXML
    private TableView<Food> foodTableView;
    @FXML
    private TextField editQuantityTextField;
    @FXML
    private ImageView foodImage;
    @FXML
    private Label durationLabel;

    private ObservableList<Food> foodObservableList;



    @FXML
    public void initialize() {

        datasource = new FoodFileDatasource("data", "chiller3.csv");
        this.foods = datasource.getFoodsData();


        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                showFoodData();
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
        editQuantityTextField.clear();
        datasource.setFoodsData(foods);
        datasource.saveFoodData(foods);
    }

    @FXML
    private void decreaseButton() {
        Double quantity = Double.parseDouble(editQuantityTextField.getText());
        if (selectedFood.checkFoodQuantity(quantity)) {
            selectedFood.setQuantity(selectedFood.getQuantity() - quantity);
        }
        foodTableView.refresh();
        showFoodData();
        editQuantityTextField.clear();
        datasource.setFoodsData(foods);
        datasource.saveFoodData(foods);
    }


    @FXML
    private void handleCancelButton() throws IOException {
        try {
            FXRouter.goTo("main_page",foods);
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
    }
    @FXML
    private void goToAddFoodButton() throws IOException {
        try {
            FXRouter.goTo("add_food_chiller3_page", foods);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}