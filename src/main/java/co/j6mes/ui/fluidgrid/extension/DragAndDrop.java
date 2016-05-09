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

    Node sourceDD = null;
    Node overDD = null;


    @Override
    public void registerHost(ExtensionManager exm, MultiEventHandle events) {
        this.host = exm;

        events.addHandleMouseDragExited(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                if(preview !=null) {
                    preview.hide();
                }

                if(sourceDD != null) {
                    sourceDD.getStyleClass().removeAll("drag-launch");
                }

                if(overDD != null) {
                    overDD.getStyleClass().removeAll("drag-over");
                }
            }
        });

        events.addHandleMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                if(preview !=null) {
                    preview.show();
                }

                if(sourceDD != null) {
                    sourceDD.getStyleClass().add("drag-launch");
                }

                if(overDD != null) {
                    overDD.getStyleClass().add("drag-over");
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

        events.addHandleMouseDragReleased(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                if(sourceDD != null) {
                    sourceDD.getStyleClass().removeAll("drag-launch");
                }

                if(overDD != null) {
                    overDD.getStyleClass().removeAll("drag-over");
                }
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


        sourceDD = (Node) event.getSource();
        ((Node)event.getSource()).getStyleClass().add("drag-launch");
    }

    @Override
    public void handleDragOver(DragEvent event) {
        System.out.println("Drag over");
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
    public void handleMouseDragExited(MouseDragEvent event) {

    }

    @Override
    public void handleMouseDragEntered(MouseDragEvent event) {
        if(overDD != null) {
            overDD.getStyleClass().removeAll("drag-over");
        }
        overDD = ((Node)event.getSource());
        ((Node)event.getSource()).getStyleClass().add("drag-over");
    }

    @Override
    public void handleDragDropped(DragEvent event) {
    }

    @Override
    public void handleDragDone(DragEvent event) {

    }

    @Override
    public void handleMouseDragReleased(Node endRegion, MouseDragEvent event) {
        Region source = (Region) event.getGestureSource();
        Region target = (Region) endRegion;

        sourceDD = null;

        source.getStyleClass().removeAll("drag-launch");

        if(source.equals(target)) {
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
