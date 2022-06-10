package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

public class CuatroXCuatro extends Vehiculo{
    private int pozos;

    public CuatroXCuatro(){
        this.pozos = 0;
    }
    public int devolverPenalizacionPozo(){
        this.pozos++;
        if(this.pozos == 3){
            this.pozos = 0;
            return 2;
        }
        else{
            return 0;
        }
    }
    public int devolverPenalizacionPiquete(){
        return -1;
    }
}
