package PushPattern;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private List<Subscriber> subscribers = new ArrayList<>();

    // add subscribers
    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    // remove subscribers
    public void removeSubscriber(Subscriber subscriber){
        subscribers.remove(subscriber);
    }

    // update subscribers
    public void updateAllSubscribers(String update){
        for(Subscriber subscriber : subscribers){
            subscriber.update(update);
        }
    }
}
