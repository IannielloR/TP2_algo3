package edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo;

import java.util.Random;

public class CuatroXCuatro extends TipoVehiculo {
    private int pozos;

    public CuatroXCuatro(){
        this.pozos = 0;
    }

    public TipoVehiculo devolverSorpresaCambioDeVehiculo() {
        return new Moto();
    }
    public int devolverPenalizacionControlPolical(float prob){
        if(prob < 0.3){
            return 3;
        }
        return 0;
    }
    public int devolverPenalizacionPozo(){
        this.pozos++;
        if(this.pozos == 3){
            this.pozos = 0;
            return 2;
        }
        else{
            return 0;
        }
    }
    public int devolverPenalizacionPiquete(){
        return -1;
    }
}
