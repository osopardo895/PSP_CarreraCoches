import java.util.ArrayList;
import java.util.List;

public class CarreraDeCoches {

    public static void main(String[] args) {
        Coche coche1 = new Coche("Coche 1");
        Coche coche2 = new Coche("Coche 2");
        Coche coche3 = new Coche("Coche 3");
        Coche coche4 = new Coche("Coche 4");
        Coche coche5 = new Coche("Coche 5");

        Thread hilo1 = new Thread(coche1);
        Thread hilo2 = new Thread(coche2);
        Thread hilo3 = new Thread(coche3);
        Thread hilo4 = new Thread(coche4);
        Thread hilo5 = new Thread(coche5);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();

        List<Coche> coches = new ArrayList<>(List.of(
                coche1,coche2,coche3,coche4,coche5
        ));
        Coche ganador = null;
        boolean carreraSigue = true;
        while (carreraSigue) {
            for (Coche i : coches) {
                if (i.isTerminar()){
                    carreraSigue=false;
                    ganador = i;
                }
            }
        }
        System.out.println(ganador.getNombre()+" HA GANADO LA CARRERA");
    }
}