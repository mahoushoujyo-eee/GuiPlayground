package Exercise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Test extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Line line = new Line(20, 20, pane.getWidth() - 20, pane.getHeight() - 20);
        System.out.println(pane.getWidth() + " " + pane.getHeight());
        pane.getChildren().addAll(line);

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowLine");
        primaryStage.show();
    }
}
