package ku.cs.controllers;

import com.github.saacsos.FXRouter;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ku.cs.models.FoodList;
import ku.cs.models.Refrigerator;
import ku.cs.models.RefrigeratorBox;
import ku.cs.services.FoodFileDatasource;


import java.io.File;
import java.io.IOException;

public class MainPageController {

    private FoodList freezer1, freezer2, chiller1, chiller2, chiller3, chiller4, chiller5, chiller6;
    private FoodFileDatasource datasource1, datasource2, datasource3, datasource4, datasource5, datasource6, datasource7, datasource8;
    private Refrigerator refrigerator;
    private RefrigeratorBox box1, box2, box3, box4, box5, box6, box7, box8;


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

        refrigerator = new Refrigerator("Tosina");

        refrigerator.add(box1);
        refrigerator.add(box2);
        refrigerator.add(box3);
        refrigerator.add(box4);
        refrigerator.add(box5);
        refrigerator.add(box6);
        refrigerator.add(box7);
        refrigerator.add(box8);

        if (freezer1.getFoods().isEmpty()) {
            File imageFile = new File("images/empty.png");
            Image image = new Image(imageFile.toURI().toString());
            freezerImage1.setImage(image);
        }
        else {
            File imageFile = new File(freezer1.getFoods().get(0).getImagePath());
            Image image = new Image(imageFile.toURI().toString());
            freezerImage1.setImage(image);
        }

        if (freezer2.getFoods().isEmpty()) {
            File imageFile = new File("images/empty.png");
            Image image = new Image(imageFile.toURI().toString());
            freezerImage2.setImage(image);
        }
        else {
            File imageFile = new File(freezer2.getFoods().get(0).getImagePath());
            Image image = new Image(imageFile.toURI().toString());
            freezerImage2.setImage(image);
        }

        if (chiller1.getFoods().isEmpty()) {
            File imageFile = new File("images/empty.png");
            Image image = new Image(imageFile.toURI().toString());
            chillerImage1.setImage(image);
        }
        else {
            File imageFile = new File(chiller1.getFoods().get(0).getImagePath());
            Image image = new Image(imageFile.toURI().toString());
            chillerImage1.setImage(image);
        }

        if (chiller2.getFoods().isEmpty()) {
            File imageFile = new File("images/empty.png");
            Image image = new Image(imageFile.toURI().toString());
            chillerImage2.setImage(image);
        }
        else {
            File imageFile = new File(chiller2.getFoods().get(0).getImagePath());
            Image image = new Image(imageFile.toURI().toString());
            chillerImage2.setImage(image);
        }

        if (chiller3.getFoods().isEmpty()) {
            File imageFile = new File("images/empty.png");
            Image image = new Image(imageFile.toURI().toString());
            chillerImage3.setImage(image);
        }
        else {
            File imageFile = new File(chiller3.getFoods().get(0).getImagePath());
            Image image = new Image(imageFile.toURI().toString());
            chillerImage3.setImage(image);
        }

        if (chiller4.getFoods().isEmpty()) {
            File imageFile = new File("images/empty.png");
            Image image = new Image(imageFile.toURI().toString());
            chillerImage4.setImage(image);
        }
        else {
            File imageFile = new File(chiller4.getFoods().get(0).getImagePath());
            Image image = new Image(imageFile.toURI().toString());
            chillerImage4.setImage(image);
        }

        if (chiller5.getFoods().isEmpty()) {
            File imageFile = new File("images/empty.png");
            Image image = new Image(imageFile.toURI().toString());
            chillerImage5.setImage(image);
        }
        else {
            File imageFile = new File(chiller5.getFoods().get(0).getImagePath());
            Image image = new Image(imageFile.toURI().toString());
            chillerImage5.setImage(image);
        }

        if (chiller6.getFoods().isEmpty()) {
            File imageFile = new File("images/empty.png");
            Image image = new Image(imageFile.toURI().toString());
            chillerImage6.setImage(image);
        }
        else {
            File imageFile = new File(chiller6.getFoods().get(0).getImagePath());
            Image image = new Image(imageFile.toURI().toString());
            chillerImage6.setImage(image);
        }

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
