package Exercise;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Exe15_28 extends Application {
    private int direction = -1;
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox(10);
        HBox hBox = new HBox();
        Pane pane = new Pane();

        Button btPause = new Button("Pause");
        Button btResume = new Button("Resume");
        Button btReverse = new Button("Reverse");
        hBox.getChildren().addAll(btPause, btResume, btReverse);

        double centerX = 80, centerY = 60;

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
        pane.getChildren().addAll(circle, arc1, arc2, arc3, arc4);


        vBox.getChildren().addAll(pane, hBox);

        EventHandler<ActionEvent> eventEventHandler = event ->
        {
            Arc newArc1 = new Arc(centerX, centerY, 50, 50, ((Arc)pane.getChildren().get(1)).getStartAngle() + direction, 30);
            Arc newArc2 = new Arc(centerX, centerY, 50, 50, ((Arc)pane.getChildren().get(2)).getStartAngle() + direction, 30);
            Arc newArc3 = new Arc(centerX, centerY, 50, 50, ((Arc)pane.getChildren().get(3)).getStartAngle() + direction, 30);
            Arc newArc4 = new Arc(centerX, centerY, 50, 50, ((Arc)pane.getChildren().get(4)).getStartAngle() + direction, 30);
            //System.out.println("The arc's startAngle now is: " + ((Arc)pane.getChildren().get(1)).getStartAngle());
            newArc1.setType(ArcType.ROUND);
            newArc2.setType(ArcType.ROUND);
            newArc3.setType(ArcType.ROUND);
            newArc4.setType(ArcType.ROUND);
            pane.getChildren().clear();
            pane.getChildren().addAll(circle, newArc1, newArc2, newArc3, newArc4);
        };

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(10), eventEventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        EventHandler<ActionEvent> eventEventHandlerReversed = event ->
        {
            Arc newArc1 = new Arc(centerX, centerY, 50, 50, ((Arc)pane.getChildren().get(1)).getStartAngle() - 1, 30);
            Arc newArc2 = new Arc(centerX, centerY, 50, 50, ((Arc)pane.getChildren().get(2)).getStartAngle() - 1, 30);
            Arc newArc3 = new Arc(centerX, centerY, 50, 50, ((Arc)pane.getChildren().get(3)).getStartAngle() - 1, 30);
            Arc newArc4 = new Arc(centerX, centerY, 50, 50, ((Arc)pane.getChildren().get(4)).getStartAngle() - 1, 30);
            newArc1.setType(ArcType.ROUND);
            newArc2.setType(ArcType.ROUND);
            newArc3.setType(ArcType.ROUND);
            newArc4.setType(ArcType.ROUND);
            pane.getChildren().clear();
            pane.getChildren().addAll(circle, newArc1, newArc2, newArc3, newArc4);
        };

        Timeline animationReversed = new Timeline(new KeyFrame(Duration.millis(10), eventEventHandlerReversed));
        animationReversed.setCycleCount(Timeline.INDEFINITE);

        btPause.setOnAction(event ->
        {
            animation.pause();
        });

        //如何修改？
        btResume.setOnAction(event ->
        {
            animation.play();
        });
        btReverse.setOnAction(event ->
        {
            direction *= -1;
        });

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Show");
        primaryStage.show();
    }
}
