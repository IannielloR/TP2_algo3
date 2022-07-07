package edu.fiuba.algo3.modelo.TP2Proyect.modelo.GPSChallenge;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.mapa.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaFavorable;

public class Random {
    private java.util.Random random = new java.util.Random();
    private int maxXMapa;
    private int maxYMapa;

    public Random(){
    }

    public Random(int xMapa, int yMapa) {
        this.maxXMapa = xMapa;
        this.maxYMapa = yMapa;
    }

    public int generarXInicial(){
        int coordenada =  random.nextInt((this.maxXMapa));
        if((coordenada == 0)||(this.maxXMapa == 1)){
            coordenada = 1;
        }
        return coordenada;
    }

    public int generarYInicial(){
        int coordenada =  random.nextInt((this.maxYMapa));
        if((coordenada == 0)||(this.maxYMapa == 1)){
            coordenada = 1;
        }
        return coordenada;
    }

    public int generarXFinal(int xInicial){
        int valor = 2;
        int empiezaConX = random.nextInt(valor);
        int posXFinal = xInicial;
        if(empiezaConX == 0){
            if(xInicial >= this.maxXMapa){
                posXFinal = (this.maxXMapa-1);
            }else{
                posXFinal = (xInicial +1);
            }
            if(maxXMapa==1){
                posXFinal = xInicial;
            }
        }
        return posXFinal;
    }

    public int generarYFinal(int yInicial,int xInicial, int xFinal){
        int posYFinal = yInicial;
        if(xFinal == xInicial){
            if(yInicial >= this.maxYMapa){
                posYFinal = (this.maxYMapa-1);
            }else{
                posYFinal = (yInicial +1);
            }
            if(maxYMapa==1){
                posYFinal = yInicial;
            }
        }
        return posYFinal;
    }

    public int generarInt( int numMax){
        int num = random.nextInt(numMax);
        if(num == 0){
            num = 1;
        }
        return num;
    }

    public int generarYMapa(int numMax, int maxXMapa){
        int num = random.nextInt(numMax);
        if((maxXMapa == 1) && (num <= 1)){
            num = 2;
        }
        if(num == 0){
            num = 1;
        }
        return num;
    }

    public float generarFloat(){
        return random.nextFloat();
    }

    public Interferencia crearInterferencias() {
        int maxInterferencias = 6;
        int numInterferencia = random.nextInt(maxInterferencias);
        int xIncial = generarXInicial();
        int yInicial = generarYInicial();
        int xFinal = generarXFinal(xIncial);
        int yFinal = generarYFinal(yInicial, xIncial, xFinal);
        if (numInterferencia == 0) {
            return new Pozo(xIncial, yInicial, xFinal, yFinal);
        }
        if (numInterferencia == 1) {
            if((maxXMapa == 1)||(maxYMapa == 1)){
                return new Pozo(xIncial, yInicial, xFinal, yFinal);
            }
            return new Piquete(xIncial, yInicial, xFinal, yFinal);
        }
        if (numInterferencia == 2) {
            return new ControlPolicial(xIncial, yInicial, xFinal, yFinal, generarFloat());
        }
        if (numInterferencia == 3) {
            return new SorpresaDesfavorable(xIncial, yInicial, xFinal, yFinal);
        }
        if (numInterferencia == 4) {
            return new SorpresaFavorable(xIncial, yInicial, xFinal, yFinal);
        }
        if (numInterferencia == 5) {
            return new SorpresaCambioVehiculo(xIncial, yInicial, xFinal, yFinal);
        }
        return null;
    }

}

