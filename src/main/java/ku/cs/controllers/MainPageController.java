package ku.cs.controllers;

import com.github.saacsos.FXRouter;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ku.cs.App;
import ku.cs.models.Food;

import ku.cs.models.FoodList;
import ku.cs.models.RefrigeratorBox;
import ku.cs.models.RefrigeratorBoxList;



import java.io.IOException;

public class MainPageController {

    private FoodList foodList;
    private RefrigeratorBox currentBox;
    private RefrigeratorBoxList refrigeratorBoxList;


    @FXML private TableView<RefrigeratorBox> refrigeratorTableView;
    @FXML private Label foodTypeLabel;
    @FXML private Label foodNameLabel;
    @FXML private Label foodQuantityLabel;
    @FXML private Label buyInDateLabel;
    @FXML private Label exeireDateLabel;
    @FXML private Label daysInFridgeLabel;

    @FXML
    public void initialize(){
        this.currentBox = (RefrigeratorBox) FXRouter.getData();
        this.foodList = this.currentBox.getFoods();

        showRefrigeratorList();
    }

//    private void foodList(){
//        foodTypeLabel.setText(currentBox.getType());
////        foodNameLabel.setText(currentBox.getFoods());
////        foodQuantityLabel.setText(c);
//    }

    private void showRefrigeratorList(){
        refrigeratorTableView.getColumns().clear();

        ObservableList<RefrigeratorBox> data = FXCollections.observableArrayList();
        for (RefrigeratorBox refrigeratorBox: this.refrigeratorBoxList.getRefrigeratorBoxes()){
            data.add(refrigeratorBox);
        }

        TableColumn<RefrigeratorBox, String> numberColumn = new TableColumn<>("ช่องลำดับที่");
        numberColumn.setCellValueFactory(cellData -> {
            RefrigeratorBox refrigeratorBox = cellData.getValue();
            return new ReadOnlyStringWrapper("" +refrigeratorBox.getOrder());
        });
        refrigeratorTableView.getColumns().add(numberColumn);

        TableColumn<RefrigeratorBox, String> boxTypeColumn = new TableColumn<>("ประเภทช่องแช่");
        boxTypeColumn.setCellValueFactory(cellData -> {
            RefrigeratorBox refrigeratorBox = cellData.getValue();
            return new ReadOnlyStringWrapper(refrigeratorBox.getType());
        });
        refrigeratorTableView.getColumns().add(boxTypeColumn);

        refrigeratorTableView.setItems(data);


    }


//    @FXML
//    private void addQuantityButton()

    @FXML
    private void goToAddFoodButton() throws IOException {
        try {
            FXRouter.goTo("add_food_page");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void goToCreatorButton() throws IOException {
        try {
            FXRouter.goTo("creators");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
