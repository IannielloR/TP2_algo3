package edu.fiuba.algo3.TP2ProyectTests;/*
    Una moto atraviesa la ciudad y se encuentra con un Piquete. Es penalizada en dos movimientos.
*/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import TP2Proyect.Juego;

public class testCasoDeUso4 {
    @Test
    public void test(){
        // Arrange
        Juego gpsChallenge = new Juego("moto");
        int movimientosEsperados = 6;

        // Act
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoArriba();
        gpsChallenge.moverVehiculoIzquierda();

        // Assert
        assert(movimientosEsperados == gpsChallenge.getMovimientos());
    }
}
