package CodeList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ShowEllipse extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene= new Scene(new MyEllipse(), 300, 200);
        primaryStage.setTitle("ShowEllipse");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
