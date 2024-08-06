package Exercise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exe15_14 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        Polygon polygon = new Polygon(40, 20, 70, 40, 60, 80, 45, 45, 20, 60);
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        pane.getChildren().add(polygon);


        Scene scene = new Scene(pane);

        scene.setOnMouseMoved(event ->
        {
            String result;
            if (polygon.contains(event.getX(), event.getY()))
                result = "Mouse point is inside the polygon";
            else
                result = "Mouse point is outside the polygon";

            Text text = new Text(event.getX(), event.getY(), result);
            pane.getChildren().clear();
            pane.getChildren().addAll(polygon, text);
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowMouse");
        primaryStage.show();

    }
}
