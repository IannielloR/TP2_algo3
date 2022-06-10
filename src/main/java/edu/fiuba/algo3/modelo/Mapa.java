package edu.fiuba.algo3.modelo;

public class Mapa {
    private int xMaximo;
    private int yMaximo;
    private int xVehiculo;
    private int yVehiculo;
    private int xPozo;
    private int yPozo;
    public Mapa(){
        //Cantidad de esquinas que tiene el mapa
        this.xMaximo = 10;
        this.yMaximo = 10;

        //Hay un pozo en 2,2
        this.xPozo = 2;
        this.yPozo = 2;
        //Vehiculo empieza en 1,1
        this.xVehiculo = 1;
        this.yVehiculo = 1;
    }

    public int moverVehiculoDerecha(){
        xVehiculo++;
        if ((xVehiculo == xPozo) && (yVehiculo == yPozo)){
            return 4;
        }
        return 1;
    }

    public int moverVehiculoArriba(){
        yVehiculo++;
        if ((xVehiculo == xPozo) && (yVehiculo == yPozo)){
            return 4;
        }
        return 1;
    }

    public int moverVehiculoAbajo(){
        yVehiculo--;
        if ((xVehiculo == xPozo) && (yVehiculo == yPozo)){
            return 4;
        }
        return 1;
    }

    public int moverVehiculoIzquierda(){
        xVehiculo--;
        if ((xVehiculo == xPozo) && (yVehiculo == yPozo)){
            return 4;
        }
        return 1;
    }
}
