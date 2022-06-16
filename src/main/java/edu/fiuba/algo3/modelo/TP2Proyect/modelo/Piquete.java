package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;
public class Piquete extends Interferencia {
    public Piquete(int xMax, int yMax) {
        this.cordenada.generarCoordenadas(xMax, yMax);
    }
    public int analizarVehiculo(Vehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal, int movimientos){
        if(cordenada.hayColision(xInicial, yInicial, xFinal, yFinal)){
            return vehiculo.devolverPenalizacionPiquete();
        }
        return 0;
    }
}
