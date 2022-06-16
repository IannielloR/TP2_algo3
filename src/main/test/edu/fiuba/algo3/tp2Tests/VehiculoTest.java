package edu.fiuba.algo3.tp2Tests;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.CuatroXCuatro;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Moto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehiculoTest {
    @Test
    public void motoSeDesplazaYSeEncuentraUnPozo(){
        // Arrange
        Juego = gpsChalleng
        int movimientosEsperados = 6;   //3 desplazamiento + 3 pozo

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
        Juego gpsChallenge = new Juego(new CuatroXCuatro());
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
