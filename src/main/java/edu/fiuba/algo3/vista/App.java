package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) {
        stage.setTitle("GPS Challenge");

        ContenedorInicio contenedorInicio = new ContenedorInicio(stage);
        Scene escenaInicio = new Scene(contenedorInicio, 800, 800);

        contenedorInicio = new ContenedorInicio(stage, escenaInicio);
        escenaInicio = new Scene(contenedorInicio, 800, 800);

        contenedorInicio = new ContenedorInicio(stage, escenaInicio);
        escenaInicio = new Scene(contenedorInicio, 800, 800);

        stage.setScene(escenaInicio);
        stage.show();
    }
}