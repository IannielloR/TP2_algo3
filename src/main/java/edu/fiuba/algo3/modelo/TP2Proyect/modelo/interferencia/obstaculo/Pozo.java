package edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;

public class Pozo extends Interferencia {
    public Pozo(int xMax, int yMax) {
        this.cordenada.generarCoordenadas(xMax, yMax);
    }
    public int analizarVehiculo(Vehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal, int movimientos){
        if(cordenada.hayColision(xInicial, yInicial, xFinal, yFinal)){
            return (vehiculo.devolverVehiculo()).devolverPenalizacionPozo();
        }
        return 0;
    }
}
