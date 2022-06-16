package edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;

public class ControlPolicial extends Interferencia {

    public ControlPolicial(int id1, int id2) {
        this.posX = id1;
        this.posY = id2;
    }
    public int analizarVehiculo(TipoVehiculo vehiculo, int id1, int id2, int movimientos){
        if(this.posX == id1 && this.posY == id2 ){
            return (vehiculo.devolverVehiculo()).devolverPenalizacionControlPolical();
        }
        return 0;
    }
}
