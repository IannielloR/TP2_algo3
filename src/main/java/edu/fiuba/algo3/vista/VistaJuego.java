package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class VistaJuego{
    private Juego juego;
    private TipoVehiculo vehiculo;
    Canvas canvas;

    public VistaJuego(Juego juego, TipoVehiculo vehiculo, Canvas canvas){
        this.juego = juego;
        this.vehiculo = vehiculo;
        this.canvas = canvas;
    }
    public void dibujar(int maxX, int maxY){
        /*
        Rectangle rec1 = new Rectangle(10,10,Color.BLUE);
        Rectangle rec2 = new Rectangle(10,10,Color.RED);

        GridPane panel = new GridPane();
        panel.add(rec1,0,0);
        panel.add(rec2,0,1);

        Scene display = new Scene(panel);


        return display;
        */
        this.dibujarMapa(maxX,maxY);
//        this.dibujarVehiculo();
    }
    private void dibujarMapa(int maxX, int maxY) {
        //this.clean();
        canvas.getGraphicsContext2D().setFill(Color.GRAY);
        canvas.getGraphicsContext2D().fillRect(0, 0, maxX, maxY);


        int[] cantidad = this.juego.obtenerTamanioMapa();
        cantidad[0] = cantidad[0] + 1;
        cantidad[1] = cantidad[1] + 1;
        float largoX = 50;
        float largoY = 50;
        float espacioCalleX = ((largoX * 25) / 100);
        float espacioCalleY = ((largoY * 25) / 100);
        for (float i = 0; i < ((largoX) * cantidad[0]); i += largoX) {
            for (float j = 0; j < ((largoY) * cantidad[1]); j += largoY) {
                canvas.getGraphicsContext2D().setFill(Color.GREEN);
                canvas.getGraphicsContext2D().fillRect(i + espacioCalleX, j + espacioCalleY, (largoX - espacioCalleX), (largoY - espacioCalleY));
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

//        this.dibujar(800, 800);
    }
}
