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

import java.util.List;
import java.util.ArrayList;

public class Mapa {
    private int maximoX;
    private int maximoY;
    private TipoVehiculo vehiculo;
    private int posVehiculoX;
    private int posVehiculoY;

    private List<Interferencia> interferencias = new ArrayList<Interferencia>();

    public Mapa(Vehiculo vehiculo){
        this.maximoX = 10;
        this.maximoY = 10;
        this.vehiculo = new TipoVehiculo(vehiculo);
        this.posVehiculoX = 1;
        this.posVehiculoY = 1;
        crearInterferencias();
    }
    public int moverVehiculoAbajo(){
        if(posVehiculoY + 1 <= maximoY) {
            posVehiculoY++;

            return revisarObstaculos();
        }
        return 0;
    }
    public int moverVehiculoArriba(){
        if(posVehiculoY - 1 == 0) {
            posVehiculoY--;

            return revisarObstaculos();
        }
        return 0;
    }
    public int moverVehiculoDerecha(){
        if(posVehiculoX + 1 <= maximoX) {
            posVehiculoX++;

            return revisarObstaculos();
        }
        return 0;
    }
    public int moverVehiculoIzquierda(){
        if(posVehiculoX - 1 == 0) {
            posVehiculoX--;

            return revisarObstaculos();
        }
        return 0;
    }
    private int revisarObstaculos(){
        int movimientos = 1;
        for(int i = 0; i < interferencias.size(); i++){
            movimientos += interferencias.get(i).analizarVehiculo(vehiculo,posVehiculoX, posVehiculoY, movimientos);
        }
        return movimientos;
    }
    private void crearInterferencias(){
        Interferencia obstaculo1 = new Pozo(2,1);
        Interferencia obstaculo2 = new Pozo(2,2);
        Interferencia obstaculo3 = new Pozo(3,2);
        Interferencia obstaculo4 = new Piquete(4,2);
        Interferencia obstaculo5 = new ControlPolicial(4,1);
        Interferencia obstaculo6 = new SorpresaDesfavorable(4,5);
        Interferencia obstaculo7 = new SorpresaFavorable(3,3);
        Interferencia obstaculo8 = new SorpesaCambioVehiculo(6,5);
        Interferencia obstaculo9 = new Piquete(7,4);
        Interferencia obstaculo10 = new SorpresaDesfavorable(7,4);
        this.interferencias.add(0,obstaculo1);
        this.interferencias.add(1,obstaculo2);
        this.interferencias.add(2,obstaculo3);
        this.interferencias.add(3,obstaculo4);
        this.interferencias.add(4,obstaculo5);
        this.interferencias.add(5,obstaculo6);
        this.interferencias.add(6,obstaculo7);
        this.interferencias.add(7,obstaculo8);
        this.interferencias.add(8,obstaculo9);
        this.interferencias.add(9,obstaculo10);
    }
}
