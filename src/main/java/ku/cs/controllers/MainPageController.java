package ku.cs.controllers;

import com.github.saacsos.FXRouter;
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
import ku.cs.models.Refrigerator;
import ku.cs.models.RefrigeratorBox;
import ku.cs.models.RefrigeratorBoxList;
import ku.cs.services.Datasource;
import ku.cs.services.RefrigeratorHardcodeDatasource;



import java.io.IOException;

public class MainPageController {

    private RefrigeratorBoxList fridge;

    @FXML private ListView<RefrigeratorBox> boxListView;
    @FXML private ImageView image5 , image6 , image7 , image8 ,image9 ,FreezerFood1,FreezerFood2,ChillerFood1,ChillerFood2,ChillerFood3,ChillerFood4,ChillerFood5,ChillerFood6;


    @FXML
    public void initialize() {
        Datasource<RefrigeratorBoxList> datasource = new RefrigeratorHardcodeDatasource();
        this.fridge = datasource.readData();



        addListViewListener();
        showRefrigeratorBoxList();
        String path5 = getClass().getResource("/ku/cs/pic/foodimage2.png").toExternalForm();
        image5.setImage(new Image(path5));

        String path6 = getClass().getResource("/ku/cs/pic/foodimage3.png").toExternalForm();
        image6.setImage(new Image(path6));

        String path7 = getClass().getResource("/ku/cs/pic/foodimage4.png").toExternalForm();
        image7.setImage(new Image(path7));

        String path8 = getClass().getResource("/ku/cs/pic/foodimage5.png").toExternalForm();
        image8.setImage(new Image(path8));

        String path9 = getClass().getResource("/ku/cs/pic/foodimage6.png").toExternalForm();
        image9.setImage(new Image(path9));

    }

    private void showRefrigeratorBoxList(){
        ObservableList<RefrigeratorBox> items = FXCollections.observableArrayList();
        for (RefrigeratorBox refrigeratorBox: fridge.getRefrigeratorBoxes()){
            items.add(refrigeratorBox);
        }
        boxListView.setItems(items);
    }

    private void addListViewListener(){
        boxListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<RefrigeratorBox>() {
            @Override
            public void changed(ObservableValue<? extends RefrigeratorBox> observableValue, RefrigeratorBox old, RefrigeratorBox box) {
                try {
                    FXRouter.goTo("manage_food_page", box);
                } catch (IOException e) {
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

    @FXML
    private void goToInstructionButton() throws IOException {
        try {
            FXRouter.goTo("instruction_page");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
