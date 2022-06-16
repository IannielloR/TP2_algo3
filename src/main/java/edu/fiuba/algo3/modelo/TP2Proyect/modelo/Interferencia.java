package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;
public abstract class Interferencia {
    protected int posXInicial;
    protected int posYInicial;
    protected int posXFinal;
    protected int posYFinal;

    public abstract int analizarVehiculo(Vehiculo vehiculo, int xInicial, int yInicial, int xFianal, int yFinal, int movimientos);
}
