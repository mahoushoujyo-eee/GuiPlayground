package Exercise;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



public class Exe14_4 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox pane = new HBox();

        for (int i = 0; i < 5; i++) {
            Font font = Font.font("Times New Roman", FontWeight.BLACK, FontPosture.ITALIC, 22);
            Label label = new Label("Java");
            label.setFont(font);
            label.setTextFill(Color.color(Math.random(), Math.random(), Math.random()));
            label.setOpacity(Math.random());
            label.setRotate(90);
            pane.getChildren().add(label);
        }
        pane.setPadding(new Insets(20,10, 10, 10));

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowFont");
        primaryStage.show();

    }
}
