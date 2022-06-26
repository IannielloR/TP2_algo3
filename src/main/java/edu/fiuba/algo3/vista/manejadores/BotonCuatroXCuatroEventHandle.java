package edu.fiuba.algo3.vista.manejadores;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import edu.fiuba.algo3.vista.ContenedorJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BotonCuatroXCuatroEventHandle implements EventHandler<ActionEvent> {
    private TipoVehiculo vehiculo;
    private Label labelVehiculo;

    public BotonCuatroXCuatroEventHandle(TipoVehiculo vehiculo, Label labelVehiculo) {
        this.vehiculo = vehiculo;
        this.labelVehiculo = labelVehiculo;
    }

    @Override
    public void handle(ActionEvent evento) {
        this.vehiculo = new CuatroXCuatro();
        this.labelVehiculo.setText("4x4");
    }
}