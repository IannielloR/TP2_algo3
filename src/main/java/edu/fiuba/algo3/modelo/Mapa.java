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

    public int moverVehiculo(String direccion){
        switch (direccion){
            case "arriba":
                yVehiculo++;
                if ((xVehiculo == xPozo) && (yVehiculo == yPozo)){
                    return 4;
                }
                break;
            case "abajo":
                yVehiculo--;
                if ((xVehiculo == xPozo) && (yVehiculo == yPozo)){
                    return 4;
                }
                break;
            case "izquierda":
                xVehiculo--;
                if ((xVehiculo == xPozo) && (yVehiculo == yPozo)){
                    return 4;
                }
                break;
            case "derecha":
                xVehiculo++;
                if ((xVehiculo == xPozo) && (yVehiculo == yPozo)){
                    return 4;
                }
                break;
        }
        return 1;
    }
}
