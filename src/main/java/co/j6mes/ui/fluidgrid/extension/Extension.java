package co.j6mes.ui.fluidgrid.extension;

import javafx.scene.Node;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

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

    void handleDragDropped(DragEvent event);

    void handleDragDone(DragEvent event);
}
