package ku.cs.controllers;

import com.github.saacsos.FXRouter;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;

public class CreatorsController {
    @FXML private ImageView image1, image2, image3;


    @FXML
    public void initialize() {
        String path1 = getClass().getResource("/ku/cs/creators/6110450855.jpg").toExternalForm();
        image1.setImage(new Image(path1));
        String path2 = getClass().getResource("/ku/cs/creators/6210451306.jpg").toExternalForm();
        image2.setImage(new Image(path2));
        String path3 = getClass().getResource("/ku/cs/creators/6210451641.jpg").toExternalForm();
        image3.setImage(new Image(path3));
    }

    @FXML
    private void goToMainPageButton() {
        try {
            FXRouter.goTo("main_page");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
