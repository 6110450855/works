module ku.cs {
    requires javafx.controls;
    requires javafx.fxml;

    opens ku.cs to javafx.fxml;
    exports ku.cs;
    exports ku.cs.controllers;
    opens ku.cs.controllers to javafx.fxml;
    exports ku.cs.controllers.manages;
    opens ku.cs.controllers.manages to javafx.fxml;
    exports ku.cs.controllers.addfood;
    opens ku.cs.controllers.addfood to javafx.fxml;

}
