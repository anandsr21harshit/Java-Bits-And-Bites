package Threads;

public class CustomThread extends Thread{
    @Override
    public void run() {
        System.out.println("Inside Custom Thread by extending Thread class: " + Thread.currentThread().getName());
    }
}
