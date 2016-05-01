package co.j6mes.ui.fluidgrid.tiled;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UITest extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("grid2.fxml"));

        Scene scene = new Scene(root, 300, 275);

        stage.setTitle("Gridnition Example");
        stage.setScene(scene);
        stage.show();






    }

    public static void main(String[] args) {
        launch(args);
    }
}
