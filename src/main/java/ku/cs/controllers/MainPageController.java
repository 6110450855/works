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
import javafx.scene.layout.*;
import ku.cs.models.Food;
import ku.cs.models.FoodList;
import ku.cs.models.RefrigeratorBox;
import ku.cs.models.RefrigeratorBoxList;
import ku.cs.services.FoodFileDatasource;
import ku.cs.services.RefrigeratorBoxFileDatasource;


import java.io.File;
import java.io.IOException;

public class MainPageController {

    private FoodList freezer1, freezer2, chiller1, chiller2, chiller3, chiller4, chiller5, chiller6;
    private FoodFileDatasource datasource1, datasource2, datasource3, datasource4, datasource5, datasource6, datasource7, datasource8;


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

        File imageFile = new File(freezer1.getFoods().get(0).getImagePath());
        Image image = new Image(imageFile.toURI().toString());
        freezerImage1.setImage(image);

        File imageFile2 = new File(freezer2.getFoods().get(0).getImagePath());
        Image image2 = new Image(imageFile2.toURI().toString());
        freezerImage2.setImage(image2);

        File imageFile3 = new File(chiller1.getFoods().get(0).getImagePath());
        Image image3 = new Image(imageFile3.toURI().toString());
        chillerImage1.setImage(image3);

        File imageFile4 = new File(chiller2.getFoods().get(0).getImagePath());
        Image image4 = new Image(imageFile4.toURI().toString());
        chillerImage2.setImage(image4);

        File imageFile5 = new File(chiller3.getFoods().get(0).getImagePath());
        Image image5 = new Image(imageFile5.toURI().toString());
        chillerImage3.setImage(image5);

        File imageFile6 = new File(chiller4.getFoods().get(0).getImagePath());
        Image image6 = new Image(imageFile6.toURI().toString());
        chillerImage4.setImage(image6);

        File imageFile7 = new File(chiller5.getFoods().get(0).getImagePath());
        Image image7 = new Image(imageFile7.toURI().toString());
        chillerImage5.setImage(image7);

        File imageFile8 = new File(chiller6.getFoods().get(0).getImagePath());
        Image image8 = new Image(imageFile8.toURI().toString());
        chillerImage6.setImage(image8);

        freezerImage1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXRouter.goTo("manage_freezer1_page", freezer1);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        freezerImage2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXRouter.goTo("manage_freezer2_page", freezer2);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        chillerImage1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXRouter.goTo("manage_chiller1_page", chiller1);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        chillerImage2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXRouter.goTo("manage_chiller2_page", chiller2);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        chillerImage3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXRouter.goTo("manage_chiller3_page", chiller3);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        chillerImage4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXRouter.goTo("manage_chiller4_page", chiller4);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        chillerImage5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXRouter.goTo("manage_chiller5_page", chiller5);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        chillerImage6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    FXRouter.goTo("manage_chiller6_page", chiller6);

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
