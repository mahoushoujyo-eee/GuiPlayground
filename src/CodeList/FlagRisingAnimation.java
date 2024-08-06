package CodeList;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;

public class FlagRisingAnimation extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        Image image = new Image(new FileInputStream("image/lxy1.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(250);
        pane.getChildren().add(imageView);

        PathTransition pt = new PathTransition(Duration.millis(10000), new Line(100, 200, 100, 0), imageView);
        pt.setCycleCount(5);
        pt.play();

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FlagRisingAnimation");
        primaryStage.show();
    }
}
