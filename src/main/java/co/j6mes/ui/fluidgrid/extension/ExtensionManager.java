package co.j6mes.ui.fluidgrid.extension;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

import java.util.List;

/**
 * Created by james on 08/05/2016.
 */
public interface ExtensionManager {
    List<Region> getObjects();
    void update();
    void addObject(ImageView object);
    void addObject(Region object);
    void clearObjects();

}
