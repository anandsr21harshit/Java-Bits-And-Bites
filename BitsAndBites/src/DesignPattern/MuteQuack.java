package DesignPattern;

public class MuteQuack implements QuackBehaviour{
    @Override
    public void quack() {
        // code here
        System.out.println("<<Silence>>");
    }
}
