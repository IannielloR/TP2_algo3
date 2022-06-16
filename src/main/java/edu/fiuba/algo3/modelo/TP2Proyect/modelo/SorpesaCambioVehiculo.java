package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Moto;

public class SorpesaCambioVehiculo extends Interferencia{

    public SorpesaCambioVehiculo(int id1, int id2) {
        this.posXInicial = id1;
        this.posYInicial = id2;
        this.posXFinal = (id1+1);
        this.posYFinal = (id2+1);
    }
    public int analizarVehiculo(Vehiculo vehiculo, int xInicial, int yInicial, int xFianl, int yFinal, int movimientos){
        Vehiculo nuevoVehiculo = vehiculo;
        if((this.posXInicial == xInicial) && (this.posXFinal == xFianl) && (this.posYInicial == yInicial) && (this.posYFinal == yFinal) ){
            String tipoVehiculo = vehiculo.devolverSorpresaCambioDeVehiculo();
            if(tipoVehiculo == "moto"){
                nuevoVehiculo = new Auto();

            }else if(tipoVehiculo == "auto"){
                nuevoVehiculo = new CuatroXCuatro();

            }else if(tipoVehiculo == "4x4"){
                nuevoVehiculo = new Moto();

            }
        }
        return movimientos;
    }
}
