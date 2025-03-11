package Threads;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    boolean isAvailable = false;

    ReentrantLock lock = new ReentrantLock();

    public  void producer(ReentrantLock lock){
        try{
            lock.lock();
            Thread.sleep(1000);
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("Lock released by: " + Thread.currentThread().getName());
        }
    }

    public  void producer(){
        try{
            lock.lock();
            Thread.sleep(1000);
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("Lock released by: " + Thread.currentThread().getName());
        }
    }

}
