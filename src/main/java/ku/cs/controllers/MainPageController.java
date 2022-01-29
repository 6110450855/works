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
import ku.cs.services.Datasource;
import ku.cs.services.RefrigeratorBoxHardcodeDatasource;


import java.io.IOException;

public class MainPageController {

    private RefrigeratorBoxList refrigeratorBoxes;

    @FXML private ListView<RefrigeratorBox> boxListView;


    @FXML
    public void initialize() {
        Datasource<RefrigeratorBoxList> datasource = new RefrigeratorBoxHardcodeDatasource();
        this.refrigeratorBoxes = datasource.readData();

        addListViewListener();
        showRefrigeratorBoxList();

    }

    private void showRefrigeratorBoxList(){
        ObservableList<RefrigeratorBox> items = FXCollections.observableArrayList();
        for (RefrigeratorBox refrigeratorBox: refrigeratorBoxes.getRefrigeratorBoxes()){
            items.add(refrigeratorBox);
        }
        boxListView.setItems(items);
    }

    private void addListViewListener(){
        boxListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<RefrigeratorBox>() {
            @Override
            public void changed(ObservableValue<? extends RefrigeratorBox> observableValue, RefrigeratorBox old, RefrigeratorBox refrigeratorBox) {
                try {
                    FXRouter.goTo("manage_food_page", refrigeratorBox);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
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
