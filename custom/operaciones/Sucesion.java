package custom.operaciones;

import custom.semaforo.BufferInt;
import custom.semaforo.SemaforoBinario;

public class Sucesion extends Thread {
    //Procesos sucesion
    private int a0,a1;
    private BufferInt contenedor;
    private SemaforoBinario sem1, sem2;

    public Sucesion (int a0, int a1, BufferInt c, SemaforoBinario sem1, SemaforoBinario sem2){
        this.a0 = a0;
        this.a1 = a1;
        this.contenedor = c;
        this.sem1 = sem1;
        this.sem2 = sem2;
    }

    @Override
    public void run(){
        int i = 0;
        System.out.println("\nHilo productor ID: "+Thread.currentThread().getId());
        try {
            System.out.println("\n["+Thread.currentThread().getId()+"]"+" Colocando elementos...");
            while(i < 20){
                sem1.WAIT();
                contenedor.poner(a0 + a1);
                System.out.println(contenedor.toString());
                sem2.SIGNAL();
                a0 = a1;
                a1 = contenedor.sacar();
                i++;
            }
        } catch (Exception e) {
            System.out.println("Se produjo un error en el productor\n");
        }
        System.out.println("\nFinalizó el hilo productor.");
    }

    @Override
    public String toString(){
        return "\nHilo productor: "+Thread.currentThread().getId();
    }
}