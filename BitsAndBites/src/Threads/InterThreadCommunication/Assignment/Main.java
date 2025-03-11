package Threads.InterThreadCommunication.Assignment;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

    public static void main(String[] args)  {

        SharedResource sharedResource = new SharedResource(3);

        Thread producerThread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i=0;i<6;i++) {
                sharedResource.produce(i);
            }
        });

        Thread consumerThread = new Thread(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            for(int i=0;i<6;i++){
                sharedResource.consume();
            }
        });

        producerThread.start();
        consumerThread.start();

    }
}
