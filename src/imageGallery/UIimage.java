package imageGallery;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class UIimage
{

    private double degree;

    public UIimage(double degree)
    {
        this.degree = degree;
    }

    public StackPane loadImage(ImageView img)
    {
        img.setRotate(this.degree);

        StackPane root = new StackPane();
        root.getChildren().add(img);

        return root;
    }

    public static StackPane loadImage(String url, double degree)
    {
        ImageView img = new ImageView(new Image(url));
        img.setFitWidth(20);
        img.setFitHeight(20);
        img.setRotate(degree);

        StackPane root = new StackPane();
        root.getChildren().add(img);

        return root;
    }

    public double getDgree()
    {
        return this.degree;
    }
}
