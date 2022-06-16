package edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Coordenada;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;

public abstract class Interferencia {
    protected Coordenada cordenada;

    public abstract int analizarVehiculo(TipoVehiculo vehiculo, int xInicial, int yInicial, int xFinal, int yFinal, int movimientos);
}
