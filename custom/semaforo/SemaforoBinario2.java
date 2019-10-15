package custom.semaforo;

public class SemaforoBinario2 {
    protected int contador=0;
    protected int[] filaBloqueados; //IDs d los procesos bloqueados
    
    public SemaforoBinario2 (int valorinicial){
        contador = valorinicial;
    }

    synchronized public void WAIT(){
        contador --;
        if(contador < 0){
            //Agregar a la fila
            wait();
        }        
    }

    synchronized public void SIGNAL(){
        contador ++;
        if(contador <= 0){
            //Sacar un proceso de la fila
            notify();
        }
    }

    public String toString(){
        return String.valueOf(this.contador);
    }
}