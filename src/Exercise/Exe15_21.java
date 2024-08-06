package Exercise;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Exe15_21 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        double radius = 100;
        double ellipse = 0.000001;
        Circle circle = new Circle(150, 150, radius);
        circle.setFill(null);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);

        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            double angle = new Random().nextInt(361);
            list.add(angle);
        }



        //Line line1 = new Line(), line2 = new Line(), line3 =new Line();
        //pane.getChildren().addAll(line1, line2, line3);
        ArrayList<DoubleProperty> points = new ArrayList<>();


        for (Double angle: list)
        {
            Circle circle1 = new Circle(circle.getCenterX() + Math.sin(angle) * radius, circle.getCenterY() + Math.cos(angle) * radius, 10);
            pane.getChildren().add(circle1);

            points.add(circle1.centerXProperty());
            points.add(circle1.centerYProperty());
            circle1.setOnMouseDragged(event ->
            {
                //double originalX = circle1.getCenterX();
                //double originalY = circle1.getCenterY();
                double xLen = Math.abs(circle.getCenterX() - event.getX()) * Math.abs(circle.getCenterX() - event.getX());
                double yLen = Math.abs(circle.getCenterY() - event.getY()) * Math.abs(circle.getCenterY() - event.getY());
                double length = Math.sqrt(xLen + yLen);


                circle1.setCenterX(circle.getCenterX() + (event.getX() - circle.getCenterX()) / length * radius);
                circle1.setCenterY(circle.getCenterY() + (event.getY() - circle.getCenterY()) / length * radius);

            });
        }

        for (int i = 0; i < 2; i++) {
            Line line = new Line();
            line.startXProperty().bind(points.get(2 * i));
            line.startYProperty().bind(points.get(2 * i + 1));
            line.endXProperty().bind(points.get(2 * i + 2));
            line.endYProperty().bind(points.get(2 * i + 3));
            pane.getChildren().add(line);
        }

        Line addLine = new Line();
        addLine.startXProperty().bind(points.get(4));
        addLine.startYProperty().bind(points.get(5));
        addLine.endXProperty().bind(points.get(0));
        addLine.endYProperty().bind(points.get(1));
        pane.getChildren().add(addLine);


        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowCircleAndRectangle");
        primaryStage.show();

    }
}
