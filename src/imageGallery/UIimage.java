package imageGallery;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class UIimage
{
    private int i;
    private double degree;
    private ImageView currentImg;

    public UIimage(double degree)
    {
        this.degree = degree;
    }

    public StackPane loadImage(ImageView img)
    {
        this.currentImg = img;
        img.setRotate(this.degree);

        StackPane root = new StackPane();
        root.getChildren().add(img);

        return root;
    }

    public StackPane switchImage(ImageView img)
    {
        ImageView imageView = img;
        Image innerImage = imageView.getImage();
        ImageView centerImageView = new ImageView(innerImage);
        centerImageView.setPreserveRatio(true);
        centerImageView.setFitHeight(500);
        centerImageView.setFitWidth(500);

        return this.loadImage(centerImageView);
    }

    public void rotateImage(double degree)
    {
        this.currentImg.setRotate(degree);

    }

    public static StackPane loadArrow(String url, double degree)
    {
        ImageView img = new ImageView(new Image(url));
        img.setFitWidth(60);
        img.setFitHeight(60);
        img.setRotate(degree);

        StackPane root = new StackPane();
        root.setPadding(new Insets(0,80,0,80));
        root.getChildren().add(img);

        return root;
    }

    public double getDgree()
    {
        return this.degree;
    }

    public int getI()
    {
        return this.i;
    }
}
