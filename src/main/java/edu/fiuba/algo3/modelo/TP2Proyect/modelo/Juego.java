package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpesaCambioVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;

public class Juego {
    private int movimientos;
    private Mapa mapa;

    private Random random;


    public Juego(TipoVehiculo vehiculo){
        this.mapa = new Mapa(vehiculo);
        this.movimientos = 0;
    }
    public void agregarInterferencia(int posicion, Interferencia interferencia){
        this.mapa.agregarInterferenciaAMapa(posicion,interferencia);
    }
    public void crearInterferencias() {
        int cantTotalInterfencias = random.generarInt(10);
        for (int i = 0; i < cantTotalInterfencias; i++) {
            int maxInterferencias = 6;
            int numInterferencia = random.generarInt(maxInterferencias);
            int xIncial = random.generarXInicial();
            int yInicial = random.generarYInicial();
            int xFinal = random.generarXFinal(xIncial);
            int yFinal = random.generarYFinal(yInicial, xIncial, xFinal);
            if (numInterferencia == 0) {
                agregarInterferencia(i, new Pozo(xIncial, yInicial, xFinal, yFinal));
            }
            if (numInterferencia == 1) {
                agregarInterferencia(i, new Piquete(xIncial, yInicial, xFinal, yFinal));
            }
            if (numInterferencia == 2) {
                agregarInterferencia(i, new ControlPolicial(xIncial, yInicial, xFinal, yFinal));
            }
            if (numInterferencia == 3) {
                agregarInterferencia(i, new SorpresaDesfavorable(xIncial, yInicial, xFinal, yFinal));
            }
            if (numInterferencia == 4) {
                agregarInterferencia(i, new SorpresaFavorable(xIncial, yInicial, xFinal, yFinal));
            }
            if (numInterferencia == 5) {
                agregarInterferencia(i, new SorpesaCambioVehiculo(xIncial, yInicial, xFinal, yFinal));

            }
        }
    }


    public void moverVehiculoArriba(){
        mapa.moverVehiculoArriba();
    }

    public void moverVehiculoAbajo(){
        mapa.moverVehiculoAbajo();
    }

    public void moverVehiculoIzquierda(){
        mapa.moverVehiculoIzquierda();
    }

    public void moverVehiculoDerecha(){
        mapa.moverVehiculoDerecha();
    }
    public int getMovimientos(){
        return this.mapa.devolverMovimientos();
    }

/*    public void prueba(){
        Random rand = new Random(); //instance of random class
        int upperbound = 25;
        //generate random values from 0-24
        int int_random = rand.nextInt(upperbound);
    }
*/
}
