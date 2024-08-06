package Exercise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exe15_06 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Text text = new Text("Java is fun");
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(text);

        text.setOnMouseClicked(event ->
        {
            if (text.getText().equals("Java is fun"))
                text.setText("Java is powerful");
            else
                text.setText("Java is fun");
        });

        Scene scene = new Scene(stackPane, 250, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowClick");
        primaryStage.show();
    }
}
