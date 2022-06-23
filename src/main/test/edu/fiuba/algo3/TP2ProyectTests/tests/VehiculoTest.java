package edu.fiuba.algo3.TP2ProyectTests.tests;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.*;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehiculoTest {
    @Test
    public void motoSeDesplazaYSeEncuentraUnPozo(){
        // Arrange
        Moto vehiculo = new Moto();
        Juego gpsChallenge = new Juego(vehiculo);
        int movimientosEsperados = 16;   //3 desplazamiento + 3 pozo

        // Act
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoAbajo();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoAbajo();

        // Assert
        assertEquals(movimientosEsperados, gpsChallenge.getMovimientos());
    }

    @Test
    public void cuatroXCuatroRecorreElMapaYSeEncuentraConObstaculos(){
        // Arrange
        CuatroXCuatro vehiculo = new CuatroXCuatro();
        Juego gpsChallenge = new Juego(vehiculo);
        int movimientosEsperados = 15;

        // Act
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoAbajo();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoAbajo();
        gpsChallenge.moverVehiculoIzquierda();
        gpsChallenge.moverVehiculoAbajo();
        gpsChallenge.moverVehiculoAbajo();
        gpsChallenge.moverVehiculoAbajo();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoArriba();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoArriba();
        gpsChallenge.moverVehiculoIzquierda();

        // Assert
        assertEquals(movimientosEsperados, gpsChallenge.getMovimientos());
    }

    @Test
    public void autoSeRecorreElMapaYSeEncuentraConObstaculos(){
        // Arrange
        Auto vehiculo = new Auto();
        Juego gpsChallenge = new Juego(vehiculo);
        int movimientosEsperados = 22;

        // Act
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoAbajo();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoAbajo();
        gpsChallenge.moverVehiculoIzquierda();
        gpsChallenge.moverVehiculoAbajo();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoAbajo();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoAbajo();
        gpsChallenge.moverVehiculoAbajo();
        gpsChallenge.moverVehiculoIzquierda();

        // Assert
        assertEquals(movimientosEsperados, gpsChallenge.getMovimientos());
    }
}