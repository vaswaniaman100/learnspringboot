package GroupBy;

public class Employee {
    int id;
    String name;
    String Manager;
    int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return Manager;
    }

    public void setManager(String manager) {
        Manager = manager;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(int id, String name, String manager, int age) {
        this.id = id;
        this.name = name;
        Manager = manager;
        this.age = age;
    }
    Employee(){}

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Manager='" + Manager + '\'' +
                ", age=" + age +
                '}';
    }
}
