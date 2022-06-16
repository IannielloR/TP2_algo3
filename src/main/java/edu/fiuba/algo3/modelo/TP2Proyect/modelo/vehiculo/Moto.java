package edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo;

public class Moto extends Vehiculo {
    public Moto(){
    }
    public String devolverSorpresaCambioDeVehiculo() {
        return "moto";
    }
    public int devolverPenalizacionControlPolical(){
        return 0;
    }
    public int devolverPenalizacionPozo(){
        return 3;

    }
    public int devolverPenalizacionPiquete(){
        return 2;
    }
}
