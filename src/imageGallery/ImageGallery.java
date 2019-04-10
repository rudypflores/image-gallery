package imageGallery;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ImageGallery extends Application {

    BorderPane pane = new BorderPane();
    Scene scene = new Scene(pane, 1280, 720);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //Draw the top menu bar
        UIMenu uiMenuBar = new UIMenu();
        MenuBar topMenuBar = uiMenuBar.drawMenuBar();

        //draw the image
        StackPane mid = UIimage.loadImage("https://s3.amazonaws.com/peoplepng/wp-content/uploads/2018/06/04134727/Adorable-Cat-PNG.png",0);

        pane.setTop(topMenuBar);
        pane.setCenter(mid);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Image Gallery");
        primaryStage.show();
    }
}
