package edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo;

public class Vehiculo {

    private TipoVehiculo tipoVehiculo;
    private int movimientos;
    public Vehiculo(TipoVehiculo vehiculo){
        this.tipoVehiculo = vehiculo;
        this.movimientos = 0;
    }

    public TipoVehiculo devolverVehiculo(){
        return this.tipoVehiculo;
    }
    public void cambiarEstado(){
        this.tipoVehiculo = this.tipoVehiculo.devolverSorpresaCambioDeVehiculo();
    }

    public int devolverMovimientos(){
        return this.movimientos;
    }

    public void devolverSorpresaFavorable(){
        this.movimientos += (this.tipoVehiculo.devolverSorpresaFavorable(movimientos) + 1);
    }
    public void devolverSorpresaDesfavorable(){
        this.movimientos +=  (this.tipoVehiculo.devolverSorpresaDesfavorable(movimientos) + 1);
    }
    public void devolverPenalizacionControlPolical(float prob){
        this.movimientos +=  (this.tipoVehiculo.devolverPenalizacionControlPolical(prob) + 1);
    };
    public void devolverPenalizacionPozo(){
        this.movimientos += (this.tipoVehiculo.devolverPenalizacionPozo() + 1);
    };
    public void devolverPenalizacionPiquete(){
        this.movimientos += this.tipoVehiculo.devolverPenalizacionPiquete();
    };

}