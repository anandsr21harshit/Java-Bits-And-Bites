package Threads;

public class MultiThreading implements Runnable{

    @Override
    public void run() {
        System.out.println("Code executed by Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Completed task in thread: " + Thread.currentThread().getName());
    }
}
