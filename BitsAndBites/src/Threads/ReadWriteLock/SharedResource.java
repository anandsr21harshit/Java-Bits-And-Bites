package Threads.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {

    boolean isAvailable = true;
    ReadWriteLock lock = new ReentrantReadWriteLock();
    public void producer(ReadWriteLock lock){
        try {
            lock.readLock().lock();
            System.out.println("Read lock acquired by thread: " + Thread.currentThread().getName());
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.readLock().unlock();
            System.out.println("Read lock released by thread: " + Thread.currentThread().getName());
        }
    }

    public void producer(){
        try {
            lock.readLock().lock();
            System.out.println("Read lock acquired by thread: " + Thread.currentThread().getName());
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.readLock().unlock();
            System.out.println("Read lock released by thread: " + Thread.currentThread().getName());
        }
    }

    public void consumer(ReadWriteLock lock){
        try {
            lock.writeLock().lock();
            System.out.println("Write lock acquired by thread: " + Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.writeLock().unlock();
            System.out.println("Write lock released by thread: " + Thread.currentThread().getName());
        }
    }

    public void consumer(){
        try {
            lock.writeLock().lock();
            System.out.println("Write lock acquired by thread: " + Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.writeLock().unlock();
            System.out.println("Write lock released by thread: " + Thread.currentThread().getName());
        }
    }
}
