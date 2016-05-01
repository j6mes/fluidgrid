package co.j6mes.ui.gridnition;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 30/04/2016.
 */
public class MultiObjectPane extends VBox {

    private List<Region> objects = new ArrayList<>();

    private int transitionsize = 340;
    private int grid1size = transitionsize * 1;
    private int grid2size = transitionsize * 2;
    private int grid3size = transitionsize * 3;
    private int grid4size = transitionsize * 5;

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
        if(this.getWidth() < grid1size) {
            return 1;
        } else if (this.getWidth() < grid2size) {
            return 2;
        } else if (this.getWidth() < grid3size) {
            return 3;
        } else if (this.getWidth() < grid4size) {
            return 4;
        }
        return 5;
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
