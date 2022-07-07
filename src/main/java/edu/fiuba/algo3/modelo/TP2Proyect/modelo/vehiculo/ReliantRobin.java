package edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.GPSChallenge.Random;

public class ReliantRobin extends TipoVehiculo{
    private TipoVehiculo vehiculo;
    private Random random;

    private float randomProb;
    public ReliantRobin(){
        this.vehiculo = new Moto();
        this.random = new Random();
    }
    public ReliantRobin(float proba){
        this.vehiculo = new Moto();
        this.randomProb = proba;
    }
    public TipoVehiculo devolverSorpresaCambioDeVehiculo() {
        prob();
        return new ReliantRobin();
    }

    public int devolverPenalizacionControlPolical(float prob){
        prob();
        return this.vehiculo.devolverPenalizacionControlPolical(prob);
    }

    public int devolverPenalizacionPozo(){
        prob();
        return this.vehiculo.devolverPenalizacionPozo();
    }

    public int devolverPenalizacionPiquete(){
        prob();
        return this.vehiculo.devolverPenalizacionPiquete();
    }
    public void prob(){
        if(this.random.generarFloat()<0.6){
            this.vehiculo = new Auto();
        }else {
            this.vehiculo = new Moto();
        }
    }

}
