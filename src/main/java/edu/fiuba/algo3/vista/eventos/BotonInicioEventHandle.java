package edu.fiuba.algo3.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonInicioEventHandle implements EventHandler<ActionEvent> {
    Stage stage;
    private Scene escena;

    public BotonInicioEventHandle(Stage stage, Scene proximaEscena) {
        this.escena = proximaEscena;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent evento) {
        this.stage.setScene(this.escena);
        this.stage.setFullScreenExitHint("");
        this.stage.setFullScreen(false);
    }
}
