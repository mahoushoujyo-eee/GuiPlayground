package CodeList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyEventDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Text text = new Text(20, 20, "A");

        pane.getChildren().add(text);
        text.setOnKeyPressed(event ->
        {
            switch (event.getCode()){
                case DOWN: text.setY(text.getY() + 10);break;
                case UP: text.setY(text.getY() - 10);break;
                case LEFT: text.setX(text.getX() - 10);break;
                case RIGHT: text.setX(text.getX() + 10);break;
                default:
                    if (event.getText().length() > 0)
                        text.setText(event.getText());
            }
        });

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("KeyEventDemo");
        primaryStage.show();

        text.requestFocus();
    }
}
