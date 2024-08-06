package Exercise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class Exe14_7 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        int countRow = 0;
        int countCol = 0;

        for (int i = 0; i < 100; i++) {
            TextField textField = new TextField("" + new Random().nextInt(2));
            textField.setPrefWidth(30);
            pane.add(textField, countCol++ % 10, countRow++ / 10);
        }

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowTextField");
        primaryStage.show();
    }
}
