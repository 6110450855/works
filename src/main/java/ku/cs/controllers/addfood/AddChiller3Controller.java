package ku.cs.controllers.addfood;

import com.github.saacsos.FXRouter;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import ku.cs.models.Food;
import ku.cs.models.FoodList;
import ku.cs.services.FoodFileDatasource;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddChiller3Controller {

    private FoodList foods;
    private Food food;
    private String imagePath;

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

    private FoodFileDatasource datasourceFood;

    @FXML
    public void initialize() {
        datasourceFood = new FoodFileDatasource("data","chiller3.csv");
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
                                imagePath = "images/"+filename;

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
            food = new Food("Chiller",3,foodNameTextField.getText(), foodTypeChoiceBox.getValue().toString(), quantity, unitTextField.getText());

            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            food.setBuyIn(LocalDate.now().format(format));
            food.setExpire(expireDatePicker.getValue().toString());
            food.setImagePath(imagePath);
            if (!foods.getFoods().isEmpty()) {
                if (foods.checkFoodName(food)) {
                    Alert alert = new Alert(Alert.AlertType.NONE,"ไม่สามารถเพิ่มอาหารได้เนื่องจากมีอยู่แล้ว กรุณาลองใหม่", ButtonType.OK);
                    alert.show();
                    foodNameTextField.clear();
                    foodQuantityTextField.clear();
                    unitTextField.clear();
                    throw new RuntimeException("Duplicate Name");
                }
                else {
                    foods.addFood(food);
                    datasourceFood.setFoodsData(foods);
                    FXRouter.goTo("manage_chiller3_page", foods);
                }
            }

            foods.addFood(food);
            datasourceFood.setFoodsData(foods);
            FXRouter.goTo("manage_chiller3_page", foods);

        } catch (IOException e) {
            System.err.println("ไปไม่ได้");
        }
    }

    public void assignFoodType() {
        if (foods.getFoods().isEmpty()) {
            foodTypeChoiceBox.getItems().add("Sweets");
            foodTypeChoiceBox.getItems().add("Snack");
            foodTypeChoiceBox.getItems().add("Dairies");
            foodTypeChoiceBox.getItems().add("Fresh Food");
            foodTypeChoiceBox.getItems().add("drink");
        }
        else {
            foodTypeChoiceBox.getItems().add(foods.getFoods().get(0).getFoodType());
        }
    }

    @FXML
    private void handleCancelButton() throws IOException {
        try {
            FXRouter.goTo("manage_chiller3_page");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
