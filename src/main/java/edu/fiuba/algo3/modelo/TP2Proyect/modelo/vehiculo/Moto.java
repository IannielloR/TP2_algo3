package edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo;

import java.util.Random;

public class Moto extends Vehiculo {
    public Moto(){
    }
    public String devolverSorpresaCambioDeVehiculo() {
        return "moto";
    }
    public int devolverPenalizacionControlPolical(){
        Random random = new Random();
        if(random.nextFloat() < 0.8){
            return 3;
        }
        return 0;
    }
    public int devolverPenalizacionPozo(){
        return 3;

    }
    public int devolverPenalizacionPiquete(){
        return 2;
    }
}
