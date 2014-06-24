package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hariharank12 on 24/6/14.
 */
public class JavaFind {
    public static void main(String[] args) throws Exception {

        List<Employee> employees = new ArrayList<Employee>();
        for(int i = 0; i < 5; i++) {
            System.out.println("name = " + Integer.valueOf(i).toString() + " age = " + i * 10 + " salary =  " + i * 1000);
            employees.add(new Employee(Integer.valueOf(i).toString(), i * 10, i * 1000));
        }

        Employee result = MyCollection.findElement(employees);
        System.out.println("The result is : " + result.getAge());
        //System.out.println(result.getAge());


    }
}
