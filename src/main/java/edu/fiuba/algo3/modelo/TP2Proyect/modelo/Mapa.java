package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;

import java.util.List;
import java.util.ArrayList;


public class Mapa {
    private int maximoX;
    private int maximoY;
    private Vehiculo vehiculo;
    private int posVehiculoX;
    private int posVehiculoY;
    private int senialMovimiento;
    private List<Interferencia> interferencias = new ArrayList<Interferencia>();
    private int senialMovimeinto;

    private Random random;

    public Mapa(TipoVehiculo vehiculo){
        this.maximoX = 10;
        this.maximoY = 10;
        this.vehiculo = new Vehiculo(vehiculo);
        this.posVehiculoX = 1;
        this.posVehiculoY = 1;
        this.senialMovimeinto = 0;
        this.random = new Random(maximoX, maximoY);
//        crearInterferencias();

    }


    public int devolverMovimientos(){
        return this.vehiculo.devolverMovimientos();
    }
    public void moverVehiculoAbajo(){
        if(posVehiculoY + 1 <= maximoY) {
            if (revisarObstaculos(posVehiculoX, (posVehiculoY + 1))) {
                posVehiculoY++;
            }
        }
    }
    public void moverVehiculoArriba(){
        if(posVehiculoY - 1 != 0) {
            if(revisarObstaculos(posVehiculoX, (posVehiculoY - 1))){
                posVehiculoY--;

            }
        }

    }
    public void moverVehiculoDerecha(){
        if(posVehiculoX + 1 <= maximoX) {
            if(revisarObstaculos((posVehiculoX + 1), posVehiculoY)){
                posVehiculoX++;
            }
        }
    }
    public void moverVehiculoIzquierda(){
        if(posVehiculoX - 1 != 0) {
            if(revisarObstaculos((posVehiculoX - 1), posVehiculoY)){
                posVehiculoX--;
            }
        }
    }
    private boolean revisarObstaculos(int posX, int posY){
        boolean vehiculoAvanza = false;
        for(int i = 0; i < this.interferencias.size(); i++){
            vehiculoAvanza = interferencias.get(i).analizarVehiculo(this.vehiculo,posVehiculoX, posVehiculoY, posX, posY);
        }

        return vehiculoAvanza;
    }


    public void agregarInterferenciaAMapa(int posicion, Interferencia interferencia){
        this.interferencias.add(posicion,interferencia);
    }




    /*
    private void crearInterferencias(){

        Interferencia obstaculo1 = new Pozo(2,1,2,2);
        Interferencia obstaculo2 = new Pozo(3,3,3,2);
        Interferencia obstaculo3 = new Pozo(2,4,2,3);
        Interferencia obstaculo5 = new Piquete(5,5,6,5);
        Interferencia obstaculo6 = new ControlPolicial(4,7,5,7);


        this.obstaculos.add(0,obstaculo1);
        this.obstaculos.add(1,obstaculo2);
        this.obstaculos.add(2,obstaculo3);
        this.obstaculos.add(3,obstaculo5);
        this.obstaculos.add(4,obstaculo6);
    }
    */

    /*private void crearInterferencias(){
        int cantTotalInterfencias = random.generarInt(10);
        for(int i = 0; i< cantTotalInterfencias; i++){
            int maxInterferencias = 6;
            int numInterferencia = random.generarInt(maxInterferencias);
            int xIncial = random.generarXInicial();
            int yInicial = random.generarYInicial();
            int xFinal = random.generarXFinal(xIncial);
            int yFinal = random.generarYFinal(yInicial, xIncial, xFinal);
            if (numInterferencia == 0){
                this.obstaculos.add(i,new Pozo(xIncial, yInicial, xFinal, yFinal));
            }
            if (numInterferencia == 1){
                this.obstaculos.add(i,new Piquete(xIncial, yInicial, xFinal, yFinal));
            }
            if (numInterferencia == 2){
                this.obstaculos.add(i,new ControlPolicial(xIncial, yInicial, xFinal, yFinal));
            }
            if (numInterferencia == 3){
                this.obstaculos.add(i,new SorpresaDesfavorable(xIncial, yInicial, xFinal, yFinal));
            }
            if (numInterferencia == 4){
                this.obstaculos.add(i,new SorpresaFavorable(xIncial, yInicial, xFinal, yFinal));
            }
            if (numInterferencia == 5){
                this.obstaculos.add(i,new SorpesaCambioVehiculo(xIncial, yInicial, xFinal, yFinal));

            }
        }
    }*/
}

