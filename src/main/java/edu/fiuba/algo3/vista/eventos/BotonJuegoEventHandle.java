package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.vista.ContenedorJuego;
import edu.fiuba.algo3.vista.ContenedorJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonJuegoEventHandle implements EventHandler<ActionEvent> {
    Stage stage;
    private ContenedorJugador contenedorJugador;
    private Scene escenaInicio;

    public BotonJuegoEventHandle(Stage stage, ContenedorJugador contenedorJugador, Scene escenaInicio) {
        this.contenedorJugador = contenedorJugador;
        this.stage = stage;
        this.escenaInicio = escenaInicio;
    }

    @Override
    public void handle(ActionEvent evento) {
        Scene escena;
        ContenedorJuego contenedorJuego;
        this.contenedorJugador.crearModelo();
        int[] cantidad = this.contenedorJugador.obtenerJuego().obtenerTamanioMapa();
        cantidad[0] = cantidad[0] + 1;
        cantidad[1] = cantidad[1] + 1;
        int largoCuadra;
        int maxX = 1024;
        int maxY = 768;
        if(cantidad[0]> cantidad[1]){
            largoCuadra = maxX/cantidad[0];
            maxX = cantidad[0]*largoCuadra;
            maxY = cantidad[1]*largoCuadra;
        }else {
            largoCuadra = maxY/cantidad[1];
            maxX = cantidad[0]*largoCuadra;
            maxY = cantidad[1]*largoCuadra;
        }
        contenedorJuego = this.contenedorJugador.obtenerContenedorJuego();
        escena = new Scene(contenedorJuego, maxX, (maxY+35));
        escena.setOnKeyPressed(new ControlesEventHandler(this.stage,this.contenedorJugador.obtenerJuego(),contenedorJuego.obtenerVistaJuego(), this.escenaInicio));

        this.stage.setResizable(false);
        this.stage.setScene(escena);
        this.stage.setFullScreenExitHint("");
        this.stage.setFullScreen(false);
    }
}