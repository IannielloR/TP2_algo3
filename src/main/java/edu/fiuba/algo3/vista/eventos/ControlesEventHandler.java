package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.vista.VistaJuego;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class ControlesEventHandler  implements EventHandler<KeyEvent> {
    private Stage stage;
    private Juego juego;
    private VistaJuego vistaJuego;

    public ControlesEventHandler(Stage stage, Juego juego, VistaJuego vistaJuego){
        this.juego = juego;
        this.stage = stage;
        this.vistaJuego = vistaJuego;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()){
            case UP:
                this.juego.moverVehiculoArriba();
                this.vistaJuego.update();
                break;
            case DOWN:
                this.juego.moverVehiculoAbajo();
                this.vistaJuego.update();
                break;
            case RIGHT:
                this.juego.moverVehiculoDerecha();
                this.vistaJuego.update();
                break;
            case LEFT:
                this.juego.moverVehiculoIzquierda();
                this.vistaJuego.update();
                break;
        }

    }
}
