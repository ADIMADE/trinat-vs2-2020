package Threads01.u09;

public class StartStopThread {

    public static void main(String[] args) {
        StopThread st = new StopThread();
        System.out.println("Programm - Start!");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {

        }

        System.out.println("Programm - Nach 10ms Verzögerung");
        st.stopThread();
        System.out.println("Programm - Beendet!");
    }

}

class StopThread extends Thread {
    private boolean stopped = false;

    public StopThread() {
        start();
    }

    public synchronized void stopThread() {
        stopped = true;
    }

    public synchronized boolean isStopped() {
        return stopped;
    }

    public void run() {
        int i = 0;
        while (!isStopped()) {
            i++;
            System.out.println("Zaälvariabel: " + i);
        }
        System.out.println("Thread endet jetzt!");
    }

}