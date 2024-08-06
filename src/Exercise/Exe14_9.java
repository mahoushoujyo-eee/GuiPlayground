package Exercise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

//合适的添加一个重复对象的方法

public class Exe14_9 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane1 = new GridPane();


        for (int i = 0; i < 4; i++) {
            //Group group = new Group();
            //BorderPane pane2 = new BorderPane();
            //GridPane pane2 = new GridPane();
            Pane pane2 = new Pane();

            double centerX = pane2.getWidth() + 100;
            double centerY = pane2.getHeight() + 100;

            Circle circle = new Circle(centerX, centerY, 55);
            circle.setFill(null);
            circle.setStroke(Color.BLACK);
            Arc arc1 = new Arc(centerX, centerY, 50, 50, 45, 30);
            Arc arc2 = new Arc(centerX, centerY, 50, 50, 135, 30);
            Arc arc3 = new Arc(centerX, centerY, 50, 50, 225, 30);
            Arc arc4 = new Arc(centerX, centerY, 50, 50, 315, 30);
            arc1.setType(ArcType.ROUND);
            arc2.setType(ArcType.ROUND);
            arc3.setType(ArcType.ROUND);
            arc4.setType(ArcType.ROUND);
            pane2.getChildren().addAll(circle, arc1, arc2, arc3, arc4);
            //pane2.getChildren().add(group);
            pane1.add(pane2, i % 2, i / 2);
        }
        //pane1.add(new BorderPane(group), 1, 1);


        Scene scene = new Scene(pane1);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowCircle");
        primaryStage.show();
    }
}
