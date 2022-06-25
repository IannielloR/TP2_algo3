package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.manejadores.BotonEntrarEventHandle;
import edu.fiuba.algo3.vista.ContenedorInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        // var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");

        // Label etiqueta = new Label();
        Button botonInicio = new Button("inicio");
        HBox ContenedorInicio = new HBox(botonInicio);
        Button botonRanking = new Button("ranking");

        // HBox contenedorHorizon = new HBox(botonInicio);

        Scene escenaJuego = new Scene(ContenedorInicio, 640, 480);

        Scene escenaRanking = new Scene(botonRanking, 640, 480);

        ContenedorInicio contenedorInicio = new ContenedorInicio(stage, escenaJuego, escenaRanking);

        Scene escenaInicio = new Scene(contenedorInicio, 640, 480);

        stage.setScene(escenaInicio);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}