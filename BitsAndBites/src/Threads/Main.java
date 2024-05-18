package Threads;

public class Main {

    public static void main(String[] args) {
        MultiThreading runnableObj1 = new MultiThreading();

        CustomRunnable runnableObj2 = new CustomRunnable();

        // need to create thread class as Runnable is not a thread
        Thread thread1 = new Thread(runnableObj1);
        Thread thread2 = new Thread(runnableObj2);


//        thread1.start();
//        thread2.start();


        CustomThread customThread = new CustomThread();  // this class is already have all capabilities of Thread as this itself is a Thread class
//        customThread.start();

        MonitorLockExample obj = new MonitorLockExample();
        Thread thread3 = new Thread(() -> obj.task1());
        Thread thread4 = new Thread(() -> obj.task2());
        Thread thread5 = new Thread(() -> obj.task3());

        thread3.start();
        thread4.start();
        thread5.start();

//        System.out.println("Finished main method: " + Thread.currentThread().getName());
    }
}
