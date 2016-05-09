package co.j6mes.ui.fluidgrid;

import co.j6mes.ui.fluidgrid.extension.Extension;
import co.j6mes.ui.fluidgrid.extension.ExtensionManager;
import co.j6mes.ui.fluidgrid.extension.Selection;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

public class MultiObjectPane extends VBox implements ExtensionManager,MultiEventHandle, Extension {

    private List<Region> objects = new ArrayList<>();
    private List<Extension> extensions = new ArrayList<>();

    private IntegerProperty transitionSize = new SimpleIntegerProperty(340);
    private IntegerProperty maxInline = new SimpleIntegerProperty(10);

    public final int getMaxInline() {
        return maxInline.get();
    }

    public final void setMaxInline(int value) {
        maxInline.set(value);
    }

    public IntegerProperty maxInlineProperty() {
        return maxInline;
    }

    public final int getTransitionSize() {
        return transitionSize.get();
    }

    public final void setTransitionSize(int value) {
        transitionSize.set(value);
    }

    public IntegerProperty transitionSizeProperty() {
        return transitionSize;
    }


    public MultiObjectPane() {
        this.setFillWidth(true);
        this.setCenterShape(true);
        this.registerHost(this,this);

        transitionSize.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                redraw();
            }
        });

        maxInline.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                redraw();
            }
        });
    }

    public synchronized void addObject(Region object) {
        objects.add(object);
        layoutChildren();
        register(object);
    }

    public synchronized void addObject(ImageView object) {
        Pane p = new Pane(object);
        register(p);

        objects.add(p);
        layoutChildren();
    }

    @Override
    public void registerHost(ExtensionManager exm, MultiEventHandle events) {
        final MultiObjectPane tthis = this;
        this.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                handleContextMenu(event);
            }
        });

        this.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handleDragDetected(event);
            }
        });

        this.setOnDragDone(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                handleDragDone(event);
            }
        });

        this.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                handleDragDropped(event);
            }
        });

        this.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                handleDragEntered(event);
            }
        });

        this.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                handleDragExited(event);
            }
        });

        this.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                handleDragOver(event);
            }
        });


        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handleMouseClicked(event);
            }
        });

        this.setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                handleMouseDragEntered(event);
            }
        });

        this.setOnMouseDragExited(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                handleMouseDragExited(event);
            }
        });

        this.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                handleMouseDragReleased(tthis,event);
            }
        });

        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handleMousePressed(event);
            }
        });

        this.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handleMouseReleased(event);
            }
        });

        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handleMouseDragged(event);
            }
        });
    }

    @Override
    public void register(Node object) {
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

        object.setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                for(Extension extension : extensions) {
                    extension.handleMouseDragEntered(event);
                }
            }
        });

        object.setOnMouseDragExited(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                for(Extension extension : extensions) {
                    extension.handleMouseDragExited(event);
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

        object.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for (Extension extension : extensions) {
                    extension.handleMousePressed(event);
                }
            }
        });


        object.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for (Extension extension : extensions) {
                    extension.handleMouseReleased(event);
                }
            }
        });

    }





    private void redraw() {
        //System.out.println("Redraw");
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
        for (int i = 1; i<maxInline.get(); i++) {
            if(this.getWidth() < i* transitionSize.get()) {
                return i;
            }
        }
        return maxInline.get();
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
        extension.registerHost(this,this);
    }

    @Override
    public List<Region> getObjects() {
        return objects;
    }

    @Override
    public void update() {
        redraw();
    }

    private List<EventHandler<ContextMenuEvent>> contextMenuEvents = new ArrayList<>();

    @Override
    public void addHandleContextMenu(EventHandler<ContextMenuEvent> event) {
        contextMenuEvents.add(event);
    }

    private List<EventHandler<MouseEvent>> dragDetectedEvents = new ArrayList<>();
    @Override
    public void addHandleDragDetected(EventHandler<MouseEvent> event) {
        dragDetectedEvents.add(event);
    }

    private List<EventHandler<DragEvent>> dragOverEvents = new ArrayList<>();
    @Override
    public void addHandleDragOver(EventHandler<DragEvent> event) {
        dragOverEvents.add(event);
    }

    private List<EventHandler<MouseEvent>> mouseClickedEvents = new ArrayList<>();
    @Override
    public void addHandleMouseClicked(EventHandler<MouseEvent> event) {
        mouseClickedEvents.add(event);
    }

    private List<EventHandler<DragEvent>> dragExitedEvents = new ArrayList<>();
    @Override
    public void addHandleDragExited(EventHandler<DragEvent> event) {
        dragExitedEvents.add(event);
    }

    private List<EventHandler<DragEvent>> dragEnteredEvents = new ArrayList<>();
    @Override
    public void addHandleDragEntered(EventHandler<DragEvent> event) {
        dragEnteredEvents.add(event);
    }

    private List<EventHandler<MouseDragEvent>> dragMouseExitedEvents = new ArrayList<>();
    @Override
    public void addHandleMouseDragExited(EventHandler<MouseDragEvent> event) {
        dragMouseExitedEvents.add(event);
    }

    private List<EventHandler<MouseDragEvent>> dragMouseEnteredEvents = new ArrayList<>();
    @Override
    public void addHandleMouseDragEntered(EventHandler<MouseDragEvent> event) {
        dragMouseEnteredEvents.add(event);
    }

    private List<EventHandler<DragEvent>> dragDroppedEvents = new ArrayList<>();
    @Override
    public void addHandleDragDropped(EventHandler<DragEvent> event) {
        dragDroppedEvents.add(event);
    }

    private List<EventHandler<DragEvent>> dragDoneEvents = new ArrayList<>();
    @Override
    public void addHandleDragDone(EventHandler<DragEvent> event) {
        dragDoneEvents.add(event);
    }

    private List<EventHandler<MouseDragEvent>> mouseDragReleasedEvents = new ArrayList<>();
    @Override
    public void addHandleMouseDragReleased(EventHandler<MouseDragEvent> event) {
        mouseDragReleasedEvents.add(event);
    }

    private List<EventHandler<MouseEvent>> mouseDraggedEvents = new ArrayList<>();
    @Override
    public void addHandleMouseDragged(EventHandler<MouseEvent> event) {
        System.out.println("Register mouse drag");
        mouseDraggedEvents.add(event);
    }

    private List<EventHandler<MouseEvent>> mouseReleasedEvents = new ArrayList<>();
    @Override
    public void addHandleMouseReleased(EventHandler<MouseEvent> event) {
        mouseReleasedEvents.add(event);
    }

    private List<EventHandler<MouseEvent>> mousePressedEvents = new ArrayList<>();
    @Override
    public void addHandleMousePressed(EventHandler<MouseEvent> event) {
        mousePressedEvents.add(event);
    }


    @Override
    public void handleContextMenu(ContextMenuEvent event) {
        for (EventHandler<ContextMenuEvent> h : contextMenuEvents) {
            h.handle(event);
        }
    }

    @Override
    public void handleDragDetected(MouseEvent event) {
        for (EventHandler<MouseEvent> h : dragDetectedEvents) {
            h.handle(event);
        }
    }

    @Override
    public void handleDragOver(DragEvent event) {
        for (EventHandler<DragEvent> h : dragOverEvents) {
            h.handle(event);
        }
    }

    @Override
    public void handleMouseClicked(MouseEvent event) {
        for (EventHandler<MouseEvent> h : mouseClickedEvents) {
            h.handle(event);
        }
    }

    @Override
    public void handleDragExited(DragEvent event) {
        for (EventHandler<DragEvent> h : dragExitedEvents) {
            h.handle(event);
        }
    }

    @Override
    public void handleDragEntered(DragEvent event) {
        for (EventHandler<DragEvent> h : dragEnteredEvents) {
            h.handle(event);
        }
    }

    @Override
    public void handleMouseDragExited(MouseDragEvent event) {
        for (EventHandler<MouseDragEvent> h : dragMouseExitedEvents) {
            h.handle(event);
        }
    }

    @Override
    public void handleMouseDragEntered(MouseDragEvent event) {
        for (EventHandler<MouseDragEvent> h : dragMouseEnteredEvents) {
            h.handle(event);
        }
    }

    @Override
    public void handleDragDropped(DragEvent event) {
        for (EventHandler<DragEvent> h : dragDroppedEvents) {
            h.handle(event);
        }
    }

    @Override
    public void handleDragDone(DragEvent event) {
        for (EventHandler<DragEvent> h : dragDoneEvents) {
            h.handle(event);
        }
    }

    @Override
    public void handleMouseDragReleased(Node endRegion, MouseDragEvent event) {
        for (EventHandler<MouseDragEvent> h : mouseDragReleasedEvents) {
            h.handle(event);
        }
    }

    @Override
    public void handleMouseDragged(MouseEvent event) {
        for (EventHandler<MouseEvent> h : mouseDraggedEvents) {
            h.handle(event);
        }
    }

    @Override
    public void handleMouseReleased(MouseEvent event) {
        for (EventHandler<MouseEvent> h : mouseReleasedEvents) {
            h.handle(event);
        }
    }

    @Override
    public void handleMousePressed(MouseEvent event) {
        for (EventHandler<MouseEvent> h : mousePressedEvents) {
            h.handle(event);
        }
    }
}
