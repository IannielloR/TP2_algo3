package edu.fiuba.algo3.TP2ProyectTests.tests;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAleatorioMuestra {
    @Test
    public void test1() {
        // Arrange
        Auto vehiculo = new Auto();
        Juego gpsChallenge = new Juego(vehiculo);
        gpsChallenge.crearInterferencias();

        // Act
        gpsChallenge.moverVehiculoAbajo();//(1,2)
        gpsChallenge.moverVehiculoDerecha();//(2,2)
        gpsChallenge.moverVehiculoDerecha();//(3,2)
        gpsChallenge.moverVehiculoAbajo();//(3,3)
        gpsChallenge.moverVehiculoDerecha();//(3,3)
        gpsChallenge.moverVehiculoAbajo(); // (4,3)
        gpsChallenge.moverVehiculoDerecha(); //(5,3)
        gpsChallenge.moverVehiculoArriba(); // (5,2)
        gpsChallenge.moverVehiculoArriba(); // (5,1)
        gpsChallenge.moverVehiculoIzquierda(); // (4,1)
        gpsChallenge.moverVehiculoIzquierda(); // (3,1)

        boolean validacion = true;
        if(gpsChallenge.getMovimientos() < 0){
            validacion = false;
        }
        assertTrue(validacion);
    }
}
