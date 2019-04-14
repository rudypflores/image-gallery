package imageGallery;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.io.File;
import java.net.URI;

public class UIBottomPane {

    URI filePath;
    HBox hbox;

    public UIBottomPane() { }

    public UIBottomPane(URI filePath) {

        this.filePath = filePath;

    }

    public void setupPane() {
        this.hbox = new HBox(10);
        this.hbox.setPadding(new Insets(15));
    }

    public void readDirectory() {
        File file = new File("pictures");
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for(File f: files) {
                if(f.getPath().endsWith(".jpg") || f.getPath().endsWith(".png") ) {
                    Image image = new Image(f.toURI().toString());
                    ImageView view = new ImageView(image);
                    view.setFitWidth(150);
                    view.setFitHeight(150);
                    view.preserveRatioProperty().setValue(true);
                    hbox.getChildren().add(view);
                }

            }
        }
        else {
            System.out.println("This is not a directory");
        }
    }

    public HBox getHBox() {
        setupPane();
        readDirectory();
        return this.hbox;
    }
}
