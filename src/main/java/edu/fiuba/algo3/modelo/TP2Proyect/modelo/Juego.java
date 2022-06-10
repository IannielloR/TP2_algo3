package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

public class Juego {
    private int movimientos;
    private Mapa mapa;

    public Juego(Vehiculo vehiculo){
        this.mapa = new Mapa(vehiculo);
        this.movimientos = 0;
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
        return this.movimientos;
    }

}
