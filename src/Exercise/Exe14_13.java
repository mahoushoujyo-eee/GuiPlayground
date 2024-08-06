package Exercise;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exe14_13 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        Group group = new Group();

        Arc arc1 = new Arc(200, 200, 100, 100, 0, 72);
        arc1.setType(ArcType.ROUND);
        arc1.setFill(Color.RED);
        Text text1 = new Text(210, 170, "Project -- 20%");

        Arc arc2 = new Arc(200, 200, 100, 100, 0, -144);
        arc2.setType(ArcType.ROUND);
        arc2.setFill(Color.ORANGE);
        Text text2 = new Text(210, 230, "Final -- 40%");

        Arc arc3 = new Arc(200, 200, 100, 100, -144, -108);
        arc3.setType(ArcType.ROUND);
        arc3.setFill(Color.GREEN);
        Text text3 = new Text(100, 170, "Middle -- 30%");

        Arc arc4 = new Arc(200, 200, 100, 100, 72, 36);
        arc4.setType(ArcType.ROUND);
        arc4.setFill(Color.BLUE);
        Text text4 = new Text(150, 80, "Quiz -- 10%");


        group.getChildren().addAll(arc1, text1, arc2, text2, arc3, text3, arc4, text4);
        pane.getChildren().add(group);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowCircle");
        primaryStage.show();
    }
}
