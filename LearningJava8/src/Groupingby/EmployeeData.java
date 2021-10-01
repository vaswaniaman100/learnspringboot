package Groupingby;

public class EmployeeData {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    String name;
    int age;

    public EmployeeData(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
