package TP2Proyect;

public class Mapa {
    private int xMaximo;
    private int yMaximo;
    private int xVehiculo;
    private int yVehiculo;
    private int xPiquete;
    private int yPiquete;

    public Mapa(){
        //Cantidad de esquinas que tiene el mapa
        this.xMaximo = 10;
        this.yMaximo = 10;

        //Hay un piquete en 2,2
        this.xPiquete = 2;
        this.yPiquete = 2;

        //Vehiculo empieza en 1,1
        this.xVehiculo = 1;
        this.yVehiculo = 1;
    }

    public int moverVehiculoDerecha(){
        xVehiculo++;
        if ((xVehiculo == xPiquete) && (yVehiculo == yPiquete)){
            return 4;
        }
        return 1;
    }
    public int moverVehiculoArriba(){
        yVehiculo++;
        if ((xVehiculo == xPiquete) && (yVehiculo == yPiquete)){
            return 4;
        }
        return 1;
    }

    public int moverVehiculoAbajo(){
        yVehiculo--;
        if ((xVehiculo == xPiquete) && (yVehiculo == yPiquete)){
            return 4;
        }
        return 1;
    }

    public int moverVehiculoIzquierda(){
        xVehiculo--;
        if ((xVehiculo == xPiquete) && (yVehiculo == yPiquete)){
            return 4;
        }
        return 1;
    }
}
