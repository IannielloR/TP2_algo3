package edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo;

public abstract class TipoVehiculo {
    public int devolverSorpresaFavorable(int movimientos){
        return ( - ((movimientos * 20)/100));
    }
    public int devolverSorpresaDesfavorable(int movimientos){
        return ((movimientos * 25)/100);
    }
    public abstract TipoVehiculo devolverSorpresaCambioDeVehiculo();
    public abstract int devolverPenalizacionControlPolical(float prob);
    public abstract int devolverPenalizacionPozo();
    public abstract int devolverPenalizacionPiquete();
}