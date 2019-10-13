package custom.semaforo;

import java.util.ArrayList;

public class BufferVector {
    //private int[] vector;
    private ArrayList<Integer> vector = new ArrayList<Integer>();

    public BufferVector(ArrayList<Integer> vector){        
        this.vector = vector;
    }

    public int leer(int i){
        try {
            return vector.get(i);
        } catch (Exception e) {
            System.out.println("\nError en el vector\n");
        }
        return Integer.MIN_VALUE;
    }

    public void agregarUltimo(int num){
        try {
            vector.add(num);
        } catch (Exception e) {
            System.out.println("\nError en el vector\n");
        }
    }

    public int extraerUltimo(){
        int aux;
        try {
            aux = vector.get(vector.size() - 1);
            vector.remove(vector.size() - 1);
            return aux;
        } catch (Exception e) {
            System.out.println("\nError en el vector: indice = "+vector.size());            
            System.exit(-1);
        } 
        return Integer.MIN_VALUE;
    }

    public void mostrar(){
        System.out.print("Vector: "+vector);
    }
}