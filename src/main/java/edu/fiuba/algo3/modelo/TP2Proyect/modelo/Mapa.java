package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpesaCambioVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Mapa {
    private int maximoX;
    private int maximoY;
    private Vehiculo vehiculo;
    private int posVehiculoX;
    private int posVehiculoY;

    private int senialMovimeinto;

    private List<Interferencia> obstaculos = new ArrayList<Interferencia>();

    private List<Interferencia> sorpresas = new ArrayList<Interferencia>();

    public Mapa(TipoVehiculo vehiculo){
        this.maximoX = 10;
        this.maximoY = 10;
        this.vehiculo = new Vehiculo(vehiculo);
        this.posVehiculoX = 1;
        this.posVehiculoY = 1;
        this.senialMovimeinto = 0;
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

        Random random = new Random();
        int cantTotalInterfencias = random.nextInt(10);
        int indiceObstaculos = 0;
        int indiceSorpresas = 0;
        for(int i = 0; i< cantTotalInterfencias; i++){
            int maxInterferencias = 6;
            int numInterferencia = random.nextInt(maxInterferencias);

            if (numInterferencia == 0){
                this.obstaculos.add(indiceObstaculos,new Pozo(maximoX,maximoY));
                indiceObstaculos++;
            }
            if (numInterferencia == 1){
                this.obstaculos.add(indiceObstaculos,new Piquete(maximoX,maximoY));
                indiceObstaculos++;
            }
            if (numInterferencia == 2){
                this.obstaculos.add(indiceObstaculos,new ControlPolicial(maximoX,maximoY));
                indiceObstaculos++;
            }
            if (numInterferencia == 3){
                this.sorpresas.add(indiceSorpresas,new SorpresaDesfavorable(maximoX,maximoY));
                indiceSorpresas++;
            }
            if (numInterferencia == 4){
                this.sorpresas.add(indiceSorpresas,new SorpresaFavorable(maximoX,maximoY));
                indiceSorpresas++;
            }
            if (numInterferencia == 5){
                this.sorpresas.add(indiceSorpresas,new SorpesaCambioVehiculo(maximoX,maximoY));
                indiceSorpresas++;
            }
        }


    }

}
