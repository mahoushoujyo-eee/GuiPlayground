package CodeList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class BounceBallControl extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BallPane ballPane = new BallPane();

        ballPane.setOnMousePressed(event -> ballPane.pause());
        ballPane.setOnMouseReleased(event -> ballPane.play());

        ballPane.setOnKeyPressed(event ->
        {
            if (event.getCode() == KeyCode.UP)
                ballPane.increaseSpeed();
            else if (event.getCode() == KeyCode.DOWN)
                ballPane.decreaseSpeed();
        });

        Scene scene = new Scene(ballPane, 250, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BounceBallControl");
        primaryStage.show();

        ballPane.requestFocus();
    }
}
