package CodeList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ShowPolygon extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new MyPolygon(), 400, 400);
        primaryStage.setTitle("ShowPolygon");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
