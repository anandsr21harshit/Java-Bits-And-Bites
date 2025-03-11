package Threads.InterThreadCommunication;

public class Main {
    public static void main(String[] args) {
        SharedResource obj = new SharedResource();
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(8000); // making this thread sleep so that consumeItem() is executed first
            } catch (InterruptedException e) {
                // handle exception
            }
            obj.addItem();
        });

        Thread t2 = new Thread(() -> {
            obj.consumeItem();
        });

        t1.start();
        t2.start();
    }
}
