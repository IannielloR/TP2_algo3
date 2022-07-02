package edu.fiuba.algo3.TP2ProyectTests.tests;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.GPSChallenge.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Auto;
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
        gpsChallenge.crearMeta();


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
