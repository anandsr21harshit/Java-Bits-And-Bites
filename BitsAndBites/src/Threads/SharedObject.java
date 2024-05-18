package Threads;

public class SharedObject {
    private int value = 0;

    public synchronized void increment(){
        value ++;
        System.out.println("Value incremented to " + value + " by thread: " + Thread.currentThread().getName());
    }
}
