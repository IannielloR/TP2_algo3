package edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Coordenada;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;

public abstract class Interferencia {
    protected Coordenada coordenada = new Coordenada();

    public abstract boolean analizarVehiculo(Vehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal);
}
