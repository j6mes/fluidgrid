package co.j6mes.ui.fluidgrid;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 30/04/2016.
 */
public class MultiObjectPane extends VBox {

    private List<Region> objects = new ArrayList<>();

    private int transitionsize = 340;

    public MultiObjectPane() {
        this.setFillWidth(true);
        this.setCenterShape(true);
    }

    public synchronized void addObject(Region object) {
        objects.add(object);
        layoutChildren();
    }

    public synchronized void addObject(ImageView object) {
        objects.add(new Pane(object));
        layoutChildren();
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

}