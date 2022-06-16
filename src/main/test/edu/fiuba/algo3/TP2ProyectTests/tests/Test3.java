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
        gpsChallenge.moverVehiculoDerecha(); //2,1 --> pozo 1 = 1
        gpsChallenge.moverVehiculoAbajo(); // 2,2 --> pozo 2 = 1
        gpsChallenge.moverVehiculoDerecha(); // 3,2 --> pozo 3 = 3
        gpsChallenge.moverVehiculoDerecha(); // 3,2 --> piquete 1 = 0
        gpsChallenge.moverVehiculoAbajo(); // 3,3 --> sorpresa favorable = -1, total = 5
        gpsChallenge.moverVehiculoIzquierda(); //2,3 --> nada = 1
        gpsChallenge.moverVehiculoAbajo(); // 2,4 --> nada = 1
        gpsChallenge.moverVehiculoAbajo(); // 2,5 --> nada = 1
        gpsChallenge.moverVehiculoAbajo(); // 2,6 --> nada = 1
        gpsChallenge.moverVehiculoDerecha(); // 3,6 --> nada = 1
        gpsChallenge.moverVehiculoArriba(); // 3,5 --> nada = 1, total = 11
        gpsChallenge.moverVehiculoDerecha(); // 4,5 --> sorpresa desfavorable = +2/3, total = 14/15
        gpsChallenge.moverVehiculoDerecha(); // 5,5 -> nada = 1
        gpsChallenge.moverVehiculoDerecha(); // 6,5 --> sorpresaCambioVehiculo ( de 4x4 a moto) = 1
        gpsChallenge.moverVehiculoDerecha(); // 7,5 --> nada = 1, total = 17/18
        gpsChallenge.moverVehiculoArriba(); // 7,4 --> piquete = 2 + sorpresa desfavorable = 23( 17 +2) / 24( 17 +2 ) / 25( 18 +2 ) / 21(17)/ 22(17) / 22(18)/ 23(18)
        gpsChallenge.moverVehiculoIzquierda(); //6,4 --> nada = 1, total = ( 22/23/23/24  )/19/20/21
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
