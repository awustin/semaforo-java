package custom.semaforo;

public class SemaforoGeneral extends SemaforoBinario {

    public SemaforoGeneral (int valorinicial){
        super(valorinicial); 
    }

    synchronized public void SIGNAL(){
        contador ++;
        notify();
    }
    
    public String toString(){
        return String.valueOf(this.contador);
    }
}