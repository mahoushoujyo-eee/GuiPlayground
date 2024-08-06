package Exercise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;



public class Exe15_09 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        Scene scene = new Scene(pane, 250, 200);
        scene.setOnKeyPressed(event ->
        {
            double startX = 100, startY = 100;
            Line line, orignalLine;
            if (!pane.getChildren().isEmpty()) {
                orignalLine = (Line) pane.getChildren().get(pane.getChildren().size() - 1);
                startX = orignalLine.getEndX();
                startY = orignalLine.getEndY();
            }

            switch (event.getCode())
            {
                case UP:
                    line = new Line(startX, startY, startX, startY - 20);break;
                case DOWN:
                    line = new Line(startX,startY,startX, startY + 20);break;
                case LEFT:
                    line = new Line(startX, startY, startX - 20, startY);break;
                case RIGHT:
                    line = new Line(startX, startY, startX + 20, startY);break;
                default:
                    line = new Line();
            }


            pane.getChildren().add(line);
        });


        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowLine");
        primaryStage.show();
    }
}
