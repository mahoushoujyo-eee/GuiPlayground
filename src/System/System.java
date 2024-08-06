package System;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class System extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginPane pane = new LoginPane();
        pane.setPadding(new Insets(15, 10, 5, 10));

        primaryStage.setScene(new Scene(pane, 250, 170));
        primaryStage.setTitle("StudentAdministration");
        primaryStage.show();
    }
}
