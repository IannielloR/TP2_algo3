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
    public void dibujar(int maxX, int maxY){
        this.dibujarMapa(maxX, maxY);
        //this.dibujarVehiculo();
    }
    private void dibujarMapa(int maxX, int maxY){
        //this.clean();
        canvas.getGraphicsContext2D().setFill(Color.RED);
        int[] cantidad = this.juego.obtenerTamanioMapa();
        cantidad[0] = cantidad[0] +1;
        cantidad[1] = cantidad[1] +1;
        float largoX = maxX / cantidad[0];
        float largoY = maxY / cantidad[1];
        float espacioCalleX = ((largoX*25)/100);
        float espacioCalleY = ((largoY*25)/100);
        for (float i = 0; i < ((largoY)*cantidad[1]); i += largoY){
            for(float j = 0; j < ((largoX)*cantidad[0]); j += largoX){
                canvas.getGraphicsContext2D().setFill(Color.GRAY);
                canvas.getGraphicsContext2D().fillRect(i, j, largoX, largoY);
                canvas.getGraphicsContext2D().setFill(Color.GREEN);
                canvas.getGraphicsContext2D().fillRect(i+10, j+10, (largoX-espacioCalleX), (largoY-espacioCalleY));
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
  /*  public  void update(){
        this.dibujar();
    }*/
}
