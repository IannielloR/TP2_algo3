package edu.fiuba.algo3.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonVolverAtrasEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene escena;

    public BotonVolverAtrasEventHandler(Stage stage, Scene scene) {
        this.stage = stage;
        this.escena = scene;
    }

    @Override
    public void handle(ActionEvent evento) {
        this.stage.setScene(this.escena);
        stage.show();
    }
}