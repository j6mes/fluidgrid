package co.j6mes.ui.fluidgrid.extension;

import javafx.scene.Node;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 01/05/2016.
 */
public class Selection implements Extension {
    Node selected = null;

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
    public void handleDragDropped(DragEvent event) {

    }

    @Override
    public void handleDragDone(DragEvent event) {

    }


}
