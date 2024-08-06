package Exercise;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exe14_5 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        String circleString = "WELCOME TO JAVA ";
        double centerX = pane.getWidth() / 2 + 200;
        double centerY = pane.getHeight() / 2 + 200;
        int length = 100;
        int count = 0;



        for (char addChar: circleString.toCharArray())
        {
            double textX = centerX + length * Math.cos(2 * Math.PI / circleString.length() * count);
            double textY = centerY + length * Math.sin(2 * Math.PI / circleString.length() * count);


            Font font = Font.font("Times New Roman", FontWeight.BLACK, FontPosture.ITALIC, 22);
            Text text = new Text(textX, textY + length, "" + addChar);
            text.setFont(font);
            text.setRotate( (360.0 / circleString.length() * count++ + 90));
            pane.getChildren().add(text);
        }

        pane.setPadding(new Insets(50, 50, 50, 50));
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowCircleString");
        primaryStage.show();
    }
}
