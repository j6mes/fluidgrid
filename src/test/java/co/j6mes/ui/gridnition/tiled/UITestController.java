package co.j6mes.ui.gridnition.tiled;

import co.j6mes.ui.gridnition.MultiObjectPane;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

/**
 * Created by james on 30/04/2016.
 */
public class UITestController {
    @FXML
    TilePane pane;

    @FXML
    public void initialize() {
        System.out.println("Initialize UI");

        for (int i = 0; i<8; i++) {
            pane.getChildren().add(new Label("Box "+ i));
        }

        Image img = new Image("test.png");
        for (int i = 0; i < 5; i++) {
            ImageView imgView = new ImageView(img);

            imgView.setPreserveRatio(true);
            pane.getChildren().add(imgView);
        }

    }
}
