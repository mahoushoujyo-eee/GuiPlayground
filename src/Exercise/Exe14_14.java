package Exercise;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


//半成品，寻找更合适的方法----Polygon？
public class Exe14_14 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        int offsetX = 20;
        int offsetY = 30;

        DoubleBinding point1X = pane.widthProperty().multiply(0.1);
        DoubleBinding point1Y = pane.heightProperty().multiply(0.4);
        DoubleBinding point2X = pane.widthProperty().multiply(0.8);
        DoubleBinding point2Y = point1Y;
        DoubleBinding point3X = point1X;
        DoubleBinding point3Y = pane.heightProperty().multiply(0.9);
        DoubleBinding point4X = point2X;
        DoubleBinding point4Y = point3Y;



        Line line1 = new Line();
        line1.startXProperty().bind(point1X);
        line1.startYProperty().bind(point1Y);
        line1.endXProperty().bind(point2X);
        line1.endYProperty().bind(point2Y);

        Line line2 = new Line();
        line2.startXProperty().bind(point1X);
        line2.startYProperty().bind(point1Y);
        line2.endXProperty().bind(point3X);
        line2.endYProperty().bind(point3Y);

        Line line3 = new Line();
        line3.startXProperty().bind(point2X);
        line3.startYProperty().bind(point2Y);
        line3.endXProperty().bind(point4X);
        line3.endYProperty().bind(point4Y);

        Line line4 = new Line();
        line4.startXProperty().bind(point3X);
        line4.startYProperty().bind(point3Y);
        line4.endXProperty().bind(point4X);
        line4.endYProperty().bind(point4Y);


        pane.getChildren().addAll(line1, line2, line3, line4);
        pane.setPadding(new Insets(20, 20, 20, 20));

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowRectangle");
        primaryStage.show();
    }
}
