package edu.fiuba.algo3.TP2ProyectTests.tests;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.*;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehiculoTest {
    @Test
    public void motoSeDesplazaYSeEncuentraUnPozo(){
        // Arrange
        Juego gpsChallenge = new Juego(new Moto());
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
        CuatroXCuatro vehiculo = new CuatroXCuatro();
        Juego gpsChallenge = new Juego(vehiculo);
        int movimientosEsperados = 6;

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