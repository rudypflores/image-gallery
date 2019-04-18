package imageGallery;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.List;


public class ImageGallery extends Application {

    BorderPane pane = new BorderPane();
    Scene scene = new Scene(pane, 1280, 720);
    private int currentIndex = 0;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //Draw the top menu bar
        UIMenu uiMenuBar = new UIMenu();
        MenuBar topMenuBar = uiMenuBar.drawMenuBar();

        pane.setTop(topMenuBar);

        // Set up Everything needed for the bottom pane
        UIBottomPane  UIBottom = new UIBottomPane();
        HBox hbox = UIBottom.getHBox();
        ScrollPane scrollPane = new ScrollPane(hbox);
        scrollPane.setFitToHeight(true);
        List<Node> list = hbox.getChildren();

        // add event listeners for each image
        int i=0;
        for (Node n: list) {
            ImageView imageView = (ImageView) n;
            Image innerImage = imageView.getImage();
            ImageView centerImageView = new ImageView(innerImage);
            centerImageView.setPreserveRatio(true);
            centerImageView.setFitHeight(500);
            centerImageView.setFitWidth(500);

            final int a = i;
            imageView.setOnMouseClicked(event -> {
                pane.setCenter(new UIimage(0).loadImage(centerImageView));
                this.currentIndex = a;
            });
            i++;
        }

        //set up middle
        pane.setRight(UIimage.loadArrow("http://www.stickpng.com/assets/images/585e46c3cb11b227491c3377.png",0));
        pane.setLeft(UIimage.loadArrow("http://www.stickpng.com/assets/images/585e46c3cb11b227491c3377.png",180));

        //set up eventHandler for right and left
        StackPane right = (StackPane) pane.getRight();
        StackPane left = (StackPane) pane.getLeft();
        right.setOnMouseClicked(v -> {
            int index = (this.currentIndex + 1) % list.size();
             pane.setCenter(new UIimage(0).switchImage((ImageView) list.get(index)));
             this.currentIndex = index;
        });
        left.setOnMouseClicked(v -> {
            int index = (this.currentIndex - 1) % list.size();
            index = (index < 0) ? list.size()-1 : index;
            pane.setCenter(new UIimage(0).switchImage((ImageView) list.get(index)));
            this.currentIndex = index;
        });



        pane.setTop(topMenuBar);
        pane.setBottom(scrollPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Image Gallery");
        primaryStage.show();
    }


}
