package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;
import java.util.Random;
public class Juego {
    private int movimientos;
    private Mapa mapa;

    public Juego(Vehiculo vehiculo){
        this.mapa = new Mapa(vehiculo);
        this.movimientos = 0;
    }

    public void moverVehiculoArriba(){
        movimientos += mapa.moverVehiculoArriba(this.movimientos);
    }

    public void moverVehiculoAbajo(){
        movimientos += mapa.moverVehiculoAbajo(this.movimientos);
    }

    public void moverVehiculoIzquierda(){
        movimientos += mapa.moverVehiculoIzquierda(this.movimientos);
    }

    public void moverVehiculoDerecha(){
        movimientos += mapa.moverVehiculoDerecha(this.movimientos);
    }
    public int getMovimientos(){
        return this.movimientos;
    }

/*    public void prueba(){
        Random rand = new Random(); //instance of random class
        int upperbound = 25;
        //generate random values from 0-24
        int int_random = rand.nextInt(upperbound);
    }
*/
}
