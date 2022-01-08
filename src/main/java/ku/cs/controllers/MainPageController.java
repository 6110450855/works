package ku.cs.controllers;

import com.github.saacsos.FXRouter;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import ku.cs.models.RefrigeratorBox;
import ku.cs.models.RefrigeratorBoxList;
import services.Datasource;
import services.RefrigeratorBoxHardcodeDatasource;


import java.io.IOException;

public class MainPageController {

    private RefrigeratorBox currentBox;
    private RefrigeratorBoxList refrigeratorBoxList;


    @FXML private TableView<RefrigeratorBox> refrigeratorTableView;
    @FXML private Label foodTypeLabel;
    @FXML private Label foodNameLabel;
    @FXML private Label foodQuantityLabel;
    @FXML private Label buyInDateLabel;
    @FXML private Label expireDateLabel;
    @FXML private Label daysInFridgeLabel;
    @FXML private TextField newQuantityTextField;

    @FXML
    public void initialize() {
        Datasource<RefrigeratorBoxList> datasource = new RefrigeratorBoxHardcodeDatasource();
        this.refrigeratorBoxList = datasource.readData();

        showRefrigeratorList();
        showSelectedBox();

        refrigeratorTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, old, box) -> {
            if (box != null) {
                showSelectedBoxData(box);
            }
        });
    }

    private void showSelectedBox(){
        refrigeratorTableView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<RefrigeratorBox>() {
                    @Override
                    public void changed(ObservableValue<? extends RefrigeratorBox> observableValue, RefrigeratorBox old, RefrigeratorBox box) {
                        currentBox = box;
                    }
                }
        );
    }

    private void showRefrigeratorList(){
            refrigeratorTableView.getColumns().clear();

            ObservableList<RefrigeratorBox> data = FXCollections.observableArrayList();
            for (RefrigeratorBox refrigeratorBox: this.refrigeratorBoxList.getRefrigeratorBoxes()){
                data.add(refrigeratorBox);
            }

            TableColumn<RefrigeratorBox, String> numberColumn = new TableColumn<>("ช่องลำดับที่");
            numberColumn.setCellValueFactory(cellData -> {
                RefrigeratorBox refrigeratorBox = cellData.getValue();
                return new ReadOnlyStringWrapper("" +refrigeratorBox.getNumber());
            });
            refrigeratorTableView.getColumns().add(numberColumn);

            TableColumn<RefrigeratorBox, String> boxTypeColumn = new TableColumn<>("ประเภทช่องแช่");
            boxTypeColumn.setCellValueFactory(cellData -> {
                RefrigeratorBox refrigeratorBox = cellData.getValue();
                return new ReadOnlyStringWrapper(refrigeratorBox.getType());
            });
            refrigeratorTableView.getColumns().add(boxTypeColumn);

            refrigeratorTableView.setItems(data);
            refrigeratorTableView.refresh();

    }

    public void selected(String s) {
        newQuantityTextField.setPromptText(s);
    }

    public void showSelectedBoxData(RefrigeratorBox target) {
        currentBox = target;
        foodTypeLabel.setText(target.getFoodType());
        foodNameLabel.setText(target.getFoodName());
        foodQuantityLabel.setText("" + target.getQuantity());
        buyInDateLabel.setText(currentBox.getBuyInDate());
        expireDateLabel.setText(currentBox.getExpireDate());
    }


////    @FXML
////    private void addQuantityButton()

    @FXML
    private void goToAddFoodBtn() throws IOException {
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
