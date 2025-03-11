package Lambdas;

public class Greeter {

    public void greet(Greeting greeting){
        greeting.perform();
    }
    public static void main(String[] args) {
        Greeter greeter = new Greeter();

        Greeting helloWorldGreeting = new HelloWorldGreeting();
        Greeting lambdaGreeting = () -> System.out.println("Hello World !!");

        // anonymous inner class
        Greeting innerGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hello World from Inline !!");
            }
        };

        helloWorldGreeting.perform();
        lambdaGreeting.perform();
        innerGreeting.perform();
    }
}
