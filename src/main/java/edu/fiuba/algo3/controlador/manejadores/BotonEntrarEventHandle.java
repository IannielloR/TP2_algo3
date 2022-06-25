package edu.fiuba.algo3.controlador.manejadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonEntrarEventHandle implements EventHandler<ActionEvent> {
    private Button botonInicioJuego;

    Stage stage;
    private Scene escena;

    public BotonEntrarEventHandle(Stage stage, Scene proximaEscena) {
       // botonInicioJuego = inicio;
        this.escena = proximaEscena;
        this.stage = stage;

    }

    @Override
    public void handle(ActionEvent evento) {
        this.stage.setScene(this.escena);
        this.stage.setFullScreenExitHint("");
        this.stage.setFullScreen(true);
    }
}
