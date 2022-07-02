package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.GPSChallenge.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.mapa.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Moto;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.List;

public class VistaJuego{
    private Juego juego;
    private int largoCuadra;
    private int espacioCalle;
    Canvas canvas;

    public VistaJuego(Juego juego, Canvas canvas){
        this.juego = juego;
        this.canvas = canvas;
    }

    public void dibujar(int maxX, int maxY){
        this.dibujarMapa(maxX,maxY);
        this.dibujarInterferencias();
        this.dibujarMascara();
        this.dibujarMeta();
        this.dibujarPuntaje();
        this.dibujarVehiculo();
    }

    private int[] coordenadasVehiculo(){
        int [] coordenada = juego.obtenerCoordenadaVehiculo();
        coordenada[0] = ((coordenada[0] *this.largoCuadra) + (espacioCalle/4));
        coordenada[1] = ((coordenada[1] *this.largoCuadra) + (espacioCalle/4))+35;
        return coordenada;
    }

    private int[] coordenadasMeta(){
        int [] coordenada = juego.obtenerCoordenadaMeta();
        coordenada[0] = (coordenada[0] *this.largoCuadra);
        coordenada[1] = (coordenada[1] *this.largoCuadra)+35;
        return coordenada;
    }

    private void dibujarMapa(int maxX, int maxY) {
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
        canvas.getGraphicsContext2D().fillRect(0, 0, maxX, maxY+35);
        if(cantidad[0]> cantidad[1]){
            largoCuadra = maxX/cantidad[0];
        }else {
            largoCuadra = maxY/cantidad[1];
        }
        this.espacioCalle = (largoCuadra*25)/100;
        for (int i = 0; i < ((this.largoCuadra) * cantidad[0]); i += this.largoCuadra) {
            for (int j = 35; j < ((this.largoCuadra) * cantidad[1]); j += this.largoCuadra) {
                canvas.getGraphicsContext2D().setFill(Color.GREEN);
                canvas.getGraphicsContext2D().fillRect(i + this.espacioCalle, j + this.espacioCalle, (this.largoCuadra - this.espacioCalle), (this.largoCuadra - this.espacioCalle));
            }
        }
    }

    private void dibujarPuntaje() {
        int[] cantidad = this.juego.obtenerTamanioMapa();
        cantidad[0] = cantidad[0] + 1;
        double tamanio = 30;
        if(cantidad[0]>2){
            tamanio = 30;
        }else {
            tamanio = espacioCalle/2;
        }
        canvas.getGraphicsContext2D().setFont(Font.font("Arial", FontWeight.BOLD, tamanio));
        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        canvas.getGraphicsContext2D().fillText("Movimientos: " + juego.getMovimientos(),0, 30);
    }

    private void dibujarVehiculo(){
        int[] coordenada = coordenadasVehiculo();
        if(this.juego.obtenerVehiculo().devolverVehiculo().getClass() == Moto.class){
            canvas.getGraphicsContext2D().setFill(Color.DARKVIOLET);
        }
        if(this.juego.obtenerVehiculo().devolverVehiculo().getClass() == Auto.class){
            canvas.getGraphicsContext2D().setFill(Color.PINK);
        }
        if(this.juego.obtenerVehiculo().devolverVehiculo().getClass() == CuatroXCuatro.class){
            canvas.getGraphicsContext2D().setFill(Color.BLACK);
        }
        canvas.getGraphicsContext2D().fillRect(coordenada[0], coordenada[1],(espacioCalle/2),(espacioCalle/2));
    }

    private void dibujarMeta(){
        int[] coordenada = coordenadasMeta();
        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        canvas.getGraphicsContext2D().fillRect(coordenada[0], (coordenada[1]),this.espacioCalle,this.espacioCalle);
    }

    private void dibujarInterferencias(){
        List<Interferencia> interferencias = juego.obtenerInterferencias();
        for(int i = 0; i < interferencias.size(); i++){
            int[] coordenadaInterferencia = interferencias.get(i).obtenerCoordenadaInterferencia();
            int posYSiXInicialIgualXFinal = (coordenadaInterferencia[1] * largoCuadra)+ largoCuadra/2;
            int posXSiYInicialIgualYFinal = (coordenadaInterferencia[0] * largoCuadra)+ largoCuadra/2;
            String letra = "";
            int tamanio = 0;
            if(interferencias.get(i).getClass() == ControlPolicial.class){
                canvas.getGraphicsContext2D().setFill(Color.BLUE);
                letra = "★";
                tamanio = espacioCalle;
            }
            if(interferencias.get(i).getClass() == Piquete.class){
                canvas.getGraphicsContext2D().setFill(Color.RED);
                letra = "—/—";
                tamanio = espacioCalle/2;
            }
            if(interferencias.get(i).getClass() == Pozo.class){
                canvas.getGraphicsContext2D().setFill(Color.CHOCOLATE);
                letra = "◉";
                tamanio = espacioCalle*2;
            }
            if(interferencias.get(i).getClass() == SorpresaCambioVehiculo.class){
                canvas.getGraphicsContext2D().setFill(Color.YELLOW);
                letra = "O▀O";
                tamanio = espacioCalle/2;
            }
            if(interferencias.get(i).getClass() == SorpresaDesfavorable.class){
                canvas.getGraphicsContext2D().setFill(Color.ORANGE);
                letra = "(¬_¬)";
                tamanio = espacioCalle/2;
            }
            if(interferencias.get(i).getClass() == SorpresaFavorable.class){
                canvas.getGraphicsContext2D().setFill(Color.GREEN);
                letra = "(★ ω ★)";
                tamanio = espacioCalle/2;
            }
            if((coordenadaInterferencia[0] == coordenadaInterferencia[2])){
                canvas.getGraphicsContext2D().fillRect((coordenadaInterferencia[0] * largoCuadra), (posYSiXInicialIgualXFinal+35),this.espacioCalle,this.espacioCalle);
                canvas.getGraphicsContext2D().setFont(Font.font("Arial", FontWeight.BOLD, tamanio));
                canvas.getGraphicsContext2D().setFill(Color.BLACK);
                canvas.getGraphicsContext2D().fillText(letra,(coordenadaInterferencia[0] * largoCuadra), (posYSiXInicialIgualXFinal+35+(espacioCalle/2)));
            }
            if((coordenadaInterferencia[1] == coordenadaInterferencia[3])){
                canvas.getGraphicsContext2D().fillRect(posXSiYInicialIgualYFinal, ((coordenadaInterferencia[1] * largoCuadra)+35),this.espacioCalle,this.espacioCalle);
                canvas.getGraphicsContext2D().setFont(Font.font("Arial", FontWeight.BOLD, tamanio));
                canvas.getGraphicsContext2D().setFill(Color.BLACK);
                canvas.getGraphicsContext2D().fillText(letra,posXSiYInicialIgualYFinal, ((coordenadaInterferencia[1] * largoCuadra)+35+(espacioCalle/2)));
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

    public  void update(){
        this.dibujar(1024, 768);
    }
}
