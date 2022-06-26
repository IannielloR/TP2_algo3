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

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();


        Button botonInicio = new Button("inicio");
        HBox ContenedorInicio = new HBox(botonInicio);
        Button botonRanking = new Button("ranking");


        ContenedorJugador contenedorJugador = new ContenedorJugador(stage);
        Scene escenaJugador = new Scene(ContenedorJugador, 640, 480);

        ContenedorRanking contenedorRanking = new ContenedorRanking(stage);
        Scene escenaRanking = new Scene(botonRanking, 640, 480);

        ContenedorInicio contenedorInicio = new ContenedorInicio(stage, escenaJugador, escenaRanking);
        Scene escenaInicio = new Scene(contenedorInicio, 640, 480);

        stage.setScene(escenaInicio);
        stage.show();
    }

    private Juego crearModelo() {
        TipoVehiculo tipoVehiculo = new Auto();

        Juego juego = new Juego(tipoVehiculo, 10, 10);
        return juego;
    }

    public static void main(String[] args) {
        launch();
    }

}