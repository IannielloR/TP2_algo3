package edu.fiuba.algo3.modelo;

import java.lang.String;
public class Juego {
    private Mapa mapa;
    int movimientos;
    //private Jugador jugador;

    public Juego(String vehiculo){
        this.mapa = new Mapa(vehiculo);
        this.movimientos = 0;
        //this.jugador = new Jugador();
    }

    public void moverVehiculoArriba(){
        movimientos += mapa.moverVehiculoArriba();
    }

    public void moverVehiculoAbajo(){
        movimientos += mapa.moverVehiculoAbajo();
    }

    public void moverVehiculoIzquierda(){
        movimientos += mapa.moverVehiculoIzquierda();
    }

    public void moverVehiculoDerecha(){
        movimientos += mapa.moverVehiculoDerecha();
    }
    public int getMovimientos(){
        return movimientos;
    }
}
