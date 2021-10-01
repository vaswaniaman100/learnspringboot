package Groupingby;

import Streamapi.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeDataImplementation {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("Lucky");
        name.add("Lucky");
        name.add("Lucky");
        name.add("Lucky");
        name.add("Aman");
        name.add("Aman");
        name.add("Aman");
        name.add("Aman");


        List<Integer> age = new ArrayList<>();
        Map<String,Long> mapofed =name.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Map<String,Long> mapofed1 =name.stream().collect(Collectors.groupingBy(a->a,Collectors.counting()));
        System.out.println(mapofed);
        System.out.println(mapofed1);



        List<EmployeeData> listempdata = new ArrayList<>();
        listempdata.add(new EmployeeData("aman",22));
        listempdata.add(new EmployeeData("aman",22));
        listempdata.add(new EmployeeData("Lucky",23));
        listempdata.add(new EmployeeData("Lucky",23));
        Map<String,Integer> mapofed3 = listempdata.stream().collect(Collectors.groupingBy(e->e.getName(),Collectors.summingInt(e->e.getAge())));
        Map<String,Integer> mapofed4 = listempdata.stream().collect(Collectors.groupingBy(EmployeeData::getName,Collectors.summingInt(EmployeeData::getAge)));
        System.out.println(mapofed3);
        System.out.println(mapofed4);

    }
}
