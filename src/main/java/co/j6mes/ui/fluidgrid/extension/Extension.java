package co.j6mes.ui.fluidgrid.extension;

import javafx.scene.Node;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

/**
 * Created by james on 01/05/2016.
 */
public interface Extension {
    void registerHost (ExtensionManager exm);

    void register(Node object);
    void handleContextMenu(ContextMenuEvent event);

    void handleDragDetected(MouseEvent event);

    void handleDragOver(DragEvent event);

    void handleMouseClicked(MouseEvent event);

    void handleDragExited(DragEvent event);

    void handleDragEntered(DragEvent event);

    void handleMouseDragExited(MouseDragEvent event);

    void handleMouseDragEntered(MouseDragEvent event);

    void handleDragDropped(DragEvent event);

    void handleDragDone(DragEvent event);

    void handleMouseDragReleased(Node endRegion, MouseDragEvent event);

    void handleMouseDragged(MouseEvent event);
}
