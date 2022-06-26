package edu.fiuba.algo3.vista.manejadores;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonAutoEventHandle implements EventHandler<ActionEvent> {
    private Button botonInicioJuego;

    Stage stage;

    public BotonAutoEventHandle(Stage stage) {
        this.stage = stage;

    }

    @Override
    public void handle(ActionEvent evento) {

    }
}