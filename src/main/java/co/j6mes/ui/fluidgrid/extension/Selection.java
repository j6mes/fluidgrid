package co.j6mes.ui.fluidgrid.extension;

import co.j6mes.ui.fluidgrid.MultiEventHandle;
import javafx.scene.Node;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 01/05/2016.
 */
public class Selection implements Extension {
    Node selected = null;

    ExtensionManager host;

    @Override
    public void registerHost(ExtensionManager exm, MultiEventHandle events) {
        this.host = exm;
    }

    @Override
    public void register(Node object) {

    }

    @Override
    public void handleMouseClicked(MouseEvent event) {
        if(event.getSource() instanceof Node) {
            if(selected != null) {
                selected.getStyleClass().remove("selected");
            }

            if (event.getSource() != selected) {
                selected = (Node) event.getSource();
                selected.getStyleClass().add("selected");
            }


        }
    }



    @Override
    public void handleContextMenu(ContextMenuEvent event) {

    }

    @Override
    public void handleDragDetected(MouseEvent event) {

    }

    @Override
    public void handleDragOver(DragEvent event) {

    }

    @Override
    public void handleDragExited(DragEvent event) {

    }

    @Override
    public void handleDragEntered(DragEvent event) {

    }

    @Override
    public void handleMouseDragExited(MouseDragEvent event) {

    }

    @Override
    public void handleMouseDragEntered(MouseDragEvent event) {

    }

    @Override
    public void handleDragDropped(DragEvent event) {

    }

    @Override
    public void handleDragDone(DragEvent event) {

    }

    @Override
    public void handleMouseDragReleased(Node endRegion, MouseDragEvent event) {

    }

    @Override
    public void handleMouseDragged(MouseEvent event) {

    }

    @Override
    public void handleMouseReleased(MouseEvent event) {

    }

    @Override
    public void handleMousePressed(MouseEvent event) {

    }


}
