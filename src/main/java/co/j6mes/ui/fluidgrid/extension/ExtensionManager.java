package co.j6mes.ui.fluidgrid.extension;

import javafx.scene.Node;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

import java.util.List;

/**
 * Created by james on 08/05/2016.
 */
public interface ExtensionManager {
    List<Region> getObjects();
    void update();



}
