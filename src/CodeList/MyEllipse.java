package CodeList;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class MyEllipse extends Pane {
    private void paint(){
        getChildren().clear();
        for (int i = 0; i < 16; i++) {
            Ellipse e1 = new Ellipse(getWidth() / 2, getHeight() / 2, getWidth() / 2 - 50, getHeight() / 2 - 50);
            e1.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
            e1.setFill(Color.WHITE);
            e1.setRotate(i * 180 / 16);
            getChildren().add(e1);
        }
    }

    @Override
    protected void setHeight(double value) {
        super.setHeight(value);
        paint();
    }

    @Override
    protected void setWidth(double value) {
        super.setWidth(value);
        paint();
    }
}
