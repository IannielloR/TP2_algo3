package edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo;


import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;

import java.util.Random;

public class ControlPolicial extends Interferencia {

    public ControlPolicial(int xInicial, int yInicial, int xFinal, int yFinal) {
        this.coordenada.asignarCoordenadas(xInicial,  yInicial, xFinal, yFinal);
    }
    public int analizarVehiculo(TipoVehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal, int movimientos){
        if(coordenada.hayColision(xInicial, yInicial, xFinal, yFinal)){
            Random random = new Random();
            float prob = random.nextFloat();
            return (vehiculo.devolverVehiculo()).devolverPenalizacionControlPolical(prob);
        }
        return 0;
    }
}
