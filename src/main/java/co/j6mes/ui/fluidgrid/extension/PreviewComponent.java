package co.j6mes.ui.fluidgrid.extension;

import javafx.embed.swing.JFXPanel;
import javafx.scene.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.awt.*;

/**
 * Created by james on 08/05/2016.
 */
class PreviewComponent extends Stage {

    public PreviewComponent(Region n) {
        SnapshotParameters snp = new SnapshotParameters();

        WritableImage image  = n.snapshot(snp,null);

        Group g = new Group();
        g.getChildren().add(new ImageView(image));

        Scene newScene = new Scene(g, n.getWidth(),n.getHeight());

        g.getChildren().add(n);
        this.initStyle(StageStyle.UNDECORATED);
        this.setScene(newScene);
        this.setOpacity(0.5);
        this.show();
    }

    public void close() {
        this.hide();
    }

}
