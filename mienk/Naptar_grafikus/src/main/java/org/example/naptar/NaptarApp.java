package org.example.naptar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NaptarApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load(), 950, 400);

        stage.setScene(scene);
        stage.setTitle("Naptár alkalmazás");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
