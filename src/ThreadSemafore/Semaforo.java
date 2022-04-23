package ThreadSemafore;

import java.util.concurrent.Semaphore;

class SemaforoDemo {

    Semaphore semaforo = new Semaphore(10);

    public void permisos() {
        try {
            semaforo.acquire();
            System.out.println("Permiso adquirido");
            System.out.println("Permisos disponibles: " + semaforo.availablePermits());
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            semaforo.release();
            System.out.println("Permisos liberados");
            System.out.println("Permisos disponibles: " + semaforo.availablePermits());

        }
    }
    public static void main(String[] args) {
        final SemaforoDemo semaforodemo = new SemaforoDemo();
        
        Thread hilo = new Thread(){
            @Override
            public void run(){
                semaforodemo.permisos();
            }
        };
        
        hilo.start();
    }

}
