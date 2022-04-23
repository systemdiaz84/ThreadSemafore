package ThreadSemafore;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadPuerta extends Thread {

    private int persona;
    private Semaphore puerta;
    int tiempo = 0;

    public ThreadPuerta(int persona, Semaphore puerta) {
        this.persona = persona;
        this.puerta = puerta;
    }

    private void camina() {

        int distancia = 0;
        
        System.out.println("PERSONA " + this.persona + " COMENZÓ A CAMINAR");

        while (distancia < 200) {
            distancia += (int) (Math.random() * 2) + 4;
            tiempo += 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadPuerta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("PERSONA " + this.persona + " LLEGÓ PUERTA EN "+tiempo+" SEG.");
        tiempo=0;

    }

    @Override
    public void run() {
        camina();
        
        try {
            puerta.acquire();
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            puerta.release();
            System.out.println("PERSONA " + this.persona + " PASÓ LA PUERTA");
        }

    }

}
