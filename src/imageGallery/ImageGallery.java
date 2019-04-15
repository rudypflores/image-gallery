package imageGallery;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.List;


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

        // Set up Everything needed for the bottom pane
        UIBottomPane  UIBottom = new UIBottomPane();
        HBox hbox = UIBottom.getHBox();
        ScrollPane scrollPane = new ScrollPane(hbox);
        scrollPane.setFitToHeight(true);
        List<Node> list = hbox.getChildren();

        // add event listeners for each image
        for (Node n: list) {
            ImageView imageView = (ImageView) n;
            Image innerImage = imageView.getImage();
            ImageView centerImageView = new ImageView(innerImage);
            centerImageView.setPreserveRatio(true);
            centerImageView.setFitHeight(500);
            centerImageView.setFitWidth(500);

            imageView.setOnMouseClicked(event -> {

                pane.setCenter(centerImageView);
            });
        }

        pane.setTop(topMenuBar);
        pane.setBottom(scrollPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Image Gallery");
        primaryStage.show();
    }
}
