package Exercise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;



public class Exe14_20 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        drawArrowLine(100, 100, 200, 250, pane);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowArrow");
        primaryStage.show();

    }

    public static void drawArrowLine(double startX, double startY, double endX, double endY, Pane pane)
    {
        double length = Math.sqrt(Math.abs(startX - endX) * Math.abs(startX - endX) + Math.abs(startY - endY) * Math.abs(startY - endY));
        double metaX = Math.abs(startX - endX) / length;
        double metaY = Math.abs(startY - endY) / length;
        int offset = 5;

        Line line = new Line(startX, startY, endX, endY);


        Line addLine1 = new Line(endX - 10 * metaX, endY - 10 * metaY, endX, endY);
        addLine1.setRotate(45);

        Polyline polyline = new Polyline(endX - 10 * metaX + 3 * metaY, endY - 10 * metaY - 3 * metaX, endX + 3 * metaY, endY- 3 * metaX, endX - 10 * metaY + 3 * metaY, endY + 10 * metaX- 3 * metaX);
        polyline.setRotate(45);

        pane.getChildren().addAll(line, polyline);
    }
}
