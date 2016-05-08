package co.j6mes.ui.fluidgrid.extension;

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
public class DragAndDrop implements Extension {

    List<Node> nodes = new ArrayList<Node>();

    ExtensionManager host;




    @Override
    public void registerHost(ExtensionManager exm) {
        this.host = exm;
    }

    @Override
    public void register(Node object) {

    }

    @Override
    public void handleContextMenu(ContextMenuEvent event) {

    }

    @Override
    public void handleDragDetected(MouseEvent event) {
        System.out.println("Drag");
        System.out.println(event.getSource());

        if(host.getObjects().size()<2) {
            System.out.println("Only 1 component. No need for drag.");
            return;
        }

        ((Node)event.getSource()).startFullDrag();
        //displayPreview(pf,event,l);

    }

    @Override
    public void handleDragOver(DragEvent event) {

    }

    @Override
    public void handleMouseClicked(MouseEvent event) {

    }

    @Override
    public void handleDragExited(DragEvent event) {

    }

    @Override
    public void handleDragEntered(DragEvent event) {

    }

    @Override
    public void handleDragDropped(DragEvent event) {

        //int indexOfDropTarget = children.getChildren().indexOf(l);
       //
        // rotateNodes(children, indexOfDraggingNode, indexOfDropTarget);
        event.consume();
    }

    @Override
    public void handleDragDone(DragEvent event) {

    }

    @Override
    public void handleMouseDragReleased(Node endRegion, MouseDragEvent event) {
        if(!event.isConsumed()) {
            event.consume();
        } else {
            return;
        }


     //   int indexOfDraggingNode = host.getObjects().indexOf(event.get());


        System.out.println("Source " +event.getGestureSource());
        System.out.println("Target" + endRegion);

    }
}
