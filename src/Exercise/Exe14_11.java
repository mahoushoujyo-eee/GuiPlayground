package Exercise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exe14_11 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBox = new HBox(20);


        VBox vBox1 = new VBox();
        Text text1 = new Text("Project--20%");
        Rectangle addRectangle = new Rectangle(120, 160);
        addRectangle.setOpacity(0.0);
        Rectangle rectangle1 = new Rectangle(120, 40);
        vBox1.getChildren().addAll(addRectangle, text1, rectangle1);
        hBox.getChildren().add(vBox1);

        VBox vBox2 = new VBox();
        Text text2 = new Text("Quiz--10%");
        Rectangle rectangle2 = new Rectangle(120, 20);
        addRectangle = new Rectangle(120, 180);
        addRectangle.setOpacity(0.0);
        vBox2.getChildren().addAll(addRectangle, text2, rectangle2);
        hBox.getChildren().add(vBox2);


        Scene scene = new Scene(hBox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowBar");
        primaryStage.show();

    }
}
