package Lambdas;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}
public class Exercise2 {

    // 1. Given a list of strings, sort them by their length in ascending order.
    // List<String> list = ["apple", "banana", "kiwi", "grape"]
    // output: [kiwi, grape, apple, banana]

    public static void sortList(List<String> list){
        list.sort(Comparator.comparingInt(String::length));
    }

    // 2. Given a list of words, find the first word that starts with "b".
    // ["apple", "banana", "cherry", "blueberry"]
    // Output: banana

    public static String findFirstWordStartsWithB(List<String> list){
        Optional<String> firstWord = list.stream().filter(word -> word.toLowerCase().startsWith("b"))
                .findFirst();
        return firstWord.orElse("No Such word exist");
    }

    public static List<String> convertEachItemToUpperCase(List<String> list){
        return list.stream().map(String::toUpperCase).toList();
    }

    // remove duplicates from list
    public static List<Integer> removeDuplicates(List<Integer> list){
        return list.stream().distinct().toList();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "kiwi", "grape");
        sortList(list);
        System.out.println(list);

        List<String> words = Arrays.asList("apple","cherry");
        System.out.println(findFirstWordStartsWithB(words));

        System.out.println(convertEachItemToUpperCase(list));

        List<Integer> numbers = Arrays.asList(1,1,1,2,3,5,6,6,7,7,5);
        System.out.println(removeDuplicates(numbers));

        System.out.println(list.stream().collect(Collectors.groupingBy(String::length)));

        //group all even and odd
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Map<String, List<Integer>> evenOddMap = integers.stream().collect(Collectors.groupingBy(num -> num % 2 == 0 ? "Even" : "Odd"));
        System.out.println(evenOddMap);

        // group vowels by count
        // String s = "abcaaceei"
        // Output: {a=3,e=2,i=1}
        String s = "abcaaceei";
        Set<Character> vowelSet = Set.of('a','e','i','o','u');
        Stream<Character> characterStream = s.toLowerCase().chars()
                .mapToObj(c -> (char) c);
        Map<Character, Long> vowelMap = s.chars()
                .mapToObj(c -> (char) c)
                .filter(vowelSet::contains)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(vowelMap);

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Charlie", "HR"),
                new Employee("David", "IT"),
                new Employee("Eve", "Finance")
        );

        //  Given a list of employees, group them by their department.
        Map<String, List<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.department));
        System.out.println(collect);

        //Instead of listing employees, count how many belong to each department.
        Map<String, Long> employeeCountDepartmentWise = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.department,Collectors.counting()));
        System.out.println(employeeCountDepartmentWise);
    }
}
