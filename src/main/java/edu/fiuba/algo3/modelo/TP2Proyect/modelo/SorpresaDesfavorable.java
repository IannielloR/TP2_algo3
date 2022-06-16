package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;

public class SorpresaDesfavorable extends Interferencia {
    public SorpresaDesfavorable(int maxX, int maxY) {
        this.cordenada.generarCoordenadas(maxX, maxY);
    }
    public int analizarVehiculo(Vehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal, int movimientos){
        if(cordenada.hayColision(xInicial, yInicial, xFinal, yFinal)){
            return vehiculo.devolverSorpresaDesfavorable(movimientos);
        }
        return 0;
    }
}
