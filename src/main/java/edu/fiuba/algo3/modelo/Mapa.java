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

    ArrayList<Obstaculo> interferencias;
    ArrayList<SorpesaCambioVehiculo> cambiosDeVehiculos;

    public Mapa(Vehiculo vehiculo){
        this.maximoX = 5;
        this.maximoY = 5;

        private int revisarObstaculos(){
            int movimientos = 1;
            for(int i = 0; i <= interferencias.size(); i++){
                movimientos += interferencias.get(i).analizarVehiculo(vehiculo,posVehiculoX, posVehiculoY, movimientos);
            }
            for(int i = 0; i <= cambiosDeVehiculos.size(); i++){
                this.vehiculo= cambiosDeVehiculos.get(i).analizarVehiculo(vehiculo,posVehiculoX, posVehiculoY);
            }
            return movimientos;
        }
    }