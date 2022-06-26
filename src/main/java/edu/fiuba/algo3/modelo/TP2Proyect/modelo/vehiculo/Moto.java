package edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo;

public class Moto extends TipoVehiculo {
    public Moto(){
    }
    public TipoVehiculo devolverSorpresaCambioDeVehiculo() {
        return new Auto();
    }
    public int devolverPenalizacionControlPolical(float prob){
        if(prob < 0.8){
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
