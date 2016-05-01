package co.j6mes.ui.fluidgrid.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UITest extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("grid.fxml"));

        Scene scene = new Scene(root, 300, 275);


        scene.getStylesheets().add("example.css");

        stage.setTitle("Gridnition Example");
        stage.setScene(scene);
        stage.show();






    }

    public static void main(String[] args) {
        launch(args);
    }
}
