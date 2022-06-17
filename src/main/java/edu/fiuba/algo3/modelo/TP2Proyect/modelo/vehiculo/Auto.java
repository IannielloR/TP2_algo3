package edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo;

import java.util.Random;

public class Auto extends TipoVehiculo {

    public Auto(){ }
    public TipoVehiculo devolverSorpresaCambioDeVehiculo(){
        return new CuatroXCuatro();
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

