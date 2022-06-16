ackage edu.fiuba.algo3.modelo.TP2Proyect.modelo;

import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.Interferencia;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpesaCambioVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.interferencia.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.TipoVehiculo;
import edu.fiuba.algo3.modelo.TP2Proyect.modelo.vehiculo.Vehiculo;

import java.util.List;
import java.util.ArrayList;

public class Mapa {
    private int maximoX;
    private int maximoY;
    private TipoVehiculo vehiculo;
    private int posVehiculoX;
    private int posVehiculoY;

    private int senialMovimeinto;

    private List<Interferencia> obstaculos = new ArrayList<Interferencia>();

    private List<Interferencia> sorpresas = new ArrayList<Interferencia>();

    public Mapa(Vehiculo vehiculo){
        this.maximoX = 10;
        this.maximoY = 10;
        this.vehiculo = new TipoVehiculo(vehiculo);
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
            movimientoIndividual = obstaculos.get(i).analizarVehiculo(this.vehiculo,posX, posY, movimientosTotales);
            if(movimientoIndividual == -1){
                this.senialMovimeinto = 1;
            }
            movimientos += movimientoIndividual;
        }

        for(int i = 0; i < this.sorpresas.size(); i++){
            movimientos += obstaculos.get(i).analizarVehiculo(this.vehiculo,posX, posY, movimientosTotales);

        }
        return movimientos;
    }
    private void crearInterferencias(){
        Interferencia obstaculo1 = new Pozo(2,1);
        Interferencia obstaculo2 = new Pozo(2,2);
        Interferencia obstaculo3 = new Pozo(3,2);
        Interferencia obstaculo4 = new Piquete(4,2);
        Interferencia obstaculo5 = new ControlPolicial(4,1);

        Interferencia obstaculo6 = new SorpresaDesfavorable(4,5);
        Interferencia obstaculo7 = new SorpresaFavorable(10,3);
        Interferencia obstaculo8 = new SorpesaCambioVehiculo(6,5);

        Interferencia obstaculo9 = new Piquete(7,4);

        Interferencia obstaculo10 = new SorpresaDesfavorable(7,4);

        this.obstaculos.add(0,obstaculo1);
        this.obstaculos.add(1,obstaculo2);
        this.obstaculos.add(2,obstaculo3);
        this.obstaculos.add(3,obstaculo4);
        this.obstaculos.add(4,obstaculo5);

        this.sorpresas.add(0,obstaculo6);
        this.sorpresas.add(1,obstaculo7);
        this.sorpresas.add(2,obstaculo8);

        this.obstaculos.add(5,obstaculo9);

        this.sorpresas.add(3,obstaculo10);
    }
}

