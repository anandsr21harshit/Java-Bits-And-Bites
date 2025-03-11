package Threads.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        SharedResource sharedResource2 = new SharedResource();
        SharedResource sharedResource3 = new SharedResource();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread t1 = new Thread(() -> {
            sharedResource.producer();
        });

        Thread t2 = new Thread(() -> {
            sharedResource2.producer();
        });

        Thread t3 = new Thread(() -> {
            sharedResource3.consumer();
        });
        t1.setDaemon(true);
        t2.setDaemon(true);
        t3.setDaemon(true);
        t1.start();
        t2.start();
        t3.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
