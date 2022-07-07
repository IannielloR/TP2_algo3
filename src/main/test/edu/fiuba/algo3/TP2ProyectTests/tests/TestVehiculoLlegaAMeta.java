package edu.fiuba.algo3.TP2ProyectTests.tests;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.GPSChallenge.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.ReliantRobin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestVehiculoLlegaAMeta {
    @Test
    public void test1(){
        // Arrange
        ReliantRobin vehiculo = new ReliantRobin();
        Juego gpsChallenge = new Juego(vehiculo,10,10);
        gpsChallenge.agregarMeta(1);
        int movimientosEsperados = 9;

        // Act
        gpsChallenge.moverVehiculoDerecha();//(1,2)
        gpsChallenge.moverVehiculoDerecha();//(1,3)
        gpsChallenge.moverVehiculoDerecha();//(1,4)
        gpsChallenge.moverVehiculoDerecha();//(1,5)
        gpsChallenge.moverVehiculoDerecha();//(1,6)
        gpsChallenge.moverVehiculoDerecha();//(1,7)
        gpsChallenge.moverVehiculoDerecha();//(1,8)
        gpsChallenge.moverVehiculoDerecha();//(1,9)
        gpsChallenge.moverVehiculoDerecha();//(1,10)

        // Assert
        assertTrue(gpsChallenge.getLlegada());
    }
}

