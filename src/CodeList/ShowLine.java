package CodeList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ShowLine extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new LinePane(), 200, 200);
        primaryStage.setTitle("ShowLine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
