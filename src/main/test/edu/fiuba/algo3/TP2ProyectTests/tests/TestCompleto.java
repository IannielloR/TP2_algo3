package edu.fiuba.algo3.TP2ProyectTests.tests;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.GPSChallenge.Juego;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.mapa.Interferencia;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCompleto {
    @Test
    public void test1(){
        // Arrange
        Auto vehiculo = new Auto();
        Juego gpsChallenge = new Juego(vehiculo,10,10);

        Interferencia obstaculo1 = new Pozo(1,2,2,2);

        Interferencia obstaculo2 = new Pozo(2,2, 3,2);

        Interferencia obstaculo3 = new Pozo(5,2,5,3);

        Interferencia obstaculo4 = new Piquete(3,3,4,3);

        Interferencia obstaculo5 = new ControlPolicial(4,1,3,1, (float) 0.1);

        Interferencia obstaculo6 = new SorpresaFavorable(5,5,6,5);

        Interferencia obstaculo7 = new SorpresaDesfavorable(7,6,6,6);

        Interferencia obstaculo8 = new SorpresaCambioVehiculo(4,4,4,5);

        Interferencia obstaculo9 = new SorpresaFavorable(5,2,5,3);

        Interferencia obstaculo10 = new SorpresaDesfavorable(6,1,6,2);

        Interferencia obstaculo11 = new SorpresaCambioVehiculo(2,2,2,3);

        gpsChallenge.agregarInterferencia(0,obstaculo1);
        gpsChallenge.agregarInterferencia(1,obstaculo2);
        gpsChallenge.agregarInterferencia(2,obstaculo3);
        gpsChallenge.agregarInterferencia(3,obstaculo4);
        gpsChallenge.agregarInterferencia(4,obstaculo5);
        gpsChallenge.agregarInterferencia(5,obstaculo6);
        gpsChallenge.agregarInterferencia(6,obstaculo7);
        gpsChallenge.agregarInterferencia(7,obstaculo8);
        gpsChallenge.agregarInterferencia(8,obstaculo9);
        gpsChallenge.agregarInterferencia(9,obstaculo10);
        gpsChallenge.agregarInterferencia(10,obstaculo11);

        gpsChallenge.agregarMeta(1);

        int movimientosEsperados = 39;

        // Act
        // comienza en la posicion (1 , 1)
        gpsChallenge.moverVehiculoAbajo(); // (1,2)
        gpsChallenge.moverVehiculoDerecha(); //(2,2)
        gpsChallenge.moverVehiculoAbajo(); //(2,3)
        gpsChallenge.moverVehiculoDerecha(); //(3,3)
        gpsChallenge.moverVehiculoDerecha(); // (3,3) no avanza
        gpsChallenge.moverVehiculoAbajo(); // (3,4)
        gpsChallenge.moverVehiculoAbajo(); // (3,5)
        gpsChallenge.moverVehiculoDerecha(); //(4,5)
        gpsChallenge.moverVehiculoArriba(); //(4,4)
        gpsChallenge.moverVehiculoDerecha(); //(5,4)
        gpsChallenge.moverVehiculoAbajo(); //(5,5)
        gpsChallenge.moverVehiculoDerecha(); //(6,5)
        gpsChallenge.moverVehiculoAbajo(); // (6,6)
        gpsChallenge.moverVehiculoDerecha(); //(7,6)
        gpsChallenge.moverVehiculoArriba(); //(7,5)
        gpsChallenge.moverVehiculoArriba(); //(7,4)
        gpsChallenge.moverVehiculoArriba(); //(7,3)
        gpsChallenge.moverVehiculoIzquierda(); //(6,3)
        gpsChallenge.moverVehiculoIzquierda(); // (5,3)
        gpsChallenge.moverVehiculoArriba(); // (5,2)
        gpsChallenge.moverVehiculoDerecha(); //(6,2)
        gpsChallenge.moverVehiculoArriba(); //(6,1)
        gpsChallenge.moverVehiculoIzquierda(); //(5,1)
        gpsChallenge.moverVehiculoIzquierda(); //(4,1)
        gpsChallenge.moverVehiculoIzquierda(); // (3,1)
        gpsChallenge.moverVehiculoAbajo(); //(3,2)
        gpsChallenge.moverVehiculoIzquierda(); //(2,2)
//
        // Assert
        assertEquals(movimientosEsperados, gpsChallenge.getMovimientos());
    }
}
