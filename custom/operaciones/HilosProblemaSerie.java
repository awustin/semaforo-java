package custom.operaciones;
import java.util.ArrayList;
import custom.semaforo.*;

public class HilosProblemaSerie extends Thread {
    
    private ArrayList<Integer> leidos = new ArrayList<Integer>();
    private BufferVector buffer;    
    private SemaforoBinario extraer;

    public HilosProblemaSerie(BufferVector buffer, SemaforoBinario extraer) {
        this.buffer = buffer;
        this.extraer = extraer;
    }

    public void run(){
        int suma=0;
        while(true) {
            System.out.println("\nID Hilo: "+Thread.currentThread().getId());
            try{
                //ultimo.WAIT(); /*WAIT si queda un solo elemento*/
                extraer.WAIT(); //puede pasar
                leidos.add(buffer.extraerUltimo());
                leidos.add(buffer.extraerUltimo());
                System.out.printf("\n[ %d ]: ",Thread.currentThread().getId());
                buffer.mostrar();
                suma = leidos.get(leidos.size() - 1) + leidos.get(leidos.size() - 2);
                buffer.agregarUltimo(suma);
                System.out.printf("\n[ %d ]: ",Thread.currentThread().getId());
                buffer.mostrar();
                extraer.SIGNAL(); //ya saqué dos, pase el siguiente    
                
                //agregar.WAIT(); //me voy a la cola de espera, porq hay q agregar en orden.
                
                //ultimo.SIGNAL();
                //pendiente.SIGNAL();
                //agregar.SIGNAL(); 
            }
            catch (Exception e) {
                System.out.println("\nError en el hilo: "+Thread.currentThread().getId()+"\n");
            }
        }
    }
}
