package edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.mapa.Vehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.mapa.Interferencia;

public class ControlPolicial extends Interferencia {
    private float randomProb;

    public ControlPolicial(int xInicial, int yInicial, int xFinal, int yFinal, float probabilidad) {
        this.randomProb = probabilidad;
        this.coordenada.asignarCoordenadas(xInicial,  yInicial, xFinal, yFinal);
    }

    public boolean analizarVehiculo(Vehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal){
        if(coordenada.hayColision(xInicial, yInicial, xFinal, yFinal)){
            vehiculo.devolverPenalizacionControlPolical(this.randomProb);
        }
        return true;
    }
}
