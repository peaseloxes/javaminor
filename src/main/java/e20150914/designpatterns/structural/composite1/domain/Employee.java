package e20150914.designpatterns.structural.composite1.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/14/15.
 */
public class Employee {
    @Getter
    private String name;

    private int salary;

    @Getter
    private List<Employee> subordinates;

    public Employee(String name, int salary){
        subordinates = new ArrayList<>();
        this.name = name;
        this.salary = salary;
    }

    public void addSubordinate(Employee e){
        subordinates.add(e);
    }

    public int getNestedSubordinates(){
        int total = 0;

        for (Employee subordinate : subordinates) {
            total += subordinate.getNestedSubordinates();
        }

        return subordinates.size() + total;
    }

    public int calculateSubordinateWorth(){
        int total = 0;

        for (Employee subordinate : subordinates) {
            total+=subordinate.calculateSubordinateWorth();
        }

        return total + salary;
    }

}
