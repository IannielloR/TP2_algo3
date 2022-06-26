package edu.fiuba.algo3.vista.manejadores;

import edu.fiuba.algo3.vista.ContenedorJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonCuatroXCuatroEventHandle implements EventHandler<ActionEvent> {
    private Button botonInicioJuego;

    Stage stage;


    public BotonCuatroXCuatroEventHandle(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent evento) {
    }
}