package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import java.util.ArrayList;

public class Mapa {
    private int maximoX;
    private int maximoY;
    private Vehiculo vehiculo;
    private int posVehiculoX;
    private int posVehiculoY;
    //private Pozo obstaculo1;
    //private Pozo obstaculo2;
   // private Pozo obstaculo3;

    private Piquete obstaculo4;

    private ArrayList<Obstaculo> interferencias;
    private ArrayList<SorpesaCambioVehiculo> cambiosDeVehiculos;

    public Mapa(Vehiculo vehiculo){
        this.maximoX = 5;
        this.maximoY = 5;
        this.vehiculo = vehiculo;
        this.posVehiculoX = 1;
        this.posVehiculoY = 1;
        this.interferencias = new ArrayList<Obstaculo>();
        this.cambiosDeVehiculos = new ArrayList<SorpesaCambioVehiculo>();
    }
    public int moverVehiculoAbajo(){
        if(posVehiculoY + 1 <= maximoY) {
            posVehiculoY++;

            return revisarObstaculos();
        }
        return 0;
    }
    public int moverVehiculoArriba(){
        if(posVehiculoY - 1 == 0) {
            posVehiculoY--;

            return revisarObstaculos();
        }
        return 0;
    }
    public int moverVehiculoDerecha(){
        if(posVehiculoX + 1 <= maximoX) {
            posVehiculoX++;

            return revisarObstaculos();
        }
        return 0;
    }
    public int moverVehiculoIzquierda(){
        if(posVehiculoX - 1 == 0) {
            posVehiculoX--;

            return revisarObstaculos();
        }
        return 0;
    }
    private int revisarObstaculos(){
        int movimientos = 1;
        for(int i = 0; i < interferencias.size(); i++){
            movimientos += interferencias.get(i).analizarVehiculo(vehiculo,posVehiculoX, posVehiculoY, movimientos);
        }
        for(int i = 0; i < cambiosDeVehiculos.size(); i++){
            this.vehiculo= cambiosDeVehiculos.get(i).analizarVehiculo(vehiculo,posVehiculoX, posVehiculoY);
        }
        return movimientos;
    }
}
