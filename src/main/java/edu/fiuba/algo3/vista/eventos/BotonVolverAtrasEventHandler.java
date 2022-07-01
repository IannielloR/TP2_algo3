package edu.fiuba.algo3.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonVolverAtrasEventHandler implements EventHandler<ActionEvent> {

    Stage stage;

    public BotonVolverAtrasEventHandler(Stage stage) {
        this.stage = stage;

    }

    @Override
    public void handle(ActionEvent evento) {
        stage.getScene();
        this.stage.setFullScreenExitHint("");
        this.stage.setFullScreen(false);
    }
}