import java.util.Random;

public class Coche implements Runnable {
    private String nombre;
    private int distanciaRecorrida;
    private boolean terminar;
    private static final int DISTANCIA_META = 100;

    public Coche(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }
    @Override
    public void run() {
        while (this.distanciaRecorrida <= DISTANCIA_META) {
            this.avanzar();
            this.obstaculo();
        }
        this.terminar = true;
    }
    private void avanzar(){
        int avance = new Random().nextInt(9,15);
        distanciaRecorrida+=avance;
        System.out.println(this.nombre+" avanza "+distanciaRecorrida+" metros");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void obstaculo(){
        int retraso = 0;
        int tropieza = new Random().nextInt(15);
        if (tropieza<=4){
            retraso += new Random().nextInt(1,4);
            distanciaRecorrida-=retraso;
            System.out.println(this.nombre+" tropieza y retrocede "+ retraso);
        }
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getDistanciaRecorrida(){
        return this.distanciaRecorrida;
    }

    public boolean isTerminar(){
        return this.terminar;
    }
}