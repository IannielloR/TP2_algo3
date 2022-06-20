package edu.fiuba.algo3.TP2ProyectTests.tests;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.CuatroXCuatro;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test5 {

    public void test5(){
        CuatroXCuatro vehiculo = new CuatroXCuatro();
        Juego gpsChallenge = new Juego(vehiculo);
        int movimientosEsperados = 15;

        // Act
        gpsChallenge.moverVehiculoArriba(); // 1,2
        gpsChallenge.moverVehiculoArriba(); // 1,3
        gpsChallenge.moverVehiculoArriba(); // 1,4
        gpsChallenge.moverVehiculoDerecha(); //2,4
        gpsChallenge.moverVehiculoDerecha(); //3,4
        gpsChallenge.moverVehiculoDerecha(); //4,4
        gpsChallenge.moverVehiculoDerecha(); //5,4
        gpsChallenge.moverVehiculoDerecha(); //6,4
        gpsChallenge.moverVehiculoArriba(); // 6,5



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
