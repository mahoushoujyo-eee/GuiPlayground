package Exercise;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exe14_15 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane pane = new StackPane();

        Polygon polygon = new Polygon();
        ObservableList<Double> list = polygon.getPoints();
        list.addAll(100.0, 10.0, 200.0, 10.0, 240.0, 50.0, 240.0, 100.0, 200.0, 140.0, 100.0, 140.0, 60.0, 100.0, 60.0, 50.0);
        polygon.setFill(Color.RED);

        Text text = new Text("STOP");
        Font font = new Font(50);
        text.setFont(font);
        text.setFill(Color.WHITE);

        pane.getChildren().addAll(polygon, text);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowPolygon");
        primaryStage.show();

    }
}
