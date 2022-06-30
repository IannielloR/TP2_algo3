package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaFavorable;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;

public class VistaJuego{
    private Juego juego;
    private TipoVehiculo vehiculo;

    private int largoCuadraX;
    private int largoCuadraY;
    private int espacioCalleX;
    private int espacioCalleY;
    private int largoCuadra;
    private int espacioCalle;


    //private int largo
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


        this.dibujarInterferencias();

        this.dibujarMascara();
        this.dibujarMeta();
        this.dibujarVisivilidadJugador(maxX,maxY);
        this.dibujarVehiculo();
    }
    private int[] coordenadasVehiculo(){
        int [] coordenada = juego.obtenerCoordenada();
        coordenada[0] = ((coordenada[0] *this.largoCuadra) + (espacioCalle/4));
        coordenada[1] = ((coordenada[1] *this.largoCuadra) + (espacioCalle/4));
        return coordenada;
    }
    private int[] coordenadasMeta(){
        int [] coordenada = juego.obtenerCoordenadaMeta();
        coordenada[0] = (coordenada[0] *this.largoCuadra);
        coordenada[1] = (coordenada[1] *this.largoCuadra);
        return coordenada;
    }
    private void dibujarMapa(int maxX, int maxY) {
        // this.clean();
        int[] cantidad = this.juego.obtenerTamanioMapa();
        cantidad[0] = cantidad[0] + 1;
        cantidad[1] = cantidad[1] + 1;
        if(cantidad[0]> cantidad[1]){
            largoCuadra = maxX/cantidad[0];
            maxX = cantidad[0]*largoCuadra;
            maxY = cantidad[1]*largoCuadra;
        }else {
            largoCuadra = maxY/cantidad[1];
            maxX = cantidad[0]*largoCuadra;
            maxY = cantidad[1]*largoCuadra;
        }
        canvas.getGraphicsContext2D().setFill(Color.GRAY);
        canvas.getGraphicsContext2D().fillRect(0, 0, maxX, maxY);


        if(cantidad[0]> cantidad[1]){
            largoCuadra = maxX/cantidad[0];
        }else {
            largoCuadra = maxY/cantidad[1];
        }
        this.espacioCalle = (largoCuadra*25)/100;
        for (int i = 0; i < ((this.largoCuadra) * cantidad[0]); i += this.largoCuadra) {
            for (int j = 0; j < ((this.largoCuadra) * cantidad[1]); j += this.largoCuadra) {
                canvas.getGraphicsContext2D().setFill(Color.GREEN);
                canvas.getGraphicsContext2D().fillRect(i + this.espacioCalle, j + this.espacioCalle, (this.largoCuadra - this.espacioCalle), (this.largoCuadra - this.espacioCalle));
            }
        }
        /*
        canvas.getGraphicsContext2D().setFill(Color.GRAY);
        canvas.getGraphicsContext2D().fillRect(0, 0, maxX, maxY);
        int[] cantidad = this.juego.obtenerTamanioMapa();
        cantidad[0] = cantidad[0] + 1;
        cantidad[1] = cantidad[1] + 1;
        this.largoCuadraX = maxX/cantidad[0];
        this.largoCuadraY = maxY/cantidad[1];
        this.espacioCalleX = ((this.largoCuadraX * 25) / 100);
        this.espacioCalleY = ((this.largoCuadraY * 25) / 100);
        for (int i = 0; i < ((this.largoCuadraX) * cantidad[0]); i += this.largoCuadraX) {
            for (int j = 0; j < ((this.largoCuadraY) * cantidad[1]); j += this.largoCuadraY) {
                canvas.getGraphicsContext2D().setFill(Color.GREEN);
                canvas.getGraphicsContext2D().fillRect(i + this.espacioCalleX, j + this.espacioCalleY, (this.largoCuadraX - this.espacioCalleX), (this.largoCuadraY - this.espacioCalleY));
            }
        }

         */

    }
    private void dibujarVisivilidadJugador(int maxX, int maxY) {
        canvas.getGraphicsContext2D().setFont(Font.font("Arial", FontWeight.BOLD, 32.0));
        canvas.getGraphicsContext2D().setFill(Color.BLACK);
        canvas.getGraphicsContext2D().fillText("Movimientos: " + juego.getMovimientos(),0, 30);
        //int[] coordenada = coordenadasVehiculo();
       // canvas.getGraphicsContext2D().strokeOval((coordenada[0]-this.largoCuadraX), (coordenada[1]-this.largoCuadraY), (this.largoCuadraX*4), (this.largoCuadraY*4));
        //canvas.getGraphicsContext2D().clearRect();
        //canvas.getGraphicsContext2D().setStroke(Color.BLACK);
        //canvas.getGraphicsContext2D().setLineWidth(800);


    }


    private void dibujarVehiculo(){
        int[] coordenada = coordenadasVehiculo();
        if(this.vehiculo.getClass() == Moto.class){
            canvas.getGraphicsContext2D().setFill(Color.RED);
        }
        if(this.vehiculo.getClass() == Auto.class){
            canvas.getGraphicsContext2D().setFill(Color.BLUE);
        }
        if(this.vehiculo.getClass() == CuatroXCuatro.class){
            canvas.getGraphicsContext2D().setFill(Color.BLACK);
        }
        canvas.getGraphicsContext2D().fillRect(coordenada[0], coordenada[1],10,10);


    }
    private void dibujarMeta(){
        int[] coordenada = coordenadasMeta();
        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        canvas.getGraphicsContext2D().fillRect(coordenada[0], coordenada[1],this.espacioCalle,this.espacioCalle);
    }
    private void dibujarInterferencias(){
        List<Interferencia> interferencias = juego.obtenerInterferencias();
        int[] coordenadaVehiculo = juego.obtenerCoordenada();
        for(int i = 0; i < interferencias.size(); i++){
            int[] coordenadaInterferencia = interferencias.get(i).obtenerCoordenadaInterferencia();
            int posXSiXInicialIgualXFinal = (coordenadaInterferencia[0] * largoCuadra)+ largoCuadra/2;
            int posYSiYInicialIgualYFinal = (coordenadaInterferencia[1] * largoCuadra)+ largoCuadra/2;

            if(interferencias.get(i).getClass() == ControlPolicial.class){
                canvas.getGraphicsContext2D().setFill(Color.CHOCOLATE);
            }
            if(interferencias.get(i).getClass() == Piquete.class){
                canvas.getGraphicsContext2D().setFill(Color.CHOCOLATE);
            }
            if(interferencias.get(i).getClass() == Pozo.class){
                canvas.getGraphicsContext2D().setFill(Color.CHOCOLATE);
            }
            if(interferencias.get(i).getClass() == SorpresaCambioVehiculo.class){
                canvas.getGraphicsContext2D().setFill(Color.CHOCOLATE);
            }
            if(interferencias.get(i).getClass() == SorpresaDesfavorable.class){
                canvas.getGraphicsContext2D().setFill(Color.CHOCOLATE);
            }
            if(interferencias.get(i).getClass() == SorpresaFavorable.class){
                canvas.getGraphicsContext2D().setFill(Color.CHOCOLATE);
            }
            System.out.println(interferencias.size());
            int x =(coordenadaVehiculo[0]-coordenadaInterferencia[0]);
            int y = (coordenadaVehiculo[1]-coordenadaInterferencia[1]);
            int distancia = (int) Math.sqrt(((x*x) + (y*y)));
            if((coordenadaInterferencia[0] == coordenadaInterferencia[2])){
                System.out.println("InterX:" +coordenadaInterferencia[0] + " VehiculoX:" +(coordenadaVehiculo[0]+2) +" InterY:"+coordenadaInterferencia[1]+ " VehiculoY:" +(coordenadaVehiculo[1]+2));
                //if(distancia < 2){
                    canvas.getGraphicsContext2D().fillRect(posXSiXInicialIgualXFinal, (coordenadaInterferencia[1] * largoCuadra),this.espacioCalle,this.espacioCalle);
               // }
            }
            if((coordenadaInterferencia[1] == coordenadaInterferencia[3])){
                System.out.println("InterX:" +coordenadaInterferencia[0] + " VehiculoX:" +(coordenadaVehiculo[0]+2) +" InterY:"+coordenadaInterferencia[1]+ " VehiculoY:" +(coordenadaVehiculo[1]+2));
                //if(distancia < 2){
                    canvas.getGraphicsContext2D().fillRect((coordenadaInterferencia[0] * largoCuadra), posYSiYInicialIgualYFinal,this.espacioCalle,this.espacioCalle);
               // }

            }

        }

    }

    private void dibujarMascara() {
        canvas.getGraphicsContext2D().setStroke(Color.BLACK);

        int radio = 1500;

        canvas.getGraphicsContext2D().setLineWidth(radio - 2*(this.largoCuadra + this.espacioCalle));

        int[] coordenada = coordenadasVehiculo();
        int shift = (radio - 10) / 2;
        canvas.getGraphicsContext2D().strokeOval(coordenada[0] - shift, coordenada[1] - shift, radio, radio);
    }




    private void clean(){
        canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
        canvas.getGraphicsContext2D().fillRect(0,0,468,220);
    }
    public  void update(){
        this.dibujar(800, 800);
    }
}