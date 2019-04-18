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
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.List;


public class ImageGallery extends Application {

    BorderPane pane = new BorderPane();
    Scene scene = new Scene(pane, 1280, 720);
    UIimage uimg = new UIimage(0);
    private int currentIndex = 0;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //Draw the top menu bar
        UIMenu uiMenuBar = new UIMenu(primaryStage, uimg);
        MenuBar topMenuBar = uiMenuBar.drawMenuBar();

        //Listen for a key combination
        scene.setOnKeyPressed(e -> {
            uiMenuBar.onShortcutPressed(e);
        });

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
                pane.setCenter(uimg.loadImage(centerImageView));
                this.currentIndex = a;
            });
            i++;
        }

        //set up middle
        pane.setRight(UIimage.loadArrow("http://www.stickpng.com/assets/images/585e46c3cb11b227491c3377.png",0));
        pane.setLeft(UIimage.loadArrow("http://www.stickpng.com/assets/images/585e46c3cb11b227491c3377.png",180));

        //init when load in new folder
        pane.setCenter(uimg.switchImage((ImageView)list.get(0)));

        //set up eventHandler for right and left
        StackPane right = (StackPane) pane.getRight();
        StackPane left = (StackPane) pane.getLeft();
        right.setOnMouseClicked(v -> {
            int index = (this.currentIndex + 1) % list.size();
             pane.setCenter(uimg.switchImage((ImageView) list.get(index)));
             this.currentIndex = index;
        });
        left.setOnMouseClicked(v -> {
            int index = (this.currentIndex - 1) % list.size();
            index = (index < 0) ? list.size()-1 : index;
            pane.setCenter(uimg.switchImage((ImageView) list.get(index)));
            this.currentIndex = index;
        });

        pane.setTop(topMenuBar);
        pane.setBottom(scrollPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Image Gallery");
        primaryStage.show();
    }


}
