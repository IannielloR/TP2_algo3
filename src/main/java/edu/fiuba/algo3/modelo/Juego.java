package edu.fiuba.algo3.modelo;

public class Juego {
    private Mapa mapa;
    int movimientos;
    //private Jugador jugador;

    public Juego(String vehiculo){
        this.mapa = new Mapa();
        this.movimientos = 0;
        //this.jugador = new Jugador();
    }

    public void moverVechiculo(String direccion){
        movimientos += mapa.moverVehiculo(direccion);
    }

    public int getMovimientos(){
        return movimientos;
    }
}
