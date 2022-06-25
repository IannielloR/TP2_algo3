package edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo;

public class Vehiculo {

    private TipoVehiculo tipoVehiculo;
    private int movimientos;
    //private static final int costoDeMovimiento = 1;
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
    public void sumarMovimiento(){
        this.movimientos += 1;
    }
    public void devolverSorpresaFavorable(){
        this.movimientos += (this.tipoVehiculo.devolverSorpresaFavorable(movimientos));
    }
    public void devolverSorpresaDesfavorable(){
        this.movimientos +=  (this.tipoVehiculo.devolverSorpresaDesfavorable(movimientos));
    }
    public void devolverPenalizacionControlPolical(float prob){
        this.movimientos +=  (this.tipoVehiculo.devolverPenalizacionControlPolical(prob));
    };
    public void devolverPenalizacionPozo(){
        this.movimientos += (this.tipoVehiculo.devolverPenalizacionPozo());
    };
    public boolean devolverPenalizacionPiquete(){
        int costo = this.tipoVehiculo.devolverPenalizacionPiquete();
        this.movimientos += costo;
        return costo != -1;
    };

}