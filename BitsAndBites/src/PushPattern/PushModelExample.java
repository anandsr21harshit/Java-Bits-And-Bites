package PushPattern;

public class PushModelExample {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        Subscriber subscriber1 = new ConcreteSubscriber("Subscriber1");
        Subscriber subscriber2 = new ConcreteSubscriber("Subscriber2");

        publisher.addSubscriber(subscriber1);
        publisher.addSubscriber(subscriber2);

        System.out.println("Sending message from Publisher...");
        publisher.updateAllSubscribers("File saved in S3 bucket");
        System.out.println();
        System.out.println("Sending another message from Publisher...");
        publisher.updateAllSubscribers("System under maintenance");
        System.out.println();
        publisher.removeSubscriber(subscriber2);
        System.out.println("Sending message after unsubscribing subscriber2");
        publisher.updateAllSubscribers("System still under maintenance");

    }
}
