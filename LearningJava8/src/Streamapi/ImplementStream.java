

package Streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImplementStream {
    public static void main(String[] args) {
        List<Employee> li = new ArrayList<Employee>();
        Employee emp = new Employee(1,"aman","Chalisgaon");
        li.add(emp);
        emp = new Employee(1,"Lucky","Chalisgaon");
        li.add(emp);
        System.out.println(li);
        List<String> lia = li.stream()
                .filter(m->m.name.startsWith("a"))
                .map(m->m.name)
                .collect(Collectors.toList());
        System.out.println(lia);


    }
}