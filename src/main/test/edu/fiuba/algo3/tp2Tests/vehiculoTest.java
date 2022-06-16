/*package edu.fiuba.algo3.tp2Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehiculoTest {
    @Test
    public void motoSeDesplazaYSeEncuentraUnPozo(){
        // Arrange
        Juego gpsChallenge = new Juego("moto");
        int movimientosEsperados = 6;

        // Act
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoArriba();
        gpsChallenge.moverVehiculoIzquierda();

        // Assert
        assertEquals(movimientosEsperados, gpsChallenge.getMovimientos());
    }

    @Test
    public void cuatroXCuatroSeCruzaConUnControlPolicial(){
        // Arrange
        Juego gpsChallenge = new Juego("4x4");
        int movimientosEsperadosA = 6;
        int movimientosEsperadosB = 3;

        // Act
        gpsChallenge.moverVehiculoArriba();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoAbajo();

        // Assert
        assertEquals(movimientosEsperadosA, gpsChallenge.getMovimientos());
        assertEquals(movimientosEsperadosB, gpsChallenge.getMovimientos());
    }
}
*/