package co.j6mes.ui.fluidgrid;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

/**
 * Created by james on 09/05/2016.
 */
public interface MultiEventHandle {
    void addHandleContextMenu(EventHandler<ContextMenuEvent> event);

    void addHandleDragDetected(EventHandler<MouseEvent> event);

    void addHandleDragOver(EventHandler<DragEvent> event);

    void addHandleMouseClicked(EventHandler<MouseEvent> event);

    void addHandleDragExited(EventHandler<DragEvent> event);

    void addHandleDragEntered(EventHandler<DragEvent> event);

    void addHandleMouseDragExited(EventHandler<MouseDragEvent> event);

    void addHandleMouseDragEntered(EventHandler<MouseDragEvent> event);

    void addHandleDragDropped(EventHandler<DragEvent> event);

    void addHandleDragDone(EventHandler<DragEvent> event);

    void addHandleMouseDragReleased(EventHandler<MouseDragEvent> event);

    void addHandleMouseDragged(EventHandler<MouseEvent> event);

    void addHandleMouseReleased(EventHandler<MouseEvent> event);

    void addHandleMousePressed(EventHandler<MouseEvent> event);
}
