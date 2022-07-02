package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.GPSChallenge.Juego;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.*;

public class ContenedorJuego extends BorderPane{
    VistaJuego vistaJuego;
    Canvas canvasCentral;
    VBox contenedorCentral;
    public ContenedorJuego(Juego juego){
        this.setCentro(juego);
    }

    private void setCentro(Juego juego){
        int[] cantidad = juego.obtenerTamanioMapa();
        cantidad[0] = cantidad[0] + 1;
        cantidad[1] = cantidad[1] + 1;
        int maxX =1024;
        int maxY =768;
        if(cantidad[0]> cantidad[1]){
            maxY = (maxX/cantidad[0])*cantidad[1];
        }else {
            maxX = (maxY/cantidad[1])*cantidad[0];
        }
        canvasCentral = new Canvas(maxX, (maxY+35));
        vistaJuego = new VistaJuego(juego, canvasCentral);
        vistaJuego.dibujar(maxX, maxY );
        contenedorCentral = new VBox(canvasCentral);
        this.setCenter(contenedorCentral);
    }

    public VistaJuego obtenerVistaJuego(){
        return  vistaJuego;
    }
}
