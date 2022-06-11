package TP2Proyect;

public class Juego {
    private Mapa mapa;
    int movimientos;

    public Juego(String vehiculo){
        this.mapa = new Mapa();
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
