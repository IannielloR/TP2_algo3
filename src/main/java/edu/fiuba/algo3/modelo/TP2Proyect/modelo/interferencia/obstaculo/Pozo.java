package edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.mapa.Vehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.mapa.Interferencia;

public class Pozo extends Interferencia {
    public Pozo(int xInicial, int yInicial, int xFinal, int yFinal) {
        this.coordenada.asignarCoordenadas(xInicial,  yInicial, xFinal, yFinal);
    }

    public boolean analizarVehiculo(Vehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal){
        if(coordenada.hayColision(xInicial, yInicial, xFinal, yFinal)){
            vehiculo.devolverPenalizacionPozo();
        }
        return true;
    }
}
