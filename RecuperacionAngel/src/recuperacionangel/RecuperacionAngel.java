
package recuperacionangel;

import java.util.Random;


public class RecuperacionAngel {


    public static void main(String[] args) {
        final int MINIMO_TIEMPO_CONDUCIDO = 1;
        final int MAXIMO_TIEMPO_CONDUCIDO = 30;
        final int MINIMO_TIEMPO_APARCADO = 10;
        final int MAXIMO_TIEMPO_APARCADO = 50;
        final int MINIMO_MATRICULA = 1;
        final int MAXIMO_MATRICULA = 50;
        
        final Aparcamientos aparcamiento = new Aparcamientos();
        String matriculaCoche = "";
        int tiempoConducido = 0;
        int tiempoAparcado = 0;
        
        int numeroCoche = 0;
        while (true){
            numeroCoche++;
            matriculaCoche = "L"+ numeroAleatorio(MINIMO_MATRICULA,MAXIMO_MATRICULA);
            tiempoConducido = numeroAleatorio(MINIMO_TIEMPO_CONDUCIDO, MAXIMO_TIEMPO_CONDUCIDO);
            tiempoAparcado = numeroAleatorio(MINIMO_TIEMPO_APARCADO, MAXIMO_TIEMPO_APARCADO);
            System.out.printf("El coche con matricula %s ha conducido por %d segundos y se quedara aparcado %d segundos.\n",
                    matriculaCoche, tiempoConducido, tiempoAparcado);
            Thread hiloCoche = new Thread(new Coche(matriculaCoche, tiempoConducido,tiempoAparcado, aparcamiento));
            try {
                Thread.sleep(tiempoConducido * 50);
            } catch (InterruptedException e) {
                
            }
            
            hiloCoche.start();
        }
    }
    
    public static int numeroAleatorio(int valorMinimo, int valorMaximo) {
        Random r = new Random();
        return valorMinimo + r.nextInt(valorMaximo - valorMinimo + 1);
    }
    
}