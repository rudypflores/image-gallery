package imageGallery;

import javafx.scene.layout.HBox;

import java.net.URI;

public class UIBottomPane {
    URI filePath;
    HBox hbox = new HBox();

    public UIBottomPane(URI filePath) {
        this.filePath = filePath;
        setupPane();
    }

    public void setupPane() {
        hbox.setSpacing(10);
    }
}
