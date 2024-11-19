/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recuperacionangel;

import java.util.ArrayList;
import java.util.List;


public class Aparcamientos {
    private static final int MAXIMO_APARCAMIENTOS = 5;
    
    private int numeroCoche = 0;

    public Aparcamientos() {
        
        
    }

    public int getNumeroCoche() {
        return numeroCoche;
    }
    
    public void entrar(Coche coche) throws InterruptedException {
        List<String> aparcamientos = new ArrayList<>();
        
        synchronized (this) {
            while ((numeroCoche + 1 >= MAXIMO_APARCAMIENTOS)) {

                System.out.printf("*** El coche con matricula %s debe esperar.\n", coche.getMatriculaCoche());
                this.wait();
            }
            numeroCoche++;
            
            System.out.printf(">>> El coche %s aparca. Coches Aparcados: %d.\n",
                    coche.getMatriculaCoche(), numeroCoche);
        }
    }
    
    public void salir(Coche coche) {
       synchronized (this) {
           numeroCoche--;
           this.notifyAll();
           System.out.printf(">>> El coche %s sale. Coches aparcados: %d .\n",
                    coche.getMatriculaCoche(), numeroCoche);
       } 
    }
    
    public void Garaje(Coche coche) {
        
    }
    
}
