package edu.fiuba.algo3.modelo.TP2Proyect.modelo;

public class SorpesaCambioVehiculo {
    private int posX;
    private int posY;

    public SorpesaCambioVehiculo(int id1, int id2) {
        this.posX = id1;
        this.posY = id2;
    }
    public Vehiculo analizarVehiculo(Vehiculo vehiculo, int id1, int id2){
        Vehiculo nuevoVehiculo = vehiculo;
        if(this.posX == id1 && this.posY == id2 ){
            String tipoVehiculo = vehiculo.devolverSorpresaCambioDeVehiculo();
            if(tipoVehiculo == "moto"){
                nuevoVehiculo = new Auto();

            }else if(tipoVehiculo == "auto"){
                nuevoVehiculo = new CuatroXCuatro();

            }else if(tipoVehiculo == "4x4"){
                nuevoVehiculo = new Moto();

            }
        }
        return nuevoVehiculo;
    }
}
