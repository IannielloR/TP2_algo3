package edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo;

import java.util.Random;

public abstract class Vehiculo {
    public int devolverSorpresaFavorable(int movimientos){
        return (movimientos - ((movimientos * 20)/100));
    }
    public int devolverSorpresaDesfavorable(int movimientos){
        return (movimientos + ((movimientos * 25)/100));
    }
    public abstract String devolverSorpresaCambioDeVehiculo();
    public abstract int devolverPenalizacionControlPolical();
    public abstract int devolverPenalizacionPozo();
    public abstract int devolverPenalizacionPiquete();
}
