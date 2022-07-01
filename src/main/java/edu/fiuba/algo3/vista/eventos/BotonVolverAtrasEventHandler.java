package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.vista.ContenedorInicio;
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

        ContenedorInicio contenedorInicio = new ContenedorInicio(stage);
        Scene escenaInicio = new Scene(contenedorInicio, 800, 800);

        contenedorInicio = new ContenedorInicio(stage, escenaInicio);
        escenaInicio = new Scene(contenedorInicio, 800, 800);

        contenedorInicio = new ContenedorInicio(stage, escenaInicio);
        escenaInicio = new Scene(contenedorInicio, 800, 800);

        stage.setScene(escenaInicio);
        stage.show();
    }
}