package ku.cs.controllers;

import com.github.saacsos.FXRouter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class InstructionController {


    @FXML
    private void goToMainPageButton() {
        try {
            FXRouter.goTo("main_page");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
