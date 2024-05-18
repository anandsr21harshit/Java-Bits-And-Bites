package Threads;

public class CustomRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Code executed by CustomRunnable: " + Thread.currentThread().getName());
    }
}
