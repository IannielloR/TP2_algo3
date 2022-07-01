package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class ContenedorJuego extends BorderPane{
    Stage stage;
    BarraDeMenu menuBar;
    VistaJuego vistaJuego;
    Canvas canvasCentral;
    VBox contenedorCentral;
    public ContenedorJuego(Stage stage, Juego juego, TipoVehiculo vehiculo){
        this.setMenu();
        this.setCentro(juego, vehiculo);
        // Image imagen = new Image(path);
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.SPACE, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //this.setBackground(new Background(imagenDeFondo));
    }
    private void  setMenu(){
        this.menuBar = new BarraDeMenu(this.stage);
        this.setTop(menuBar);
    }

    private void setCentro(Juego juego, TipoVehiculo vehiculo){
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
        vistaJuego = new VistaJuego(juego, vehiculo, canvasCentral);
        vistaJuego.dibujar(maxX, maxY );
        contenedorCentral = new VBox(canvasCentral);

        //contenedorCentral.setAlignment(Pos.CENTER);
        //contenedorCentral.setSpacing(20);
        //contenedorCentral.(new Insets(this.menuBar.getHeight()));


        Image moto = new Image("file:src/vista/imagenes/moto.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(moto, BackgroundRepeat.SPACE, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
    }
    public VistaJuego obtenerVistaJuego(){
        return  vistaJuego;
    }

}

