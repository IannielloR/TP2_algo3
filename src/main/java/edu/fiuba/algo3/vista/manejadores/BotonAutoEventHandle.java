package edu.fiuba.algo3.vista.manejadores;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BotonAutoEventHandle implements EventHandler<ActionEvent> {

    private TipoVehiculo vehiculo;
    private Label labelVehiculo;

    public BotonAutoEventHandle(TipoVehiculo vehiculo, Label labelVehiculo) {
        this.vehiculo = vehiculo;
        this.labelVehiculo = labelVehiculo;
    }

    @Override
    public void handle(ActionEvent evento) {
        this.vehiculo = new Auto();
        this.labelVehiculo.setText("Auto");
    }
}