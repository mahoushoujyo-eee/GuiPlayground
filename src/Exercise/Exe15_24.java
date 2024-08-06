package Exercise;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Exe15_24 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        Arc arc = new Arc(100, 0, 100, 100, -135, 90.0);
        arc.setType(ArcType.OPEN);
        arc.setFill(null);
        arc.setStroke(Color.BLACK);
        Circle circle = new Circle(100 - 100 * Math.sin(Math.PI / 4), 100 * Math.sin(Math.PI / 4), 10);

        PathTransition pathTransition = new PathTransition(Duration.millis(5000), arc, circle);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();

        pane.setOnMouseClicked(event ->
        {
            if (pathTransition.getStatus() == Animation.Status.PAUSED)
                pathTransition.play();
            else
                pathTransition.pause();
        });

        pane.getChildren().addAll(arc, circle);

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("ShowAnimation");
        primaryStage.show();
    }
}
