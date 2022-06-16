package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;

import java.util.Random;

public class Coordenada {

    private int posXInicial;
    private int posYInicial;
    private int posXFinal;
    private int posYFinal;
    public Coordenada() {
        int posXInicial = 0;
        int posYInicial = 0;
        int posXFinal = 0;
        int posYFinal = 0;
    }

    public void asignarCooredenada(int posXFinal, int posYFinal){

        Random random = new Random();
        int limite = 2;
        int variable = random.nextInt(limite);

//        this.posXInicial;

        if(variable == 0){

        }
    }
}
//    private int posX;
//    private int posY;
//    public Pozo(int id1, int id2) {
//        this.posX = id1;
//        this.posY = id2;
//    }
//    public int analizarVehiculo(TipoVehiculo vehiculo, int id1, int id2, int movimientos){
//        if(this.posX == id1 && this.posY == id2 ){
//            return (vehiculo.devolverVehiculo()).devolverPenalizacionPozo();
//        }
//        return 0;
//    }
//}
