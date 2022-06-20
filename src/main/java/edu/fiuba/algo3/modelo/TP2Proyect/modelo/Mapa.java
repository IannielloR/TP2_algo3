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
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Random;

import java.util.List;
import java.util.ArrayList;


public class Mapa {
    private int maximoX;
    private int maximoY;
    private TipoVehiculo vehiculo;
    private int posVehiculoX;
    private int posVehiculoY;

    private int senialMovimeinto;

    private Random random;

    private List<Interferencia> obstaculos = new ArrayList<Interferencia>();

    private List<Interferencia> sorpresas = new ArrayList<Interferencia>();

    public Mapa(Vehiculo vehiculo){
        this.maximoX = 10;
        this.maximoY = 10;
        this.vehiculo = new TipoVehiculo(vehiculo);
        this.posVehiculoX = 1;
        this.posVehiculoY = 1;
        this.senialMovimeinto = 0;
        this.random = new Random(maximoX, maximoY);
        crearInterferencias();
    }
    public int moverVehiculoAbajo(int movimientos){
        if(posVehiculoY + 1 <= maximoY) {
            int movimientosRealizados = revisarObstaculos(movimientos,posVehiculoX, (posVehiculoY + 1));
            if(this.senialMovimeinto != 1){
                posVehiculoY++;
                return movimientosRealizados;
            }
            this.senialMovimeinto = 0;
            return movimientosRealizados;
        }
        return 0;
    }
    public int moverVehiculoArriba(int movimientos){
        if(posVehiculoY - 1 != 0) {
            int movimientosRealizados = revisarObstaculos(movimientos,posVehiculoX, (posVehiculoY - 1));
            if(this.senialMovimeinto != 1){
                posVehiculoY--;
                return movimientosRealizados;
            }
            this.senialMovimeinto = 0;
            return movimientosRealizados;
        }
        return 0;
    }
    public int moverVehiculoDerecha(int movimientos){
        if(posVehiculoX + 1 <= maximoX) {
            int movimientosRealizados = revisarObstaculos(movimientos,(posVehiculoX + 1), posVehiculoY);
            if(this.senialMovimeinto != 1){
                posVehiculoX++;
                return movimientosRealizados;
            }
            this.senialMovimeinto = 0;
            return movimientosRealizados;
        }
        return 0;
    }
    public int moverVehiculoIzquierda(int movimientos){
        if(posVehiculoX - 1 != 0) {
            int movimientosRealizados = revisarObstaculos(movimientos,(posVehiculoX - 1), posVehiculoY);
            if(this.senialMovimeinto != 1){
                posVehiculoX--;
                return movimientosRealizados;
            }
            this.senialMovimeinto = 0;
            return movimientosRealizados;
        }
        return 0;
    }
    private int revisarObstaculos(int movimientosTotales, int posX, int posY){
        int movimientos = 1;
        int movimientoIndividual;
        for(int i = 0; i < this.obstaculos.size(); i++){
            movimientoIndividual = obstaculos.get(i).analizarVehiculo(this.vehiculo,posVehiculoX, posVehiculoY, posX, posY, movimientosTotales);
            if(movimientoIndividual == -1){
                this.senialMovimeinto = 1;
            }
            movimientos += movimientoIndividual;
        }

        for(int i = 0; i < this.sorpresas.size(); i++){
            movimientos += sorpresas.get(i).analizarVehiculo(this.vehiculo,posVehiculoX, posVehiculoY, posX, posY, movimientosTotales);

        }
        return movimientos;
    }
    private void crearInterferencias(){
        //Interferencia obstaculo1 = new Pozo(maximoX,maximoY);
        //Interferencia obstaculo2 = new Pozo(maximoX,maximoY);
        //Interferencia obstaculo3 = new Pozo(maximoX,maximoY);
        //Interferencia obstaculo4 = new Piquete(maximoX,maximoY);
        //Interferencia obstaculo5 = new ControlPolicial(maximoX,maximoY);

        //Interferencia obstaculo6 = new SorpresaDesfavorable(maximoX,maximoY);
        //Interferencia obstaculo7 = new SorpresaFavorable(maximoX,maximoY);
        //Interferencia obstaculo8 = new SorpesaCambioVehiculo(maximoX,maximoY);

        //Interferencia obstaculo9 = new Piquete(maximoX,maximoY);

        //Interferencia obstaculo10 = new SorpresaDesfavorable(maximoX,maximoY);

        //this.obstaculos.add(0,obstaculo1);
        //this.obstaculos.add(1,obstaculo2);
        //this.obstaculos.add(2,obstaculo3);
        // this.obstaculos.add(3,obstaculo4);
        //this.obstaculos.add(4,obstaculo5);

        //this.sorpresas.add(0,obstaculo6);
        //this.sorpresas.add(1,obstaculo7);
        //this.sorpresas.add(2,obstaculo8);

        //this.obstaculos.add(5,obstaculo9);

        //this.sorpresas.add(3,obstaculo10);
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
    }
}
