package Exercise;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Exe15_04 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox(10);
        HBox hBox1 = new HBox(10);
        HBox hBox2 = new HBox(10);


        TextField textNum1 = new TextField();
        TextField textNum2 = new TextField();
        TextField textResult = new TextField();
        textNum1.setPrefColumnCount(3);
        textNum2.setPrefColumnCount(3);
        textResult.setPrefColumnCount(3);
        textResult.setEditable(false);

        Text text1 = new Text("Number1:");
        Text text2 = new Text("Number2:");
        Text text3 = new Text("Result:");


        Button btAdd = new Button("Add");
        Button btSub = new Button("Subtract");
        Button btMul = new Button("Multiply");
        Button btDiv = new Button("Divide");

        btAdd.setOnAction(event -> textResult.setText(Double.parseDouble(textNum1.getText()) + Double.parseDouble(textNum2.getText()) + ""));
        btSub.setOnAction(event -> textResult.setText(Double.parseDouble(textNum1.getText()) - Double.parseDouble(textNum2.getText()) + ""));
        btMul.setOnAction(event -> textResult.setText(Double.parseDouble(textNum1.getText()) * Double.parseDouble(textNum2.getText()) + ""));
        btDiv.setOnAction(event -> textResult.setText(Double.parseDouble(textNum1.getText()) / Double.parseDouble(textNum2.getText()) + ""));

        hBox1.getChildren().addAll(text1, textNum1, text2, textNum2, text3, textResult);
        hBox2.getChildren().addAll(btAdd,btSub, btMul, btDiv);
        hBox2.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(hBox1, hBox2);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowCalculator");
        primaryStage.show();
    }
}
