package Exercise;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;




public class Exe15_02 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox(50);
        BorderPane borderPane1 = new BorderPane();
        BorderPane borderPane2 = new BorderPane();

        Rectangle rectangle = new Rectangle(50, 20);
        Button button = new Button("Rotate");

        borderPane1.setCenter(rectangle);
        borderPane1.setPadding(new Insets(20, 20, 20, 20));
        borderPane2.setCenter(button);
        vBox.getChildren().addAll(borderPane1, borderPane2);

        button.setOnAction(event -> rotatePane(borderPane1, borderPane1.getRotate()));

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowRotate");
        primaryStage.show();

    }

    public void rotatePane(Pane pane, double rotate)
    {
        pane.setRotate(15 + rotate);
    }
}
