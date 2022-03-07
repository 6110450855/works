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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import ku.cs.models.*;
import ku.cs.services.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AddFoodController {

    private RefrigeratorBoxList boxes;
    private RefrigeratorBox currentBox;
    private FoodList foods;
    private Food food;


    @FXML
    private TextField foodNameTextField;
    @FXML
    private ChoiceBox foodTypeChoiceBox;
    @FXML
    private TextField foodQuantityTextField;
    @FXML
    private TextField unitTextField;
    @FXML
    private DatePicker expireDatePicker;
    @FXML
    private ImageView uploadImage;
    @FXML
    private Button uploadButton;


    private RefrigeratorBoxFileDatasource datasourceRefrigerator;
    private FoodFileDatasource datasourceFood;
    private ObservableList<Food> foodObservableList;



    @FXML
    public void initialize() {
        datasourceFood = new FoodFileDatasource("data","food.csv");
        this.foods = datasourceFood.getFoodsData();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                assignFoodType();

                uploadButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FileChooser chooser = new FileChooser();
                        chooser.setInitialDirectory(new File(System.getProperty("user.dir")));
                        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("images PNG JPG", "*.png", "*.jpg"));
                        File file = chooser.showOpenDialog(uploadButton.getScene().getWindow());
                        if (file != null){
                            try {
                                File destDir = new File("images");
                                destDir.mkdirs();
                                String[] fileSplit = file.getName().split("\\.");
                                String filename = LocalDate.now()+"_"+System.currentTimeMillis()+"."+fileSplit[fileSplit.length - 1];
                                Path target = FileSystems.getDefault().getPath(destDir.getAbsolutePath()+System.getProperty("file.separator")+filename);
                                Files.copy(file.toPath(), target, StandardCopyOption.REPLACE_EXISTING );
                                uploadImage.setImage(new Image(target.toUri().toString()));
                                food.setImagePath(filename);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
    }

    @FXML
    private void addFoodButton() {
        try {
            String input = foodQuantityTextField.getText();
            double quantity = Double.parseDouble(input);
            food = new Food(foodNameTextField.getText(), foodTypeChoiceBox.getValue().toString(), quantity, unitTextField.getText());

            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            food.setBuyIn(LocalDate.now().format(format));
            food.setExpire(expireDatePicker.getValue().toString());
            foods.addFood(food);
            datasourceFood.setFoodsData(foods);
            FXRouter.goTo("manage_food_page", foods);
        } catch (IOException e) {
            System.err.println("ไปไม่ได้");
        }
    }

    public void assignFoodType() {
        if (foods.getFoods().get(0).equals(null)) {
            foodTypeChoiceBox.getItems().add("ของหวาน");
            foodTypeChoiceBox.getItems().add("ของกินเล่น");
            foodTypeChoiceBox.getItems().add("ผลิตภัณฑ์นม");
            foodTypeChoiceBox.getItems().add("อาหารสด");
            foodTypeChoiceBox.getItems().add("เครื่องดื่ม");
        }
        else {
            foodTypeChoiceBox.getItems().add(foods.getFoods().get(0).getFoodType());
        }
    }

    @FXML
    private void handleCancelButton() throws IOException {
        try {
            FXRouter.goTo("manage_food_page");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}