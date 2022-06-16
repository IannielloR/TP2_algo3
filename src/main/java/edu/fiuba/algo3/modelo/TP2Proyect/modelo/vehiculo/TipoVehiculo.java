package edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;

public class TipoVehiculo {

    private Vehiculo tipoVehiculo;

    public TipoVehiculo(Vehiculo vehiculo){
        this.tipoVehiculo = vehiculo;
    }

    public Vehiculo devolverVehiculo(){
        return this.tipoVehiculo;
    }
    public void cambiarEstado(){
        String tipo = this.tipoVehiculo.devolverSorpresaCambioDeVehiculo();
        if(tipo == "moto"){
            this.tipoVehiculo = new Auto();

        }else if(tipo == "auto"){
            this.tipoVehiculo = new CuatroXCuatro();

        }else if(tipo == "4x4"){
            this.tipoVehiculo = new Moto();}
    }

}
