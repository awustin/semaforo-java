package custom;

import custom.operaciones.*;
import custom.semaforo.*;
import java.util.ArrayList;

public class ProblemaSerie {
    public static void main(String[] args) {
        /*
            DADA UNA SUCESION DE NUMEROS, k PROCESOS DEBEN:
            * EXTRAER LOS DOS ULTIMOS TERMINOS (LEER Y REMOVER)
            * SUMARLOS
            * DEPOSITAR EL RESULTADO AL FINAL DE LA SUCESION
            HASTA QUE SOLO QUEDE UN ELEMENTO        
        */

        /*
            SEMAFOROS:
            * agregar: PARA LA EXCLUSIÓN MUTUA AL AGREGAR (BINARIO) - FIFO
            * extraer: PARA LA EXCLUSION MUTUA AL EXTRAER (BINARIO)
            * ultimo: INICIALIZADO EN n - 1 (GENERAL) INDICA CUANDO QUEDA UN SOLO ELEMENTO 
            * pendiente: PARA ESPERAR SI HAY ALGUN ELEMENTO Q ESTA SIENDO SUMADO Y HAY Q AGREGAR (BINARIO)
        */
        

        //Declarar e inicializar variables
        int kHilos = 4;
        ArrayList<HilosProblemaSerie> hilosCreados = new ArrayList<HilosProblemaSerie>();
        ArrayList<Integer> vector = new ArrayList<Integer>();
        vector.add(10);
        vector.add(20);
        vector.add(30);
        vector.add(40);
        SemaforoBinario agregar = new SemaforoBinario(1);
        BufferVector serie = new BufferVector(vector);

        //Hilos 
        
        System.out.println("\nCreando hilos...\n");
        while(kHilos>0){
            HilosProblemaSerie hiloi = new HilosProblemaSerie(serie, agregar);
            hilosCreados.add(hiloi);
            kHilos--; 
        }

        //Ejectuar
        System.out.println("\nEjecutando hilos...\n");
        for (HilosProblemaSerie hilo : hilosCreados) {
            hilo.start();
        }
        
    }
}