package Exceptions.UnsupportedOperationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(156, 141, 35, 11, 72, 39, 56);

        // adding new elements
        list.add(23);   // will throw UnsupportedOperationException


        // FIX

        /* Uncomment below code and comment line 9 and 12 */

//        List<Integer> list2 = new ArrayList<>(Arrays.asList(156, 141, 35, 11, 72, 39, 56));
//        list2.add(22);
//
//        System.out.println(list2);
    }



}
