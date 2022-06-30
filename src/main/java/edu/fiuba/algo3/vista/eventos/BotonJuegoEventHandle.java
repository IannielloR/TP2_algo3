package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.ContenedorJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class BotonJuegoEventHandle implements EventHandler<ActionEvent> {

    Stage stage;
    private ContenedorJugador contenedorJugador;

    public BotonJuegoEventHandle(Stage stage, ContenedorJugador contenedorJugador) {
        this.contenedorJugador = contenedorJugador;
        this.stage = stage;

    }

    @Override
    public void handle(ActionEvent evento) {
        Scene escena;
        ContenedorJuego contenedorJuego;
        this.contenedorJugador.crearModelo();

        contenedorJuego = this.contenedorJugador.obtenerContenedorJuego();
        escena = new Scene(contenedorJuego, 800, 800);
        escena.setOnKeyPressed(new ControlesEventHandler(this.stage,this.contenedorJugador.obtenerJuego(),contenedorJuego.obtenerVistaJuego()));

        this.stage.setScene(escena);
        this.stage.setFullScreenExitHint("");
        this.stage.setFullScreen(false);
    }
}