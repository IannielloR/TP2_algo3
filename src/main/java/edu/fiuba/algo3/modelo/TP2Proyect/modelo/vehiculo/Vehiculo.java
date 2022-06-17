package edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo;

public class Vehiculo {

    private TipoVehiculo tipoVehiculo;

    public Vehiculo(TipoVehiculo vehiculo){
        this.tipoVehiculo = vehiculo;
    }

    public TipoVehiculo devolverVehiculo(){
        return this.tipoVehiculo;
    }
    public void cambiarEstado(){
        this.tipoVehiculo = this.tipoVehiculo.devolverSorpresaCambioDeVehiculo();
    }

}
