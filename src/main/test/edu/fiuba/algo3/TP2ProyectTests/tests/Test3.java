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
        gpsChallenge.moverVehiculoDerecha(); //2,1
        gpsChallenge.moverVehiculoAbajo(); // 2,2
        gpsChallenge.moverVehiculoDerecha(); // 3,2
        gpsChallenge.moverVehiculoDerecha(); // 4,2
        gpsChallenge.moverVehiculoAbajo(); //4,3 = 6

        gpsChallenge.moverVehiculoIzquierda(); //3,3
        gpsChallenge.moverVehiculoAbajo(); //3,4
        gpsChallenge.moverVehiculoAbajo(); //3,5
        gpsChallenge.moverVehiculoAbajo(); // 3,6
        gpsChallenge.moverVehiculoDerecha(); // 4,6
        gpsChallenge.moverVehiculoArriba(); // 4,5
        gpsChallenge.moverVehiculoDerecha(); // 5,5
        gpsChallenge.moverVehiculoDerecha(); // 6,5
        gpsChallenge.moverVehiculoDerecha(); // 7,5
        gpsChallenge.moverVehiculoDerecha(); // 8,5
        gpsChallenge.moverVehiculoArriba(); // 7,5
        gpsChallenge.moverVehiculoIzquierda(); //7,4

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


        // Assert
        assertEquals(movimientosEsperados, gpsChallenge.getMovimientos());
    }
}
