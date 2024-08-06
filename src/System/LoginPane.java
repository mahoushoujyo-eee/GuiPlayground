package System;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LoginPane extends Pane {
    public LoginPane()
    {
        Button btOK  = new Button("Log");
        btOK.setPrefWidth(130);
        Button btCancel = new Button("Cancel");
        btCancel.setPrefWidth(130);
        Button btRegister = new Button("Register");
        btRegister.setPrefWidth(130);

        Text accountText = new Text("Account:  ");
        TextField account = new TextField();
        HBox hBoxAccount = new HBox();
        hBoxAccount.getChildren().addAll(accountText, account);
        Text passwordText = new Text("Password:");
        TextField password = new TextField();
        HBox hBoxPassword = new HBox();
        hBoxPassword.getChildren().addAll(passwordText, password);

        /*HBox hBoxBT = new HBox(30);
        hBoxBT.getChildren().addAll(btOK, btCancel);
        hBoxBT.setAlignment(Pos.CENTER);*/

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBoxAccount, hBoxPassword, btOK, btCancel, btRegister);
        vBox.setAlignment(Pos.CENTER);

        getChildren().addAll(vBox);
    }
}
