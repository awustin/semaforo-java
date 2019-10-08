package custom.semaforo;

public class BufferInt{
    private int valor;

    public BufferInt(){;}
    
    public BufferInt(int i){
        this.valor = i;
    }



    public void poner(int i){
        this.valor = i;
    }

    public int sacar(){
        return this.valor;
    }

    public String toString(){
        return "\nBUFFER: "+String.valueOf(valor);
    }
}