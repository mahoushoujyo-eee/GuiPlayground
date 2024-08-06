package Exercise;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Exe15_22 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        ArrayList<Point> points = seekPoints(pane);

        Polygon polygon = new Polygon();
        ObservableList<Double> list = polygon.getPoints();
        for (Point point: points)
        {
            list.addAll(point.getX(), point.getY());
        }
        pane.getChildren().add(polygon);


        Scene scene = new Scene(pane, 350, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowShape");
        primaryStage.show();


    }

    public ArrayList<Point> seekPoints(Pane pane)
    {
        double centerX = pane.getWidth() / 2;
        double centerY = pane.getHeight() / 2;

        double margin = 20;

        ArrayList<Point> points = new ArrayList<>();

        points.add(new Point(margin, 2 * margin));
        points.add(new Point(2 * margin, margin));
        points.add(new Point(pane.getWidth() - 2 * margin, margin));
        points.add(new Point(pane.getWidth() - margin,2 * margin));
        points.add(new Point(pane.getWidth() - margin,pane.getHeight() - 2 * margin));
        points.add(new Point(pane.getWidth() - 2 * margin,pane.getHeight() - margin));
        points.add(new Point(2 * margin,pane.getHeight() -  margin));
        points.add(new Point(margin,pane.getHeight() - 2 * margin));

        return points;
    }

    class Point{
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }
}
