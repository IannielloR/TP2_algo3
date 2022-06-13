package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import java.util.Random;

public class Auto extends Vehiculo{

    public Auto(){ }
    public String devolverSorpresaCambioDeVehiculo(){
        return "auto";
    }
    public  int devolverPenalizacionControlPolical(){
        Random random = new Random();
        if(random.nextFloat() < 0.5){
            return 3;
        }
        return 0;
    }

    public int devolverPenalizacionPozo(){
        return 3;
    }
    public int devolverPenalizacionPiquete(){
        return -1;
    }


}

