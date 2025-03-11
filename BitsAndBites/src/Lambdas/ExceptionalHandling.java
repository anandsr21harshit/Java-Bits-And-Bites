package Lambdas;

import java.util.function.BiConsumer;

public class ExceptionalHandling {

    public static void main(String[] args) {
        int[] someNumbers = {1,2,3,4};
        int key = 2;


        process(someNumbers,key,(v,k) -> System.out.println(v+k));
    }

    private static void process(int[] someNumbers, int key, BiConsumer<Integer,Integer> consumer) {
        for(int num : someNumbers){
           consumer.accept(num,key);
        }
    }
}
