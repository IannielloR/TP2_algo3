package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.Vehiculo;
import java.lang.String;
import java.lang.Math;
public class Mapa{
    //private Vehiculo vehiculo;
    //private Ubicaciones ubicaciones;
    private int costoColicionMoviemtos;
    private int costoMovimiento;
    private int xMaximo;
    private int yMaximo;
    private int xVehiculo;
    private int yVehiculo;


    private int xPozo;
    private int yPozo;

    private int xControlPolicial;
    private int yControlPolicial;


    //private Moto moto;
    //private Pozo pozo;
    public Mapa(String tipoVehiculo){
        //Cantidad de esquinas que tiene el mapa
        this.xMaximo = 10;
        this.yMaximo = 10;

        //Hay un pozo en 2,2
        this.xPozo = 2;
        this.yPozo = 2;

        this.xControlPolicial = 1;
        this.yControlPolicial = 2;

        //Vehiculo empieza en 1,1
        this.xVehiculo = 1;
        this.yVehiculo = 1;
    }
    //private int verificarColision(){
        //costoColicionMoviemtos = ubicaciones.calcularCostosColicion(xVehiculo, yVehiculo, vehiculo.tipo()); //ubicacion tiene una lista de todos los obstaculos (los objetos tienen guardada la ubicacion), entonces tienen un metodo "costoDeColicion",
        //return (costoColicionMoviemtos + movimiento);
    //}
    public int moverVehiculoDerecha(){
        costoColicionMoviemtos = 0;
        xVehiculo++;
        //costoColicionMoviemtos = verificarColision();
        if ((xVehiculo == xPozo) && (yVehiculo == yPozo)){
            //bool motoPozo = moto.atravesoUnPozo();
            //return pozo.movimientos(motoPozo);
            costoColicionMoviemtos = 3;
        }
        if ((xVehiculo == xControlPolicial) && (yVehiculo == yControlPolicial)){
            double prob4x4 = Math.random();
            if(prob4x4 < 0.3){
                costoColicionMoviemtos = 3;
            }
            //bool motoPozo = moto.atravesoUnPozo();
            //return (controlPolicial.movimientos(vehiculo.tipo())+costoMovimiento); el control policial le pasa el tipo a la clase porcentaje y porcentaje le dice si tine que cobrarle los movimientos o no
        }
        return (costoColicionMoviemtos + costoMovimiento);
    }

    public int moverVehiculoArriba(){
        costoColicionMoviemtos = 0;
        yVehiculo++;
        //costoColicionMoviemtos = verificarColision();
        if ((xVehiculo == xPozo) && (yVehiculo == yPozo)){
            costoColicionMoviemtos = 3;
        }
        if ((xVehiculo == xControlPolicial) && (yVehiculo == yControlPolicial)){
            double prob4x4 = Math.random();
            if(prob4x4 < 0.3){
                costoColicionMoviemtos = 3;
            }
        }

        return (costoColicionMoviemtos + costoMovimiento);
    }

    public int moverVehiculoAbajo(){
        costoColicionMoviemtos = 0;
        yVehiculo--;
        //costoColicionMoviemtos = verificarColision();
        if ((xVehiculo == xPozo) && (yVehiculo == yPozo)){
            costoColicionMoviemtos = 3;
        }
        if ((xVehiculo == xControlPolicial) && (yVehiculo == yControlPolicial)){
            double prob4x4 = Math.random();
            if(prob4x4 < 0.3){
                costoColicionMoviemtos = 3;
            }

        }
        return (costoColicionMoviemtos + costoMovimiento);
    }

    public int moverVehiculoIzquierda(){
        costoColicionMoviemtos = 0;
        xVehiculo--;
        //costoColicionMoviemtos = verificarColision();
        if ((xVehiculo == xPozo) && (yVehiculo == yPozo)){
            costoColicionMoviemtos = 3;
        }
        if ((xVehiculo == xControlPolicial) && (yVehiculo == yControlPolicial)){
            double prob4x4 = Math.random();
            if(prob4x4 < 0.3){
                costoColicionMoviemtos = 3;
            }
        }
        return (costoColicionMoviemtos + costoMovimiento);
    }
}
