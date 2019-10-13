package custom;

import custom.operaciones.*;
import custom.semaforo.*;

public class Problemas {
    public static void main(String[] args) {
        /*
            SEA UNA SUCESION EN LA QUE CADA ELEMENTO ES LA SUMA DE LOS DOS ANTERIORES
                a(i) = a(i-1) + a(i-2)
            EL PROGRAMA DEBE CALCULAR LA SUMA PARCIALES DE LOS TERMINOS IMPARES, 
            UTILIZANDO SEMÁFOROS
        */
        System.out.print("\n\n**********************************************************************************************\n");
        System.out.print("******************** PROBLEMA DE LA SUMA DE LOS ELEMENTOS DE UNA SUCESION ********************\n");
        System.out.print("**********************************************************************************************\n\n");
        
        System.out.print("\nVariables...\n");
        BufferInt s = new BufferInt();
        SemaforoBinario sem1 = new SemaforoBinario(1);
        SemaforoBinario sem2 = new SemaforoBinario(1);
        Sucesion productorSucesion = new Sucesion(0,1,s,sem1,sem2);
        Suma consumidorSuma = new Suma(s,sem1,sem2);

            
        System.out.print(s.toString());
        System.out.print("\nsem1 = "+sem1.toString());
        System.out.print("\nsem2 = "+sem2.toString());

        //Procesos
        System.out.print("\n\nHilos...\n");
        productorSucesion.start();
        consumidorSuma.start();
    }
}


