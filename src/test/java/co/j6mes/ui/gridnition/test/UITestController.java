package co.j6mes.ui.gridnition.test;

import co.j6mes.ui.gridnition.MultiObjectPane;
import com.sun.javafx.scene.control.skin.LabeledText;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Created by james on 30/04/2016.
 */
public class UITestController {
    @FXML
    MultiObjectPane pane;

    @FXML
    public void initialize() {
        System.out.println("Initialize UI");

        for (int i = 0; i<8; i++) {
            pane.addObject(new Label("Box "+ i));
        }

    }
}
