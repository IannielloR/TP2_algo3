package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.CuatroXCuatro;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Moto;

public class SorpesaCambioVehiculo extends Interferencia{

    public SorpesaCambioVehiculo(int xMax, int yMax) {
        this.cordenada.generarCoordenadas(xMax, yMax);
    }
    public int analizarVehiculo(Vehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal, int movimientos){
        Vehiculo nuevoVehiculo = vehiculo;
        if(cordenada.hayColision(xInicial, yInicial, xFinal, yFinal)){
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
