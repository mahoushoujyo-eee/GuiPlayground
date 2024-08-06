package CodeList;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


public class MyPolygon extends Pane {
    private void paint()
    {
        Polygon polygon = new Polygon();
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        ObservableList<Double> list = polygon.getPoints();

        double centreX = getWidth() / 2, centreY = getHeight() / 2;
        double radius = Math.min(getWidth(), getHeight()) * 0.4;

        for (int i = 0; i < 6; i++) {
            list.add(centreX + radius * Math.cos(2 * i * Math.PI / 6));
            list.add(centreY - radius * Math.sin(2 * i * Math.PI / 6));
        }

        getChildren().clear();
        getChildren().add(polygon);
    }

    @Override
    protected void setWidth(double value) {
        super.setWidth(value);
        paint();
    }

    @Override
    protected void setHeight(double value) {
        super.setHeight(value);
        paint();
    }
}
