package imageGallery;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;


public class UIMenu {

    //Draws an instance of the menu bar on top of the scene
    public MenuBar drawMenuBar() {

        //Draw menu bar
        MenuBar menuBar = new MenuBar();

        //draw options of menu bar
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");

        //draw sub-options for menu
        

        menuBar.getMenus().addAll(menuFile, menuEdit);

        return menuBar; //return the instance
    }
}
