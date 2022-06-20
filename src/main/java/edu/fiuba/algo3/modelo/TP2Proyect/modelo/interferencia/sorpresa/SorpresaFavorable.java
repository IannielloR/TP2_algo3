package edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;

public class SorpresaFavorable extends Interferencia {
    public SorpresaFavorable(int xInicial, int yInicial, int xFinal, int yFinal) {
        this.coordenada.asignarCoordenadas(xInicial,  yInicial, xFinal, yFinal);
    }
    public int analizarVehiculo(TipoVehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal, int movimientos){
        if(coordenada.hayColision(xInicial, yInicial, xFinal, yFinal)){
            return (vehiculo.devolverVehiculo()).devolverSorpresaFavorable(movimientos);
        }
        return 0;
    }
}
