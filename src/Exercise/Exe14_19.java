package Exercise;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class Exe14_19 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        Polyline polyline1 = new Polyline();
        ObservableList<Double> list1 = polyline1.getPoints();
        double scaleFactor = 50;
        for (int x = -170; x <= 170; x++) {
            list1.add(x + 200.0);
            list1.add(100 - scaleFactor * Math.sin(x / 100.0 * 2 * Math.PI));
        }

        Polyline polyline2 = new Polyline();
        ObservableList<Double> list2 = polyline2.getPoints();
        for (int x = -170; x <= 170; x++) {
            list2.add(x + 225.0);
            list2.add(100 - scaleFactor * Math.sin(x / 100.0 * 2 * Math.PI));
        }

        Line lineX = new Line(225, 0, 225, 200);
        Line lineY = new Line(0, 100, 400, 100);



        pane.getChildren().addAll(polyline1, polyline2, lineX, lineY);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowPolyLine");
        primaryStage.show();
    }
}
