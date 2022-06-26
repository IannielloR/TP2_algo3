package edu.fiuba.algo3.TP2ProyectTests.tests;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Auto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestVehiculoLlegaAMeta {
    @Test
    public void test1(){
        // Arrange
        Auto vehiculo = new Auto();
<<<<<<< HEAD
        Juego gpsChallenge = new Juego(vehiculo);
        gpsChallenge.agregarMeta(1);
=======
        Juego gpsChallenge = new Juego(vehiculo,10,10);
        gpsChallenge.agregarMeta(1);
        int movimientosEsperados = 9;
>>>>>>> master
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
<<<<<<< HEAD
    }
}
=======
        assertEquals(movimientosEsperados,gpsChallenge.getMovimientos());
    }
}
>>>>>>> master
