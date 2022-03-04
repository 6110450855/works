package ku.cs.controllers;

import com.github.saacsos.FXRouter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ku.cs.models.Food;
import ku.cs.models.FoodList;
import ku.cs.models.RefrigeratorBox;
import ku.cs.services.FoodFileDatasource;
import ku.cs.services.RefrigeratorBoxFileDatasource;


import java.io.File;
import java.io.IOException;

public class MainPageController {

    private FoodList freezer1, freezer2, chiller1, chiller2, chiller3, chiller4, chiller5, chiller6;
    private FoodFileDatasource datasource1, datasource2, datasource3, datasource4, datasource5, datasource6, datasource7, datasource8;
    private RefrigeratorBox box1, box2, box3, box4, box5, box6, box7, box8;
    private RefrigeratorBox currentBox;

    @FXML private ImageView freezerImage1, freezerImage2, chillerImage1, chillerImage2, chillerImage3, chillerImage4, chillerImage5, chillerImage6 ;

    @FXML
    public void initialize() {
        datasource1 = new FoodFileDatasource("data" , "freezer1.csv");
        datasource2 = new FoodFileDatasource("data", "freezer2.csv");
        datasource3 = new FoodFileDatasource("data", "chiller1.csv");
        datasource4 = new FoodFileDatasource("data", "chiller2.csv");
        datasource5 = new FoodFileDatasource("data", "chiller3.csv");
        datasource6 = new FoodFileDatasource("data", "chiller4.csv");
        datasource7 = new FoodFileDatasource("data", "chiller5.csv");
        datasource8 = new FoodFileDatasource("data", "chiller6.csv");

        this.freezer1 = datasource1.getFoodsData();
        this.freezer2 = datasource2.getFoodsData();
        this.chiller1 = datasource3.getFoodsData();
        this.chiller2 = datasource4.getFoodsData();
        this.chiller3 = datasource5.getFoodsData();
        this.chiller4 = datasource6.getFoodsData();
        this.chiller5 = datasource7.getFoodsData();
        this.chiller6 = datasource8.getFoodsData();

        box1 = new RefrigeratorBox("Freezer", 1);
        box2 = new RefrigeratorBox("Freezer", 2);
        box3 = new RefrigeratorBox("Chiller", 1);
        box4 = new RefrigeratorBox("Chiller", 2);
        box5 = new RefrigeratorBox("Chiller", 3);
        box6 = new RefrigeratorBox("Chiller", 4);
        box7 = new RefrigeratorBox("Chiller", 5);
        box8 = new RefrigeratorBox("Chiller", 6);

        box1.addFoodList(freezer1);
        box2.addFoodList(freezer2);
        box3.addFoodList(chiller1);
        box4.addFoodList(chiller2);
        box5.addFoodList(chiller3);
        box6.addFoodList(chiller4);
        box7.addFoodList(chiller5);
        box8.addFoodList(chiller6);


        File imageFile = new File(freezer1.getImagePath()); //อ่านไฟล์ภายนอก project
        Image image = new Image(imageFile.toURI().toString());
        freezerImage1.setImage(image);

        File imageFile2 = new File(freezer2.getImagePath()); //อ่านไฟล์ภายนอก project
        Image image2 = new Image(imageFile2.toURI().toString());
        freezerImage2.setImage(image2);

        File imageFile3 = new File(chiller1.getImagePath()); //อ่านไฟล์ภายนอก project
        Image image3 = new Image(imageFile3.toURI().toString());
        chillerImage1.setImage(image3);

        File imageFile4 = new File(chiller2.getImagePath()); //อ่านไฟล์ภายนอก project
        Image image4 = new Image(imageFile4.toURI().toString());
        chillerImage2.setImage(image4);

        File imageFile5 = new File(chiller3.getImagePath()); //อ่านไฟล์ภายนอก project
        Image image5 = new Image(imageFile5.toURI().toString());
        chillerImage3.setImage(image5);

        File imageFile6 = new File(chiller4.getImagePath()); //อ่านไฟล์ภายนอก project
        Image image6 = new Image(imageFile6.toURI().toString());
        chillerImage4.setImage(image6);

        File imageFile7 = new File(chiller5.getImagePath()); //อ่านไฟล์ภายนอก project
        Image image7 = new Image(imageFile7.toURI().toString());
        chillerImage5.setImage(image7);

        File imageFile8 = new File(chiller6.getImagePath()); //อ่านไฟล์ภายนอก project
        Image image8 = new Image(imageFile8.toURI().toString());
        chillerImage6.setImage(image8);

        freezerImage1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXRouter.goTo("manage_food_page", freezer1);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        freezerImage2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXRouter.goTo("manage_food_page", freezer2);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        chillerImage1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXRouter.goTo("manage_food_page", chiller1);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        chillerImage2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXRouter.goTo("manage_food_page", chiller2);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        chillerImage3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXRouter.goTo("manage_food_page", chiller3);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        chillerImage4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXRouter.goTo("manage_food_page", chiller4);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        chillerImage5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXRouter.goTo("manage_food_page", chiller5);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        chillerImage6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXRouter.goTo("manage_food_page", chiller6);

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
