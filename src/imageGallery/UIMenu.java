package imageGallery;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.beans.EventHandler;
import java.io.File;


public class UIMenu {

    private String directory = null;
    private Stage stage = null;
    private KeyCombination ctrlO = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);
    private KeyCombination ctrlQ = new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN);
    private KeyCombination ctrlL = new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN);
    private KeyCombination ctrlR = new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN);

    //Handle when open is clicked
    private void handleClickOpen(Stage stage) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(stage);

        if(selectedDirectory == null) {
            System.out.println("No directory was chosen.");
            this.directory = null;
        } else {
            this.directory = selectedDirectory.getPath();
            System.out.println("Your file directory is: " + this.directory);
        }
    }

    //Handle when the rotate left item is clicked
    private void handleClickRotateLeft() {
        System.out.println("The image has been rotated left");
    }

    //Handle when the rotate right item is clicked
    private void handleClickRotateRight() {
        System.out.println("The image has been rotated right");
    }

    //Listen for key combinations and match with its right action
    public void onShortcutPressed(KeyEvent e) {
        if(ctrlO.match(e)) {
            this.handleClickOpen(stage);
        }

        if(ctrlQ.match(e)) {
            System.exit(0);
        }

        //Handle rotation left
        if(ctrlL.match(e)) {
            this.handleClickRotateLeft();
        }
        //Handle rotation right
        if(ctrlR.match(e)) {
            this.handleClickRotateRight();
        }
    }

    //Draws an instance of the menu bar on top of the scene
    public MenuBar drawMenuBar(Stage stage) {

        this.stage = stage;

        //Draw menu bar
        MenuBar menuBar = new MenuBar();

        //draw menu items of menu bar
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");

        //draw sub-options for file
        MenuItem itemOpen = new MenuItem("Open ^O");
        itemOpen.setOnAction(e -> {
            this.handleClickOpen(stage);
        });

        //Close program when event is triggered
        MenuItem itemClose = new MenuItem("Close ^Q");
        itemClose.setOnAction(e -> {
            System.exit(0);
        });

        //draw sub-options for edit
        MenuItem itemRotateLeft = new MenuItem("Rotate Left ^L");
        itemRotateLeft.setOnAction(e -> {
            this.handleClickRotateLeft();
        });

        MenuItem itemRotateRight = new MenuItem("Rotate Right ^R");
        itemRotateRight.setOnAction(e -> {
            this.handleClickRotateRight();
        });

        //Place on file
        menuFile.getItems().addAll(itemOpen, itemClose);

        //Place on edit
        menuEdit.getItems().addAll(itemRotateLeft, itemRotateRight);

        //Add to main menu bar
        menuBar.getMenus().addAll(menuFile, menuEdit);

        return menuBar; //return the instance
    }

    //Access the directory of file chosen by user
    public String getDirectory() {
        return this.directory;
    }
}
