package imageGallery;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


public class UIMenu {

    //Draws an instance of the menu bar on top of the scene
    public MenuBar drawMenuBar() {

        //Draw menu bar
        MenuBar menuBar = new MenuBar();

        //draw menu items of menu bar
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");

        //draw sub-options for menu items
        MenuItem itemOpen = new MenuItem("Open ^O");
        MenuItem itemClose = new MenuItem("Close ^Q");

        //Place on MenuBar
        menuFile.getItems().addAll(itemOpen, itemClose);
        menuBar.getMenus().addAll(menuFile, menuEdit);

        return menuBar; //return the instance
    }
}
