package co.j6mes.ui.gridnition;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 30/04/2016.
 */
public class MultiObjectPane extends VBox {

    private List<Region> objects = new ArrayList<>();

    private int numPerRow = 2;
    private int minWidth = 100;
    private int maxWidth = 200;

    public MultiObjectPane() {
        this.setFillWidth(true);
        this.setCenterShape(true);
    }
    public synchronized void addObject(Region object) {
        objects.add(object);
    }

    private void redraw() {
        System.out.println("Redraw");
        int done = 0;
        HBox currHBox = new HBox();

        for(Region obj : objects) {

            currHBox.getChildren().add(obj);
            currHBox.setAlignment(Pos.CENTER);
            done++;


            if(done % numPerRow == 0) {
                this.getChildren().add(currHBox);
                currHBox = new HBox();
            }

        }

        if(currHBox.getChildren().size()>0) {
            this.getChildren().add(currHBox);
        }
    }

    @Override
    public void layoutChildren() {
        for(Region n : objects) {
            n.setPrefWidth(this.getWidth()/numPerRow);
        }

        this.getChildren().clear();
        redraw();

        super.layoutChildren();

    }

}
