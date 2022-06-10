package edu.fiuba.algo3.TP2ProyectTests.tests;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Auto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1{
    @Test
    public void test(){
        // Arrange
        Auto vehiculo = new Auto();
        Juego gpsChallenge = new Juego(vehiculo);
        int movimientosEsperados = 13;

        // Act
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoAbajo();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoAbajo();

        // Assert
        assertEquals(movimientosEsperados, gpsChallenge.getMovimientos());
    }


}