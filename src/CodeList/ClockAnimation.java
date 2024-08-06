package CodeList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;


public class ClockAnimation extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ClockPane clockPane = new ClockPane();

        EventHandler<ActionEvent> eventEventHandler = event ->
        {
            clockPane.setCurrentTime();
        };

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventEventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        Scene scene = new Scene(clockPane, 250, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ClockAnimation");
        primaryStage.show();
    }
}
