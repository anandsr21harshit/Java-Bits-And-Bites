package Lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Exercise1 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles","Dickens", 60),
                new Person("Lewis","Carroll", 42),
                new Person("Matthew","Arnold", 39),
                new Person("Thomas","Chen", 55)
        );

        // sort list by last name
        // using java7 <
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                // lexographical sorting
                return p1.getLastName().compareTo(p2.getLastName());
            }
        });


        // using java8
        Collections.sort(people, (p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));


        // a method to print all the elements in the list
        printAll(people);

        // create a method that prints all name that starts with letter c
        printLastNameStartWithC(people);

        printsConditionally(people, p -> p.getFirstName().startsWith("L"));
    }

    private static void printsConditionally(List<Person> people, Predicate<Person> predicate ){
        for(Person p : people){
            if(predicate.test(p)){
                System.out.println(p);
            }
        }
    }

    private static void printLastNameStartWithC(List<Person> people) {
        for(Person p : people){
            if(p.getLastName().startsWith("C")){
                System.out.println(p);
            }
        }
    }

    private static void printAll(List<Person> people) {
        for (Person p : people){
            System.out.println(p);
        }
    }
}
