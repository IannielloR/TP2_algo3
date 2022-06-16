package edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;

public class SorpesaCambioVehiculo extends Interferencia {
    private int posX;
    private int posY;

    public SorpesaCambioVehiculo(int id1, int id2) {
        this.posX = id1;
        this.posY = id2;
    }
    public int analizarVehiculo(TipoVehiculo vehiculo, int id1, int id2, int movimientos){

        if(this.posX == id1 && this.posY == id2 ){
            vehiculo.cambiarEstado();
            return 1;
        }
        return 0;
    }
}
