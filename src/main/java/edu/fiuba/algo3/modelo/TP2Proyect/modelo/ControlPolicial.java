package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;

public class ControlPolicial extends Interferencia {

    public ControlPolicial(int xMax, int yMax) {
        this.cordenada.generarCoordenadas(xMax, yMax);
    }
    public int analizarVehiculo(TipoVehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal, int movimientos){
        if(cordenada.hayColision(xInicial, yInicial, xFinal, yFinal)){
            return (vehiculo.devolverVehiculo()).devolverPenalizacionControlPolical();
        }
        return 0;
    }
}
