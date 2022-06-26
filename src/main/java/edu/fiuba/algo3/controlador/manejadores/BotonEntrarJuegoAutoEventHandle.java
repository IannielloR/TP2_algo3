package edu.fiuba.algo3.controlador.manejadores;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.ContenedorJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonEntrarJuegoAutoEventHandle implements EventHandler<ActionEvent> {
    private Button botonInicioJuego;

    Stage stage;
    TipoVehiculo tipoVehiculo;

    public BotonEntrarJuegoAutoEventHandle(Stage stage, TipoVehiculo tipoVehiculo) {
        // botonInicioJuego = inicio;

        this.stage = stage;
        this.tipoVehiculo = tipoVehiculo;

    }

    @Override
    public void handle(ActionEvent evento) {
        this.tipoVehiculo = new Auto();

    }
}