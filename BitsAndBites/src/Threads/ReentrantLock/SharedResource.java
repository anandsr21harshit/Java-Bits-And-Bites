package Threads.ReentrantLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {

    boolean isAvailable = true;
    public void producer(ReentrantLock lock){
        try {
            lock.lock();
            System.out.println("ReentrantLock acquired by thread: " + Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
            System.out.println("ReentrantLock released by thread: " + Thread.currentThread().getName());
        }
    }

    public synchronized void producer(){
        try {
            System.out.println("ReentrantLock acquired by thread: " + Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("ReentrantLock released by thread: " + Thread.currentThread().getName());
        }
    }
}
