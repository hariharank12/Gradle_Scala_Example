package collection;

/**
 * Created by hariharank12 on 24/6/14.
 */
public class Employee implements MyFindable<Employee> {

    private String name;
    private int age;
    private int salary;

    private Employee() {

    }

    public Employee(String name, int age, int salary) {
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
    }

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean find(Employee o) {
        return this.age > o.age;
    }

}
