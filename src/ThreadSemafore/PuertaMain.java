package ThreadSemafore;

import java.util.concurrent.Semaphore;

public class PuertaMain {

    public static void main(String[] args) {
        int permisos = 1;

        Semaphore puerta = new Semaphore(permisos);

        for (int i = 1; i <= 4; i++) {
             ThreadPuerta Hilo = new ThreadPuerta(i,puerta);  
             Hilo.start();
        }

    }

}
