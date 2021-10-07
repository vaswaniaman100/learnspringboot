package GroupBy;

import java.util.*;
import java.util.stream.Collectors;

public class Implement {
    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<>();
        emp.add( new Employee(1,"aman","Lucky",23));
        emp.add(new Employee(2,"aakash","piyush",24));
        emp.add(new Employee(3,"aman","Lucky",25));
        emp.add(new Employee(4,"aman","Lucky",23));



        List<Manager> man = new ArrayList<>();
        man.add(new Manager(1,"lucky",55));
        man.add(new Manager(2,"piysh",56));


        Map<String,Map<String,List<Employee>>> ma = emp.stream().collect
                (Collectors.groupingBy(Employee::getName,
                        Collectors.groupingBy(Employee::getManager,Collectors.toList())));
        System.out.println(ma);

        System.out.println();
        System.out.println();
        Map<String,Map<String,List<Employee>>> ma1 = emp.stream().collect
                (Collectors.groupingBy(Employee::getName,
                        Collectors.groupingBy(Employee::getManager,Collectors.collectingAndThen(Collectors.mapping(m-> m,Collectors.toList()),employees -> employees))));
        System.out.println(ma1);
        System.out.println();
        System.out.println();

        System.out.println(emp.stream().map(m->new Employee(m.getId(),m.getName(),m.getManager(),m.getAge()+30)).sorted((s1,s2)->s1.getAge() <s2.getAge()?1:-1).filter(m->m.getAge()>54).collect(Collectors.toList()));
        System.out.println(emp.stream().map(m->new Employee(m.getId(),m.getName(),m.getManager(),m.getAge()-2)).sorted((s1,s2)->s1.getAge() >s2.getAge()?1:-1).collect(Collectors.toList()));
        System.out.println(emp.stream().map(m->new Employee(m.getId(),m.getName(),m.getManager(),m.getAge()*3)).collect(Collectors.toList()));
        System.out.println(emp.stream().map(m->new Employee(m.getId(),m.getName(),m.getManager(),m.getAge()/2)).collect(Collectors.toList()));
        System.out.println();
        System.out.println(emp.stream().sorted((s1,s2)->s1.getName().compareTo(s2.getName())).collect(Collectors.toList()));
        Collections.sort(emp,new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getManager().compareTo(o2.getManager());
            }
        });
        System.out.println(emp);
    }
}
