package imageGallery;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class UIimage
{
//    private ImageView img;
//    private String url;
//    private StackPane root;
//    private double degree;
//
//    public UIimage(String url, double degree)
//    {
//        this.url = url;
//        this.degree = degree;
//    }

    public static StackPane loadImage(String url, double degree)
    {
        ImageView img = new ImageView(new Image(url));
        img.setRotate(degree);

        StackPane root = new StackPane();
        root.getChildren().add(img);

        return root;
    }
}
