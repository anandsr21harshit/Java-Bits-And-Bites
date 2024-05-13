package Threads;

public class Main {

    public static void main(String[] args) {
        MultiThreading runnableObj = new MultiThreading();
        CustomRunnable runnableObj2 = new CustomRunnable();

        // need to create thread class as Runnable is not a thread
        Thread thread = new Thread(runnableObj);
        Thread thread2 = new Thread(runnableObj2);

        thread.start();
        thread2.start();

        CustomThread customThread = new CustomThread();  // this class is already have all capabilities of Thread as this itself is a Thread class
        customThread.start();

        System.out.println("Finished main method: " + Thread.currentThread().getName());
    }
}
