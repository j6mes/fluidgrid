package co.j6mes.ui.fluidgrid;

import co.j6mes.ui.fluidgrid.extension.Extension;
import co.j6mes.ui.fluidgrid.extension.ExtensionManager;
import co.j6mes.ui.fluidgrid.extension.Selection;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

public class MultiObjectPane extends VBox implements ExtensionManager {

    private List<Region> objects = new ArrayList<>();
    private List<Extension> extensions = new ArrayList<>();

    private int transitionsize = 340;

    public MultiObjectPane() {
        this.setFillWidth(true);
        this.setCenterShape(true);
    }

    public synchronized void addObject(Region object) {
        objects.add(object);
        layoutChildren();
        registerObject(object);
    }

    public synchronized void addObject(ImageView object) {
        Pane p = new Pane(object);
        registerObject(p);


        objects.add(p);
        layoutChildren();
        registerObject(object);
    }

    private void registerObject(Node object) {
        for(Extension extension : extensions) {
            extension.register(object);
        }

        object.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                for(Extension extension : extensions) {
                    extension.handleContextMenu(event);
                }
            }
        });


        object.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for(Extension extension : extensions) {
                    extension.handleDragDetected(event);
                }
            }
        });

        object.setOnDragDone(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                for(Extension extension : extensions) {
                    extension.handleDragDone(event);
                }
            }
        });

        object.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                for(Extension extension : extensions) {
                    extension.handleDragDropped(event);
                }
            }
        });

        object.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                for(Extension extension : extensions) {
                    extension.handleDragEntered(event);
                }
            }
        });

        object.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                for(Extension extension : extensions) {
                    extension.handleDragExited(event);
                }
            }
        });

        object.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                for(Extension extension : extensions) {
                    extension.handleDragOver(event);
                }
            }
        });

        object.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for(Extension extension : extensions) {
                    extension.handleMouseClicked(event);
                }
            }
        });

        object.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                for (Extension extension : extensions) {
                    extension.handleMouseDragReleased(object, event);
                }
            }
        });
    }



    private void redraw() {
        System.out.println("Redraw");
        int done = 0;
        HBox currHBox = new HBox();

        for(Region obj : objects) {
            currHBox.getChildren().add(obj);
            currHBox.setAlignment(Pos.CENTER);
            done++;


            if(done % getNumPerRow() == 0) {
                this.getChildren().add(currHBox);
                currHBox = new HBox();
            }

        }

        if(currHBox.getChildren().size()>0) {
            currHBox.setAlignment(Pos.CENTER_LEFT);
            this.getChildren().add(currHBox);

        }
    }


    private int getNumPerRow() {
        for (int i = 1; i<10; i++) {
            if(this.getWidth() < i*transitionsize) {
                return i;
            }
        }
        return 10;
    }

    @Override
    public synchronized void layoutChildren() {

        double rowSize = this.getWidth()/this.getNumPerRow();

        for(Region n : objects) {
            n.setPrefWidth(rowSize);

            if(n instanceof Pane) {
                if(((Pane)n).getChildren().size()>0) {
                    for(Node child : ((Pane)n).getChildren()) {
                        if(child instanceof ImageView) {
                            ((ImageView) child).setFitWidth(rowSize);
                        }
                    }
                }
            }
        }

        this.getChildren().clear();
        redraw();

        super.layoutChildren();

    }

    public void registerExtension(Extension extension) {
        extensions.add(extension);
        extension.registerHost(this);
    }

    @Override
    public List<Region> getObjects() {
        return objects;
    }
}
