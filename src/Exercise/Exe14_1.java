package Exercise;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class Exe14_1 extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image1 = new Image(new FileInputStream("image/lxy1.jpg"));
        Image image2 = new Image(new FileInputStream("image/lxy2.jpg"));
        Image image3 = new Image(new FileInputStream("image/lxy3.jpg"));

        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);

        imageView1.setFitHeight(200);
        imageView1.setFitWidth(250);
        imageView2.setFitHeight(200);
        imageView2.setFitWidth(250);
        imageView3.setFitHeight(200);
        imageView3.setFitWidth(250);

        HBox pane = new HBox();
        HBox.setMargin(pane, new Insets(50, 0, 0, 0));
        pane.getChildren().addAll(imageView1, imageView2, imageView3);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowImage");
        primaryStage.show();

    }
}
