package ku.cs;

import com.github.saacsos.FXRouter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static String APP_NAME = "Tosina Refrigerator";
    private static final Double WINDOW_WIDTH = 1024.0D;
    private static final Double WINDOW_HEIGHT = 768.0D;

    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, APP_NAME, WINDOW_WIDTH, WINDOW_HEIGHT);
        configRoute();
        FXRouter.goTo("main_page");
    }

    private static void configRoute() {
        FXRouter.when("creators", "ku/cs/creators.fxml",WINDOW_WIDTH, WINDOW_HEIGHT);
        FXRouter.when("main_page", "ku/cs/main_page.fxml", WINDOW_WIDTH, WINDOW_HEIGHT);
        FXRouter.when("add_food_page", "ku/cs/add_food_page.fxml", WINDOW_WIDTH, WINDOW_HEIGHT);
    }


    public static void main(String[] args) {
        launch();
    }

}