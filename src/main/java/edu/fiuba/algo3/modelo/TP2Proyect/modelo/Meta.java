package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;

public class Meta {
    private int posX;
    private int posY;

    Meta(int x, int y) {
        this.posX = x;
        this.posY = y;
    }
    public boolean verificarMeta( int xVehiculo, int yVehiculo){
        if((this.posX == xVehiculo) && (this.posY == yVehiculo)){
            return true;
        }
        return false;
    }

}

