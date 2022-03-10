package ku.cs.controllers;

import com.github.saacsos.FXRouter;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ku.cs.models.FoodList;
import ku.cs.services.FoodFileDataSource;




import java.io.File;
import java.io.IOException;


public class MainPageController {

    private FoodList freezer1, freezer2, chiller1, chiller2, chiller3, chiller4, chiller5, chiller6;
    private FoodFileDataSource datasource1, datasource2, datasource3, datasource4, datasource5, datasource6, datasource7, datasource8;



    @FXML private ImageView freezerImage1, freezerImage2, chillerImage1, chillerImage2, chillerImage3, chillerImage4, chillerImage5, chillerImage6 ;
    @FXML private Label freezerFoodNameLabel1,freezerFoodQuantityLabel1,freezerFoodExpireLabel1,freezerFoodNameLabel2,freezerFoodQuantityLabel2,freezerFoodExpireLabel2,chillerFoodNameLabel1,chillerFoodQuantityLabel1,chillerFoodExpireLabel1,chillerFoodNameLabel2,chillerFoodQuantityLabel2,chillerFoodExpireLabel2,chillerFoodNameLabel3,chillerFoodQuantityLabel3,chillerFoodExpireLabel3,chillerFoodNameLabel4,chillerFoodQuantityLabel4,chillerFoodExpireLabel4,chillerFoodNameLabel5,chillerFoodQuantityLabel5,chillerFoodExpireLabel5,chillerFoodNameLabel6,chillerFoodQuantityLabel6,chillerFoodExpireLabel6;


    @FXML
    public void initialize() {
        datasource1 = new FoodFileDataSource("data" , "freezer1.csv");
        datasource2 = new FoodFileDataSource("data", "freezer2.csv");
        datasource3 = new FoodFileDataSource("data", "chiller1.csv");
        datasource4 = new FoodFileDataSource("data", "chiller2.csv");
        datasource5 = new FoodFileDataSource("data", "chiller3.csv");
        datasource6 = new FoodFileDataSource("data", "chiller4.csv");
        datasource7 = new FoodFileDataSource("data", "chiller5.csv");
        datasource8 = new FoodFileDataSource("data", "chiller6.csv");

        this.freezer1 = datasource1.getFoodsData();
        this.freezer2 = datasource2.getFoodsData();
        this.chiller1 = datasource3.getFoodsData();
        this.chiller2 = datasource4.getFoodsData();
        this.chiller3 = datasource5.getFoodsData();
        this.chiller4 = datasource6.getFoodsData();
        this.chiller5 = datasource7.getFoodsData();
        this.chiller6 = datasource8.getFoodsData();



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

        setFoodInfo();
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

    public void setFoodInfo() {
        if (!freezer1.getFoods().isEmpty()) {
            freezerFoodNameLabel1.setText(freezer1.getFoods().get(0).getFoodName());
            freezerFoodQuantityLabel1.setText(freezer1.calculateAllFoods()+ " ชิ้น");
            freezerFoodExpireLabel1.setText(freezer1.getFoods().get(0).getExpire()+" ");
        }
        else {
            freezerFoodNameLabel1.setText("");
            freezerFoodQuantityLabel1.setText("");
            freezerFoodExpireLabel1.setText("");

        }

        if (!freezer2.getFoods().isEmpty()) {
            freezerFoodNameLabel2.setText(freezer2.getFoods().get(0).getFoodName());
            freezerFoodQuantityLabel2.setText(freezer2.calculateAllFoods()+ " ชิ้น");
            freezerFoodExpireLabel2.setText(freezer2.getFoods().get(0).getExpire()+ " ");
        }
        else {
            freezerFoodNameLabel2.setText("");
            freezerFoodQuantityLabel2.setText("");
            freezerFoodExpireLabel2.setText("");

        }

        if (!chiller1.getFoods().isEmpty()) {
            chillerFoodNameLabel1.setText(chiller1.getFoods().get(0).getFoodName());
            chillerFoodQuantityLabel1.setText(chiller1.calculateAllFoods()+ " ชิ้น");
            chillerFoodExpireLabel1.setText(chiller1.getFoods().get(0).getExpire()+ " ");
        }
        else {
            chillerFoodNameLabel1.setText("");
            chillerFoodQuantityLabel1.setText("");
            chillerFoodExpireLabel1.setText("");

        }

        if (!chiller2.getFoods().isEmpty()) {
            chillerFoodNameLabel2.setText(chiller2.getFoods().get(0).getFoodName());
            chillerFoodQuantityLabel2.setText(chiller2.calculateAllFoods()+ " ชิ้น");
            chillerFoodExpireLabel2.setText(chiller2.getFoods().get(0).getExpire()+ " ");
        }
        else {
            chillerFoodNameLabel2.setText("");
            chillerFoodQuantityLabel2.setText("");
            chillerFoodExpireLabel2.setText("");

        }

        if (!chiller3.getFoods().isEmpty()) {
            chillerFoodNameLabel3.setText(chiller3.getFoods().get(0).getFoodName());
            chillerFoodQuantityLabel3.setText(chiller3.calculateAllFoods()+ " ชิ้น");
            chillerFoodExpireLabel3.setText(chiller3.getFoods().get(0).getExpire()+ " ");
        }
        else {
            chillerFoodNameLabel3.setText("");
            chillerFoodQuantityLabel3.setText("");
            chillerFoodExpireLabel3.setText("");

        }

        if (!chiller4.getFoods().isEmpty()) {
            chillerFoodNameLabel4.setText(chiller4.getFoods().get(0).getFoodName());
            chillerFoodQuantityLabel4.setText(chiller4.calculateAllFoods()+ " ชิ้น");
            chillerFoodExpireLabel4.setText(chiller4.getFoods().get(0).getExpire()+ " ");
        }
        else {
            chillerFoodNameLabel4.setText("");
            chillerFoodQuantityLabel4.setText("");
            chillerFoodExpireLabel4.setText("");

        }

        if (!chiller5.getFoods().isEmpty()) {
            chillerFoodNameLabel5.setText(chiller5.getFoods().get(0).getFoodName());
            chillerFoodQuantityLabel5.setText(chiller5.calculateAllFoods()+ " ชิ้น");
            chillerFoodExpireLabel5.setText(chiller5.getFoods().get(0).getExpire()+ " ");
        }
        else {
            chillerFoodNameLabel5.setText("");
            chillerFoodQuantityLabel5.setText("");
            chillerFoodExpireLabel5.setText("");

        }

        if (!chiller6.getFoods().isEmpty()) {
            chillerFoodNameLabel6.setText(chiller6.getFoods().get(0).getFoodName());
            chillerFoodQuantityLabel6.setText(chiller6.calculateAllFoods()+ " ชิ้น");
            chillerFoodExpireLabel6.setText(chiller6.getFoods().get(0).getExpire()+ " ");
        }
        else {
            chillerFoodNameLabel6.setText("");
            chillerFoodQuantityLabel6.setText("");
            chillerFoodExpireLabel6.setText("");

        }
    }




}
