package ku.cs.controllers;

import com.github.saacsos.FXRouter;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ku.cs.models.Food;
import ku.cs.models.FoodList;
import ku.cs.models.RefrigeratorBox;
import ku.cs.models.RefrigeratorBoxList;

public class AddFoodController {

//    private RefrigeratorBox currentBox;
//    private FoodList foodList;
//
//    @FXML private TableView<Food> foodTableView;

//    @FXML
//    public void initialize(){
//        this.currentBox = (RefrigeratorBox) FXRouter.getData();
//        this.foodList = this.currentBox.getFoods();
//
//    }

//    private void showFoodList(){
//        foodTableView.getColumns().clear();
//
//        ObservableList<Food> data = FXCollections.observableArrayList();
//        for (Food food: this.foodList.getFoods()){
//            data.add(food);
//        }
//
//        TableColumn<Food, String> quantityColumn = new TableColumn<>("Quantity");
//        quantityColumn.setCellValueFactory(cellData -> {
//            Food food = cellData.getValue();
//            return new ReadOnlyStringWrapper("" +food.getQuantity());
//        });
//        foodTableView.getColumns().add(quantityColumn);
//
//        TableColumn<Food, String> nameColumn = new TableColumn<>("Name");
//    }


}
