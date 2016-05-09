package co.j6mes.ui.fluidgrid.extension;

import co.j6mes.ui.fluidgrid.MultiEventHandle;
import javafx.application.Platform;
import javafx.event.EventHandler;
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
    PreviewComponent preview = null;
    ExtensionManager host;




    @Override
    public void registerHost(ExtensionManager exm, MultiEventHandle events) {
        this.host = exm;

        events.addHandleMouseDragExited(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                if(preview !=null) {
                    preview.hide();
                }
            }
        });

        events.addHandleMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                if(preview !=null) {
                    preview.show();
                }
            }
        });

        final Extension tthis = this;
        events.addHandleMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tthis.handleMouseDragged(event);
            }
        });
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

        if(preview!=null) {
            preview.close();
            preview = null;
        }

        preview = new PreviewComponent((Region) event.getSource());




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
        if(preview != null) {
            preview.show();
        }
    }

    @Override
    public void handleMouseDragExited(MouseDragEvent event) {

    }

    @Override
    public void handleMouseDragEntered(MouseDragEvent event) {

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
        System.out.println("Drag done");
    }

    @Override
    public void handleMouseDragReleased(Node endRegion, MouseDragEvent event) {
        if(endRegion.equals(event.getGestureSource())) {
            if(preview != null) {
                preview.close();
            }
            return;
        }

        if(!event.isConsumed()) {
            event.consume();
        } else {
            return;
        }

        Region source = (Region) event.getGestureSource();
        Region target = (Region) endRegion;

        if(host.getObjects().indexOf(target) > host.getObjects().indexOf(source)) {

            host.getObjects().remove(source);
            host.getObjects().add(host.getObjects().indexOf(target)+1, source);
        } else {

            host.getObjects().remove(source);
            host.getObjects().add(host.getObjects().indexOf(target), source);
        }

        if(preview!=null) {
            preview.close();
            preview = null;
        }

        host.update();

    }

    @Override
    public void handleMouseDragged(MouseEvent event) {
        if(preview!=null) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    preview.setX(event.getScreenX()+10);
                    preview.setY(event.getScreenY()+10);
                }
            });

        }
    }

    @Override
    public void handleMouseReleased(MouseEvent event) {

    }

    @Override
    public void handleMousePressed(MouseEvent event) {

    }
}
