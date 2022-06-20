package edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;

public class SorpesaCambioVehiculo extends Interferencia {
    public SorpesaCambioVehiculo(int xInicial, int yInicial, int xFinal, int yFinal) {
        this.cordenada.asignarCoordenadas(xInicial,  yInicial, xFinal, yFinal);
    }
    public int analizarVehiculo(TipoVehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal, int movimientos){
        if(cordenada.hayColision(xInicial, yInicial, xFinal, yFinal)){
            vehiculo.cambiarEstado();
            return 1;
        }
        return 0;
    }
}
