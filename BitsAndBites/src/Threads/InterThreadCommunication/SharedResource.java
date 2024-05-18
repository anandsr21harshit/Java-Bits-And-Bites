package Threads.InterThreadCommunication;

public class SharedResource {

    boolean itemAvailable = false;

    public synchronized void addItem(){
        itemAvailable = true;
        System.out.println("Item added by: " + Thread.currentThread().getName() + " and invoking all threads which are waiting");
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("ConsumeItem method invoked by: " + Thread.currentThread().getName());

        // We are using while loop here instead of if condition to avoid
        // "spurious wake-up" condition
        while (!itemAvailable){
            try {
                System.out.println("Thread: " + Thread.currentThread().getName() + " is waiting");
                wait(); // it releases monitor lock
            }catch (Exception e){
                // handle exception
            }
        }

        itemAvailable = false;
        System.out.println("Item consumed by thread: " + Thread.currentThread().getName());
    }
}
