package edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;

public class ControlPolicial extends Interferencia {

    public ControlPolicial(int xInicial, int yInicial, int xFinal, int yFinal) {
        this.cordenada.asignarCoordenadas(xInicial,  yInicial, xFinal, yFinal);
    }
    public int analizarVehiculo(TipoVehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal, int movimientos){
        if(cordenada.hayColision(xInicial, yInicial, xFinal, yFinal)){
            return (vehiculo.devolverVehiculo()).devolverPenalizacionControlPolical();
        }
        return 0;
    }
}
