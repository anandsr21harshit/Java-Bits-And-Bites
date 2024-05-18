package Threads;

public class CustomRunnable implements Runnable{

    private SharedObject sharedObject;

    public CustomRunnable(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            sharedObject.increment();
        }
    }
}
