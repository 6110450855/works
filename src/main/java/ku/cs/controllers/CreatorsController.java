package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ku.cs.App;

import java.io.IOException;

public class CreatorsController {
    @FXML private ImageView image1, image2, image3;
    @FXML private Button mainPageMain;


    @FXML
    public void initialize() {
//        image1.setImage(new Image("/ku/cs/creators/6110450855.jpg"));
//        image2.setImage(new Image("/ku/cs/creators/6210451306.jpg"));
//        image3.setImage(new Image("/ku/cs/creators/6210451641.jpg"));
    }

    @FXML
    private void goToMainPageButton() throws IOException {
        App.setRoot("mainpage");
    }

}
