package edu.fiuba.algo3.TP2ProyectTests.tests;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.CuatroXCuatro;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test3 {

    @Test
    public void test(){
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
}
/*      Interferencia obstaculo1 = new Pozo(2,1);
        Interferencia obstaculo2 = new Pozo(2,2);
        Interferencia obstaculo3 = new Pozo(3,2);
        Interferencia obstaculo4 = new Piquete(4,2);
        Interferencia obstaculo5 = new ControlPolicial(4,1);
        Interferencia obstaculo6 = new SorpresaDesfavorable(4,5);
        Interferencia obstaculo7 = new SorpresaFavorable(3,3);
        Interferencia obstaculo8 = new SorpesaCambioVehiculo(6,5);
        Interferencia obstaculo9 = new Piquete(7,4);
        Interferencia obstaculo10 = new SorpresaDesfavorable(7,4);*/