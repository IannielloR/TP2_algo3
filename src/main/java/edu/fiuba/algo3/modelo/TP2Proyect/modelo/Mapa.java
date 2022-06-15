package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import java.util.ArrayList;

public class Mapa {
    private int maximoX;
    private int maximoY;
    private Vehiculo vehiculo;
    private int posVehiculoX;
    private int posVehiculoY;
    private int posVehiculoXAnterior;
    private int posVehiculoYAnterior;
    ArrayList<Interferencia> interferencias;

    public Mapa(Vehiculo vehiculo){
        this.maximoX = 5;
        this.maximoY = 5;
        this.vehiculo = vehiculo;
        this.posVehiculoX = 1;
        this.posVehiculoY = 1;
        this.posVehiculoXAnterior = 0;
        this.posVehiculoYAnterior = 0;
    }
    public int moverVehiculoAbajo(){
        if(posVehiculoY + 1 <= maximoY) {
            posVehiculoYAnterior = posVehiculoY;
            posVehiculoY++;
            return revisarObstaculos();
        }
        return 0;
    }
    public int moverVehiculoArriba(){
        if(posVehiculoY - 1 == 0) {
            posVehiculoYAnterior = posVehiculoY;
            posVehiculoY--;
            return revisarObstaculos();
        }
        return 0;
    }
    public int moverVehiculoDerecha(){
        if(posVehiculoX + 1 <= maximoX) {
            posVehiculoXAnterior = posVehiculoX;
            posVehiculoX++;
            return revisarObstaculos();
        }
        return 0;
    }
    public int moverVehiculoIzquierda(){
        if(posVehiculoX - 1 == 0) {
            posVehiculoXAnterior = posVehiculoX;
            posVehiculoX--;
            return revisarObstaculos();
        }
        return 0;
    }
    private int revisarObstaculos(){
        int movimientos = 1;
        for(int i = 0; i <= interferencias.size(); i++){
            movimientos += interferencias.get(i).analizarVehiculo(vehiculo, posVehiculoXAnterior, posVehiculoYAnterior, posVehiculoX, posVehiculoY, movimientos);
        }
        return movimientos;
    }
}
