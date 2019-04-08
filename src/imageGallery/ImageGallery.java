package imageGallery;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ImageGallery extends Application {

    BorderPane pane = new BorderPane();
    Scene scene = new Scene(pane, 1280, 720);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setScene(scene);
        primaryStage.setTitle("Image Gallery");
        primaryStage.show();
    }
}
