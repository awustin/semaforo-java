package custom.operaciones;

import custom.semaforo.*;

public class Suma extends Thread {
    //Procesos suma
    private BufferInt contenedor;
    private SemaforoBinario sem1, sem2;
    private int suma = 0, buffercons;

    public Suma(BufferInt c, SemaforoBinario sem1, SemaforoBinario sem2){
        this.sem1 = sem1;
        this.sem2 = sem2;
        contenedor = c;
    }

    public void run(){
        System.out.println("\nHilo consumidor ID: "+Thread.currentThread().getId());
        try {
            System.out.println("\n["+Thread.currentThread().getId()+"]"+" Leyendo elementos...");
            while(buffercons < 500){
                sem2.WAIT();
                buffercons = contenedor.sacar();
                sem1.SIGNAL();
                if(buffercons % 2 != 0) suma = suma + contenedor.sacar();
                System.out.println("\n["+Thread.currentThread().getId()+"]"+" Suma = "+suma);
            }            
        } catch (Exception e) {
            System.out.println("\nSe produjo un error en el consumidor\n");
        }
        System.out.println("\nFinalizó el hilo consumidor.");
    }
}