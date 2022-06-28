package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaJuego{
    private Juego juego;
    private TipoVehiculo vehiculo;
    Canvas canvas;
    Pane pane;

    public VistaJuego(Juego juego, TipoVehiculo vehiculo, Canvas canvas){
        this.juego = juego;
        this.vehiculo = vehiculo;
        this.canvas = canvas;
    }
    public void dibujar(){
        this.dibujarMapa();
        //this.dibujarVehiculo();
    }
    private void dibujarMapa(){
        //this.clean();
        canvas.getGraphicsContext2D().setFill(Color.RED);
        int[] tamanio = this.juego.obtenerTamanioMapa();
        for (int i = 0; i < (tamanio[0]*30); i += 30){
            for(int j = 0; j < (tamanio[1] * 30); j += 30){
                canvas.getGraphicsContext2D().setFill(Color.GRAY);
                canvas.getGraphicsContext2D().fillRect(i, j, 30, 30);
                canvas.getGraphicsContext2D().setFill(Color.GREEN);
                canvas.getGraphicsContext2D().fillRect(i, j, 20, 20);
            }
        }

    }
    private void dibujarVehiculo(){
        this.clean();

        if(this.vehiculo.getClass() == Moto.class){
            canvas.getGraphicsContext2D().setFill(Color.RED);
            canvas.getGraphicsContext2D().fillRect(0,0,468,220);
        }
        if(this.vehiculo.getClass() == Auto.class){
            canvas.getGraphicsContext2D().setFill(Color.BLUE);
            canvas.getGraphicsContext2D().fillRect(0,0,468,220);
        }
        if(this.vehiculo.getClass() == CuatroXCuatro.class){
            canvas.getGraphicsContext2D().setFill(Color.BLACK);
            canvas.getGraphicsContext2D().fillRect(0,0,468,220);
        }

    }

    private void clean(){
        canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
        canvas.getGraphicsContext2D().fillRect(0,0,468,220);
    }
    public  void update(){
        this.dibujar();
    }
}
