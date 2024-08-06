package Exercise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Exe15_01 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBox = new HBox();
        BorderPane pane = new BorderPane();
        VBox vBox = new VBox();

        Button refresh = new Button("Refresh");
        addAll(hBox, randomImage());
        pane.setCenter(refresh);
        vBox.getChildren().addAll(hBox, pane);

        refresh.setOnAction(event ->
        {
            try {
                addAll(hBox, randomImage());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("RefreshImage");
        primaryStage.show();

    }

    public ArrayList<ImageView> randomImage() throws FileNotFoundException {
        ArrayList<ImageView> imageList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int newInt = new Random().nextInt(8) + 1;
            ImageView imageView = new ImageView(new Image(new FileInputStream("image/lxy" + newInt + ".jpg")));
            imageView.setFitWidth(250);
            imageView.setFitHeight(200);
            imageList.add(imageView);
        }

        return imageList;
    }

    public void addAll(Pane pane, ArrayList<ImageView> imageList)
    {
        pane.getChildren().clear();
        for (ImageView image: imageList)
            pane.getChildren().add(image);
    }
}
