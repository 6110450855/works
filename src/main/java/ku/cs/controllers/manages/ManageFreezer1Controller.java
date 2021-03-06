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
import ku.cs.services.FoodFileDataSource;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class ManageFreezer1Controller {

    private FoodList foods;
    private Food selectedFood;
    private FoodFileDataSource datasource;


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

        datasource = new FoodFileDataSource("data", "freezer1.csv");
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
        for (Food food : foods.getFoods()) {
            if (food.getExpire().equals(LocalDate.now()) || food.getExpire().isBefore(LocalDate.now())) {
                foods.removeFood(food);
                datasource.setFoodsData(foods);
            }
        }
        foodTableView.setItems(foodObservableList);

        TableColumn<Food, String> foodName = new TableColumn<>("???????????????????????????");
        TableColumn<Food, String> foodType = new TableColumn<>("?????????????????????????????????");
        TableColumn<Food, Double> quantity = new TableColumn<>("?????????????????????????????????");
        TableColumn<Food, String> foodUnit = new TableColumn<>("?????????????????????????????????????????????????????????");
        TableColumn<Food, String> buyIn = new TableColumn<>("??????????????????????????????");
        TableColumn<Food, String> expire = new TableColumn<>("??????????????????????????????");

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
            FXRouter.goTo("add_food_freezer1_page", foods);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}