package edu.fiuba.algo3.TP2ProyectTests.tests;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.CuatroXCuatro;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Un vehículo atraviesa la ciudad y encuentra una sorpresa favorable.

public class Test4 {
    @Test
    public void test(){
        // Arrange
        Auto vehiculo = new Auto();
        Juego gpsChallenge = new Juego(vehiculo);
        int movimientosEsperados = 4;

        // Act
        gpsChallenge.moverVehiculoAbajo();//(1,2)
        gpsChallenge.moverVehiculoAbajo();//(1,3)
        gpsChallenge.moverVehiculoAbajo();//(1,4)
        gpsChallenge.moverVehiculoAbajo();//(1,5)
        gpsChallenge.moverVehiculoAbajo();//(1,6)Choca con la sorpresa favorable
//        gpsChallenge.moverVehiculoAbajo();
        // Assert
        assertEquals(movimientosEsperados, gpsChallenge.getMovimientos());
    }
}
