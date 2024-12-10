package PushPattern;

public class ConcreteSubscriber implements Subscriber{

    private String name;

    public ConcreteSubscriber(String name){
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}
