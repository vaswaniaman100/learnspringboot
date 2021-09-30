package javaforeach;

import java.util.Arrays;

public class VarargsExample1{

    static void display(String... values){
        int i =0;
   Arrays.stream(values).forEach(a-> {System.out.println(a);System.out.println(a);});
        System.out.println(values.getClass().getName());
        System.out.println("display method invoked ");
    }

    public static void main(String args[]){

        display();//zero argument
        display("my","name","is","varargs");//four arguments
    }
}  