package edu.fiuba.algo3.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonVolverAtrasEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    private Scene escena;

    public BotonVolverAtrasEventHandler(Stage stage, Scene escenaActual) {
        this.escena = escenaActual;
        this.stage = stage;

    }

    @Override
    public void handle(ActionEvent evento) {
        this.stage.toBack();
        this.stage.setFullScreenExitHint("");
        this.stage.setFullScreen(false);
    }
}