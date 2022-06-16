package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;
public abstract class Interferencia {
    protected Coordenada cordenada;

    public abstract int analizarVehiculo(Vehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal, int movimientos);
}
