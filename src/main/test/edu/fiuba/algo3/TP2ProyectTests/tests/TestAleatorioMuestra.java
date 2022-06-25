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
        gpsChallenge.moverVehiculoAbajo();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoAbajo();
        gpsChallenge.moverVehiculoDerecha();
        gpsChallenge.moverVehiculoAbajo();
        gpsChallenge.moverVehiculoDerecha(); 
        gpsChallenge.moverVehiculoArriba(); 
        gpsChallenge.moverVehiculoArriba(); 
        gpsChallenge.moverVehiculoIzquierda(); 
        gpsChallenge.moverVehiculoIzquierda(); 

        boolean validacion = true;
        if(gpsChallenge.getMovimientos() < 0){
            validacion = false;
        }
        assertTrue(validacion);
    }
}
