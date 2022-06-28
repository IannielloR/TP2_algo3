package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) {
       // var javaVersion = SystemInfo.javaVersion();
       // var javafxVersion = SystemInfo.javafxVersion();
        stage.setTitle("GPS Challenge");

        Button botonInicio = new Button("inicio");
        HBox ContenedorInicio = new HBox(botonInicio);
        Button botonRanking = new Button("ranking");

        ContenedorJugador contenedorJugador = new ContenedorJugador(stage);
        Scene escenaJugador = new Scene(contenedorJugador, 800, 800);

        ContenedorRanking contenedorRanking = new ContenedorRanking(stage);
        Scene escenaRanking = new Scene(botonRanking, 800, 800);

        ContenedorInicio contenedorInicio = new ContenedorInicio(stage, escenaJugador, escenaRanking);
        Scene escenaInicio = new Scene(contenedorInicio, 800, 800);

        stage.setScene(escenaInicio);
        stage.show();
    }



}