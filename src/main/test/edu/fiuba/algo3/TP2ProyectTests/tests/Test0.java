package edu.fiuba.algo3.TP2ProyectTests.tests;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.CuatroXCuatro;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test0 {
    @Test
    public void test(){
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
/*
* package edu.fiuba.algo3.tp2Tests;


    Una moto atraviesa la ciudad y se encuentra con un Pozo. Es penalizada en tres movimientos.
    Pozos: Le suma 3 movimientos de penalización a autos y motos.
    Para una 4x4 penaliza en 2 movimientos luego de atravesar 3 pozos.


import edu.fiuba.algo3.modelo.Juego;
        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.assertEquals;


public class test0 {
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
        assertEquals(movimientosEsperados, gpsChallenge.getMovimientos());
    }
}*/