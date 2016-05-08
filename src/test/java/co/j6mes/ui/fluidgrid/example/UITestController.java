package co.j6mes.ui.fluidgrid.example;

import co.j6mes.ui.fluidgrid.MultiObjectPane;
import co.j6mes.ui.fluidgrid.extension.DragAndDrop;
import co.j6mes.ui.fluidgrid.extension.Selection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by james on 30/04/2016.
 */
public class UITestController {
    @FXML
    MultiObjectPane pane;

    @FXML
    public void initialize() {
        Selection selection = new Selection();
        pane.registerExtension(selection);

        pane.registerExtension(new DragAndDrop());

        System.out.println("Initialize UI");

        for (int i = 0; i<8; i++) {
            pane.addObject(new Label("Box "+ i));
        }

        Image img = new Image("test.png");
        for (int i = 0; i < 5; i++) {
            ImageView imgView = new ImageView(img);



            imgView.setPreserveRatio(true);

            pane.addObject(imgView);
        }

    }
}
