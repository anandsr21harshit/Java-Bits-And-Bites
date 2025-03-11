package Threads.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        SharedResource sharedResource1 = new SharedResource();
        SharedResource sharedResource2 = new SharedResource();

        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            sharedResource.producer(lock);
//            sharedResource.producer();
        });

        Thread t2 = new Thread(() -> {
            sharedResource1.producer(lock);
//            sharedResource.producer();
//            sharedResource1.producer();
        });

        Thread t3 = new Thread(() -> {
            sharedResource2.producer(lock);
//            sharedResource.producer();
//            sharedResource2.producer();
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
