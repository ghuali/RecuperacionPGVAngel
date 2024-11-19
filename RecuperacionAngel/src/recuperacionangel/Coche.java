package recuperacionangel;

import java.util.logging.Level;
import java.util.logging.Logger;



public class Coche implements Runnable{
    private final String matriculaCoche;
    private final int tiempoConducido;
    private final int tiempoAparcado;
    private final Aparcamientos aparcamiento;

    public Coche(String matriculaCoche, int tiempoConducido, int tiempoAparcado, Aparcamientos aparcamiento) {
    this.matriculaCoche = matriculaCoche;
    this.tiempoConducido = tiempoConducido;
    this.tiempoAparcado = tiempoAparcado;
    this.aparcamiento = aparcamiento;
    }

    
    

    public String getMatriculaCoche() {
        return matriculaCoche;
    }

    public int getTiempoConducido() {
        return tiempoConducido;
    }

    public int getTiempoAparcado() {
        return tiempoAparcado;
    }
    
     @Override
    public void run(){
        try {
            System.out.printf(">>> El coche %s quiere Aparcar despues de conducir por %d segundos.\n" +
                    "    Coches Aparcados: %d.\n",
                    matriculaCoche, tiempoConducido,aparcamiento.getNumeroCoche());
            
            aparcamiento.entrar(this);
            
            try {
                Thread.sleep(tiempoAparcado * 100);
            } catch (InterruptedException e) {
                
            }
            
            aparcamiento.salir(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
                
        }
    }
}
