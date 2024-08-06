package Exercise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Random;

public class Exe14_2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Random random = new Random();
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<String> charList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            numList.add(random.nextInt(2));
        }

        for (Integer num: numList)
        {
            if (num == 1)
                charList.add("1");
            else
                charList.add("2");
        }

        GridPane pane = new GridPane();
        int countRow = 0;
        int countCol = 0;

        for (String ele: charList)
        {
            String path = "image/lxy" + ele + ".jpg";
            ImageView imageView = new ImageView(new Image(new FileInputStream(path)));
            imageView.setFitWidth(250);
            imageView.setFitHeight(200);

            pane.add(imageView, countCol++ % 3, countRow++ / 3);
        }

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GridPaneShow");
        primaryStage.show();
    }
}
