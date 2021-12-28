package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ku.cs.App;

import java.io.IOException;

public class MainPageController {


    @FXML
    private void goToCreatorButton() throws IOException {
        App.setRoot("creators");
    }
}
