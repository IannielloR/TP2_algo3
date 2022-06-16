package edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;

public abstract class Interferencia {
    protected int posX;
    protected int posY;

    public abstract int analizarVehiculo(TipoVehiculo vehiculo, int id1, int id2, int movimientos);
}
