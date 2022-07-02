package edu.fiuba.algo3.modelo.TP2Proyect.modelo.mapa;

public abstract class Interferencia {
    protected Coordenada coordenada = new Coordenada();

    public abstract boolean analizarVehiculo(Vehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal);
    public int[] obtenerCoordenadaInterferencia(){
        return this.coordenada.obtenerCordenadaInterferencia();
    }
}