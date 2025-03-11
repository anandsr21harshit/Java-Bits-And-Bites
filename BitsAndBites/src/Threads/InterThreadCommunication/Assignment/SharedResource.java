package Threads.InterThreadCommunication.Assignment;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class SharedResource {
    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public SharedResource(int bufferSize){
        sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) {

        while(sharedBuffer.size() == bufferSize){
            System.out.println("Buffer is full, producer is waiting for consumer");
            try {
                wait();
            } catch (InterruptedException e) {
                // handle exception
            }
        }
        sharedBuffer.add(item);
        System.out.println("Produced: " + item);

        // notify all consumer there is item to consume now
        notify();
    }

    public synchronized int consume() {

        while (sharedBuffer.isEmpty()){
            // do not consume
            System.out.println("Buffer is empty, consumer is waiting for producer");
            try {
                wait();
            } catch (InterruptedException e) {
                // handle exception
            }
        }
        int consumeItem = sharedBuffer.poll();
        System.out.println("Consumed item: " + consumeItem);
        notify();
        return consumeItem;
    }
}
