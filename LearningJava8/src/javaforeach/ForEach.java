package javaforeach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        li.add(26);
        li.add(26);
        li.add(26);
        li.add(26);
        li.add(26);
        li.add(26);
        li.add(27);
        li.forEach( a-> System.out.print(a+" "));
        System.out.println();
        System.out.println();
        li.forEach(System.out::println);

        int arr[] ={1,2,3,4};
        Arrays.stream(arr).filter(x->x>1).forEach(System.out::println);
    }
}
